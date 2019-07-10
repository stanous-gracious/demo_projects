package com.ticket.reservation.model;


import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by Stan Gracious on 7/6/2019.
 * Model object for processing seat booking request
 */
public class SeatHold {

    private String confirmationCode;
    private int totalSeats;
    private String customerEmail;
    private HashMap<Integer, String> requestedSeats;
    private static final Logger logger = Logger.getLogger(SeatHold.class);

    public SeatHold(String emailId, int totalSeats) {
        this.confirmationCode = String.valueOf(new Random().nextInt(100));
        this.customerEmail = emailId;
        this.totalSeats = totalSeats;
        this.requestedSeats = new HashMap<>();
    }

    public int getTotalSeats() {
        return totalSeats;
    }
    public void print() {
        this.requestedSeats.forEach((key, value) -> {
            logger.info("Row number:" + key);
            logger.info(" Seat number(s): " + value);
        });
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public HashMap<Integer, String> getRequestedSeats() {
        return requestedSeats;
    }


    @Override
    public String toString() {
        return "SeatHold{" +
                "confirmationCode=" + confirmationCode +
                ", totalSeats=" + totalSeats +
                ", requestedSeats=" + requestedSeats +
                '}';
    }

}
