package com.ticket.reservation.service;

import com.ticket.reservation.model.Constants;
import com.ticket.reservation.model.BookingStatus;
import com.ticket.reservation.model.HallRow;
import com.ticket.reservation.model.Reservation;
import com.ticket.reservation.model.SeatHold;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;


public class TicketServiceTest {

    private final static Logger log = Logger.getLogger(TicketServiceTest.class);

    @Test
    public void testTotalAvailableSeats() {
        int rows = 10;
        int seatsPerHallRow = 10;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        int total = ticketService.numSeatsAvailable();
        Assert.assertTrue("Zero seats are booked", total == rows * seatsPerHallRow);
    }

    @Test
    public void testSingleHallRowReservation() {
        int rows = 1;
        int seatsPerHallRow = 5;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        SeatHold seatHold = ticketService.findAndHoldSeats(5, "test.demo@gmail.com");

        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("All Seats Booked", ticketService.numSeatsAvailable() == 0);
        validateSeats(seatHold, reservation, BookingStatus.ONHOLD_FOR_RESERVATION);

        String confirmationCode = ticketService.reserveSeats(seatHold, seatHold.getCustomerEmail());
        log.debug("Confirmation Code is" + confirmationCode);
        validateSeats(seatHold, reservation, BookingStatus.RESERVATION_CONFIRMED);
    }

    @Test
    public void testMultiHallRowReservation() {
        int rows = 2;
        int seatsPerHallRow = 5;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        SeatHold seatHold = ticketService.findAndHoldSeats(9, "test.demo@gmail.com");
        validateSeats(seatHold, reservation, BookingStatus.ONHOLD_FOR_RESERVATION);
        String confirmationCode = ticketService.reserveSeats(seatHold, seatHold.getCustomerEmail());
        log.debug("Confirmation Code is" + confirmationCode);
        validateSeats(seatHold, reservation, BookingStatus.RESERVATION_CONFIRMED);
    }

    @Test
    public void testResetHeldReservation() {
        int rows = 1;
        int seatsPerHallRow = 5;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        SeatHold seatHold = ticketService.findAndHoldSeats(5, "test.demo@gmail.com");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is Zero", ticketService.numSeatsAvailable() == 0);
        validateSeats(seatHold, reservation, BookingStatus.ONHOLD_FOR_RESERVATION);

        ticketService.resetHeldSeats(seatHold);
        Assert.assertTrue("Available count is 5", ticketService.numSeatsAvailable() == 5);
        validateSeats(seatHold, reservation, BookingStatus.OPEN_FOR_RESERVATION);
    }

    @Test
    public void testMulipleUserReservation() {
        int rows = 5;
        int seatsPerHallRow = 10;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        SeatHold seatHold = ticketService.findAndHoldSeats(10, "Jack");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 40", ticketService.numSeatsAvailable() == 40);

        seatHold = ticketService.findAndHoldSeats(5, "Smith");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 35", ticketService.numSeatsAvailable() == 35);

        seatHold = ticketService.findAndHoldSeats(4, "John");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 31", ticketService.numSeatsAvailable() == 31);

        seatHold = ticketService.findAndHoldSeats(10, "Harry");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 21", ticketService.numSeatsAvailable() == 21);

        seatHold = ticketService.findAndHoldSeats(2, "Rob");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 19", ticketService.numSeatsAvailable() == 19);
    }

    @Test
    public void testMiniumNoOfHallRows() {
        int rows = 1;
        int seatsPerHallRow = 10;
        Reservation reservation = new Reservation(rows, seatsPerHallRow);
        reservation.print();
        TicketService ticketService = new TicketServiceImpl(reservation);
        SeatHold seatHold = ticketService.findAndHoldSeats(5, "test.demo@gmail.com");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 5", ticketService.numSeatsAvailable() == 5);
        validateSeats(seatHold, reservation, BookingStatus.ONHOLD_FOR_RESERVATION);

        seatHold = ticketService.findAndHoldSeats(5, "john");
        
        Assert.assertNotNull("Seats held should not be null", seatHold);
        Assert.assertTrue("Available count is 0", ticketService.numSeatsAvailable() == 0);
        validateSeats(seatHold, reservation, BookingStatus.ONHOLD_FOR_RESERVATION);

    }

    private void validateSeats(SeatHold seatHold, Reservation reservation, BookingStatus status) {
        seatHold.getRequestedSeats().entrySet().forEach(entry -> {
            reservation.getReservationMap().get(new HallRow(entry.getKey()))
                    .subList(Integer.parseInt(entry.getValue().split(Constants.delimiter)[0]) - 1,
                            Integer.parseInt(entry.getValue().split(Constants.delimiter)[1]) - 1).forEach(reservationEntry -> {
                Assert.assertTrue("Booking Status is hold/confirmed", reservationEntry.getStatus() == status);
            });
        });
    }
}
