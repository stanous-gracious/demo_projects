package com.ticket.reservation.service;

import com.ticket.reservation.model.Constants;
import com.ticket.reservation.model.*;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Service class to process the seat booking request from the user
 */
public class TicketServiceImpl implements TicketService {

    private Reservation reservation;
    private final static Logger log = Logger.getLogger(TicketServiceImpl.class);
    private static final ReentrantLock lock = new ReentrantLock();

    /**
     * 
     * @param numSeats the number of seats to find and hold
     * @param customerEmail unique identifier for the customer
     * @return
     */
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

        lock.lock();
        SeatHold seatHold = new SeatHold(customerEmail, numSeats);
        try {
            while (numSeats != 0) {

                HallRow selectedRow = bookSeats(numSeats);
                if (selectedRow != null) {
                    List<HallSeat> seats = reservation.getReservationMap().get(selectedRow);

                    // start to end available seats
                    int beginSeatId = seats.size() - selectedRow.getAvailableSeatsInRow() + 1;
                    int onHoldSeats = Math.min(numSeats, selectedRow.getAvailableSeatsInRow());
                    int endSeatId = beginSeatId + onHoldSeats - 1;

                    // mark the seats as on hold
                    seatHold.getRequestedSeats().put(selectedRow.getRowId(), String.valueOf(beginSeatId + Constants.delimiter + endSeatId));

                    //changing the status of seats to on hold
                    seats.subList(beginSeatId - 1, endSeatId).forEach((seat) -> seat.setStatus(BookingStatus.ONHOLD_FOR_RESERVATION));

                    // update the seats in current row with allocated seats
                    selectedRow.putOnHoldSeatsInRow(onHoldSeats);
                    // updated the reservation map for allocated seats
                    reservation.putOnHoldTotalSeats(onHoldSeats);

                    numSeats -= onHoldSeats;
                } else {
                    numSeats = 0;
                }
            }
        }finally{
            lock.unlock();
        }
        log.info("--------------------------------------");
        log.info("On hold seats before reservation");
        reservation.print();
        log.info("--------------------------------------");
        return seatHold;
    }

    /**
     * Custom Logic to fill the reservation map for booking the seats
     * @param numSeats
     * @return
     */
    private HallRow bookSeats(int numSeats) {

        //Get all Rows where the seats are available to reserve
        List<HallRow> rows = reservation.getReservationMap().keySet().stream().filter(row -> row.getAvailableSeatsInRow() > 0)
                .collect(Collectors.toList());
        // if booking seats are less then available seats in row -> book them
        if(numSeats < rows.get(0).getAvailableSeatsInRow()) {
            return rows.get(0);
        }
        // if booking seats are greater then entire available row --> book the entire row
        if(numSeats > rows.get(rows.size()-1).getAvailableSeatsInRow()) {
            return rows.get(rows.size()-1);
        }

        for(HallRow row : rows)
        {
            // exact number of booking seats are matching with available seats
            if(row.getAvailableSeatsInRow() == numSeats){
                return row;
            }//first fill the row which has few empty seats and then pickup next row for second iteration
            else if(row.getAvailableSeatsInRow() > 0 && row.getAvailableSeatsInRow() < numSeats){
                return row;
            }
        }//end of for

        //no match found
        return null;
    }

    /**
     * reset the hold seats
     * @param seatHold
     */
    public void resetHeldSeats(SeatHold seatHold) {
        seatHold.getRequestedSeats().entrySet().forEach(selectedRow -> {
            updateHeldSeatStatus(selectedRow, BookingStatus.ONHOLD_FOR_RESERVATION, BookingStatus.OPEN_FOR_RESERVATION);
            reservation.getReservationMap().entrySet().forEach(row -> {
                if(row.getKey().getRowId() == selectedRow.getKey()) {
                    row.getKey().releaseSeatsInRow(getNumSeatsHeldOrReserved(selectedRow.getValue()));
                }
            });
        });
        reservation.releaseTotalSeats(seatHold.getTotalSeats());
        log.info("--------------------------------------");
        log.info("Seats Available after removing hold");
        reservation.print();
        log.info("--------------------------------------");
    }

    /**
     * Reserve the seats and return the confirmation code to the user
     * @param seatHold holds the multiple booking by the user
     * @param customerEmail the email address of the customer to which the seat hold is assigned
     * @return
     */
    public String reserveSeats(SeatHold seatHold, String customerEmail) {
        seatHold.getRequestedSeats().entrySet().forEach((entry) -> {
            updateHeldSeatStatus(entry, BookingStatus.ONHOLD_FOR_RESERVATION, BookingStatus.RESERVATION_CONFIRMED);
        });
        seatHold.print();
        log.info("--------------------------------------");
        log.info("Seats Available after completing Reservation");
        reservation.print();
        log.info("--------------------------------------");
        return seatHold.getConfirmationCode();
    }

    /**
     * changing the status of booked seats in reservation map
     * @param entry
     * @param fromStatus
     * @param toStatus
     */
    private void updateHeldSeatStatus(Map.Entry<Integer, String> entry, BookingStatus fromStatus, BookingStatus toStatus) {
        reservation.getReservationMap().get(new HallRow(entry.getKey()))
                .subList(Integer.parseInt(entry.getValue().split(Constants.delimiter)[0]) - 1,
                        Integer.parseInt(entry.getValue().split(Constants.delimiter)[1]))
                .forEach((seat) -> {
                    if(seat.getStatus() == fromStatus) {
                        seat.setStatus(toStatus);
                    }
                });
    }

    private static int getNumSeatsHeldOrReserved(String value) {
        String[] values = value.split(Constants.delimiter);
        return Integer.parseInt(values[1]) - Integer.parseInt(values[0]) + 1;
    }

    public TicketServiceImpl(Reservation reservation) {
        this.reservation = reservation;
    }
    public int numSeatsAvailable() {
        return reservation.getTotalOpenSeats();
    }


}
