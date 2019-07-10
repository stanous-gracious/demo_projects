package com.ticket.reservation.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Stan Gracious on 7/6/2019.
 * This class holds all reservation for seats booked, it is multi-dimensional array of rows and seats objects
 *
 */
public class Reservation {

    private int totalOpenSeats;

    private HashMap<HallRow, List<HallSeat>> reservationMap = new HashMap<>();
    private final static Logger logger = Logger.getLogger(Reservation.class);

    /**
     * Create multi-dimensional array ready for the reservation
     * reservation map is updated based on seats booked, cancelled seats and temporary seats on hold
     * reservation map also gives the view of the reservation done based on the seat status
     * @return
     */
    public HashMap<HallRow, List<HallSeat>> getReservationMap() {
        return reservationMap;
    }

    public Reservation(int rows, int seats) {
        for(int i = 1; i <= rows; i++) {
            List<HallSeat> hallSeats = new ArrayList<>();
            for(int j = 1; j <= seats; j++) {
                hallSeats.add(new HallSeat(j, BookingStatus.OPEN_FOR_RESERVATION));
            }
            HallRow hallRow = new HallRow(i, seats);
            reservationMap.put(hallRow,hallSeats);
        }
        this.totalOpenSeats = rows * seats;
    }

    public int getTotalOpenSeats() {
        return totalOpenSeats;
    }

    public void releaseTotalSeats(int numSeats) { this.totalOpenSeats = this.getTotalOpenSeats() + numSeats; }

    public void putOnHoldTotalSeats(int numSeats) { this.totalOpenSeats = this.getTotalOpenSeats() - numSeats; }

    public void print() {
        this.reservationMap.entrySet().forEach(row ->{
            logger.debug(row.getKey() + " " + row.getValue());
        });
    }


}
