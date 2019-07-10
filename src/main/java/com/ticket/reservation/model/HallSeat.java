package com.ticket.reservation.model;

/**
 * Created by Stan Gracious on 7/6/2019.
 * This class holds all Seats in the Hall with event
 */
public class HallSeat{

    private int id;
    private BookingStatus status;
    public HallSeat(int id, BookingStatus status) {
        this.id = id;
        this.status = status;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HallSeat{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }

}
