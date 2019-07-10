package com.ticket.reservation;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.ticket.reservation.model.Reservation;
import com.ticket.reservation.model.SeatHold;
import com.ticket.reservation.service.TicketService;
import com.ticket.reservation.service.TicketServiceImpl;
import org.apache.log4j.Logger;
import java.util.*;

/**
 * Created by Stan Gracious on 7/7/2019.
 * Main Class to demonstrate the core functionality for booking seats via Command Line and Scanner object
 * For Demo 50 rows are allocated to reservation map
 */

public class TicketBookingProcessor {
    private final static Logger log = Logger.getLogger(TicketBookingProcessor.class);

    private static Reservation reservation;
    private static TicketService ticketService;
    private static Table<String, String, SeatHold> seatHoldTable = HashBasedTable.create();
    private static Timer timer;

    /**
     * Main method to be called from command line
     * @param args
     */
        public static void main (String[] args)
        {
            reservation = new Reservation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            ticketService = new TicketServiceImpl(reservation);
            Scanner scanner = new Scanner(System.in);
            try {
                log.info("Welcome to Ticket Booking Application");
                userChoice(scanner);
            }catch(Exception e){
                log.error("Exception Processing Booking Tickets \n"+ e.getMessage());
                log.error("Please try again \n"+ e.getMessage());
                userChoice(scanner);
            }
        }

    /**
     * User is given the options to select while booking seats
     * @param scanner
     */
    private static void userChoice(Scanner scanner) {
            String userDisplay = "\n---------- Enter your choice: ---------\n";
            userDisplay += "1. Book Seats\n";
            userDisplay += "2. Show total Available Seats\n";
            userDisplay += "3. View Reservation\n";
            userDisplay += "4. Cancel Reservation\n";
            userDisplay += "5. Exit\n";
            userDisplay += "--------------------------------------";
            log.info(userDisplay);
            try {
                int choice = Integer.parseInt(scanner.next());
                switch(choice){
                    case 1: bookSeats(scanner);
                    case 2: showAvailableSeats(scanner);
                    case 3: viewReservation(scanner);
                    case 4: cancelReservation(scanner);
                    case 5: systemExit();
                    default:
                        log.error("Invalid Choice");
                        break;
                }
            } catch (Exception e) {
                log.error("Invalid choice. Please enter the correct Integer");
                userChoice(scanner);
            }
        }

    /**
     * Book Seats with emaild-ID as key
     * @param scanner
     */
    private static void bookSeats(Scanner scanner) {
            if (reservation.getTotalOpenSeats() == 0) {
                log.info("Sorry, All tickets Sold! Please try again later!");
                return;
            }
            log.info("Enter your email id for Ticket Booking:\n ");
            String emailId = scanner.next();
            log.info("Enter the number of seats you want to book \n");
            int numberOfSeats = scanner.nextInt();

            if (numberOfSeats > reservation.getTotalOpenSeats()) {
                log.info("Total Seats available are :" + reservation.getTotalOpenSeats()+ "\n");
                log.info("Cannot book Total Seats requested by you");
                return;
            }
            log.info(String.format("%s, your total seats are %d", emailId, numberOfSeats));
            SeatHold seatHold = null;
            if (numberOfSeats <= reservation.getTotalOpenSeats()) {
                 seatHold = ticketService.findAndHoldSeats(numberOfSeats, emailId);
            }
            log.info("Your have temporary hold on below seats" + seatHold);
            log.info("Temporary hold will expire soon in 20 seconds \n");
            startOnHoldSession(seatHold);
            log.info("Confirm 'Y' or 'N' to continue");
            String bookingConfirmation = scanner.next();
            if ("Y".equalsIgnoreCase(bookingConfirmation)) {
             timer.cancel();
             String confimationCode = ticketService.reserveSeats(seatHold, emailId);
             log.info("Cheers !!!, you tickets are booked with confirmationCode ===>" + confimationCode);
             updateUserInfo(emailId, seatHold);
            } else if ("N".equalsIgnoreCase(bookingConfirmation)) {
                timer.cancel();
                ticketService.resetHeldSeats(seatHold);
                log.info("Sorry !!!, your tickets are not booked");
            } else {
                log.info("No Valid input received");
            }
            userChoice(scanner);
        }

    /**
     * View the reservation done by the user, enter email id to view the reservation
     * User can view the reservation for multiple bookings
     * @param scanner
     */
    private static void viewReservation(Scanner scanner) {
        log.info("Do you want to view your reservation? if so please enter the email id \n");
        String emailId = scanner.next();
        Map<String, SeatHold> seatHoldMap = getReservationDetails(emailId);
        if(seatHoldMap != null && !seatHoldMap.isEmpty()) {
            for(Map.Entry<String, SeatHold> entry : seatHoldMap.entrySet()) {
                log.info("Confirmation Code: " + entry.getKey() + ", Ticket Booking Details: " + entry.getValue());
            }
        }else{
            log.info("Your Don't have any Reservation Details");
        }
        userChoice(scanner);

    }

    /**
     * Show the available seats to the user
     * @param scanner
     */
    private static void showAvailableSeats(Scanner scanner) {
        log.info("Total Available Open Seats to Book are ===> " + reservation.getTotalOpenSeats());
        userChoice(scanner);
    }

    /**
     * User can view cancel the reservation with help on email id
     * @param scanner
     */
   private static void cancelReservation(Scanner scanner) {
        log.info("Do you want to cancel your Reservation");
        log.info("Enter your email id for Ticket Booking: ");
            String emailId = scanner.next();
            Map<String, SeatHold> seatHoldMap = getReservationDetails(emailId);
            if(seatHoldMap == null || seatHoldMap.size() == 0){
                log.info("No Reservation Available to Cancel");
            }else {
                for (Map.Entry<String, SeatHold> entry : seatHoldMap.entrySet()) {
                    cancelReservation(emailId, entry.getValue());
                }
                log.info("Your Booking is Cancelled");
            }
       userChoice(scanner);
    }

    /**
     * Exit the Console
     */
    private static void systemExit(){
        System.exit(0);
    }

    /**
     * Update all bookings done by the user in table used as storage
     * @param emailId
     * @param seatHold
     */
    private static void updateUserInfo(String emailId, SeatHold seatHold) {
        seatHoldTable.put(emailId, seatHold.getConfirmationCode(), seatHold);
    }

    private static Map<String, SeatHold> getReservationDetails(String emailId) {
        return seatHoldTable.row(emailId);
    }

    private static void cancelReservation(String emailId, SeatHold seatHold) {
        seatHoldTable.remove(emailId, seatHold.getConfirmationCode());
        ticketService.resetHeldSeats(seatHold);
        }

    /**
     * Holds the seats for a specified timeout
     * @param seatHold seathold object
     */
    private static void startOnHoldSession(SeatHold seatHold) {
        timer = new Timer();

        timer.schedule( new TimerTask(){
            public void run() {
                // reset the held seats to available and remove the seats held
                log.info("Releasing hold on seats...");
                ticketService.resetHeldSeats(seatHold);
                log.info("Session Expired!");
                log.info("total available:" + ticketService.numSeatsAvailable());
            }

        }, 1000 * 20); //set to 20 seconds for Demo
    }
}
