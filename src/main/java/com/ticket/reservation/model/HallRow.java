package com.ticket.reservation.model;

/**
 * Created by Stan Gracious on 7/6/2019.
 * This class holds all rows in the Hall with event
 */
public class HallRow implements Comparable<HallRow>{

    private Integer rowId;
    private Integer availableSeatsInRow;
    public HallRow(Integer rowId) {
        this.rowId = rowId;
    }
    public HallRow(Integer rowId, Integer availableSeatsInRow) {
        this.rowId = rowId;
        this.availableSeatsInRow = availableSeatsInRow;
    }

    public Integer getAvailableSeatsInRow() {
        return availableSeatsInRow;
    }

    public void setAvailableSeatsInRow(Integer availableSeatsInRow) {
        this.availableSeatsInRow = availableSeatsInRow;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HallRow row = (HallRow) o;

        return rowId.equals(row.rowId);
    }

    @Override
    public int hashCode() {
        return rowId.hashCode();
    }

    public int compareTo(HallRow r) {
        if(this.availableSeatsInRow == r.availableSeatsInRow)
            return 0;
        else return this.availableSeatsInRow > r.availableSeatsInRow ? 1 : -1;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }


    public void releaseSeatsInRow(int numSeats) {
        this.setAvailableSeatsInRow(this.getAvailableSeatsInRow() + numSeats);
    }

    public void putOnHoldSeatsInRow(int numSeats) {
        this.setAvailableSeatsInRow(this.getAvailableSeatsInRow() - numSeats);
    }

    @Override
    public String toString() {
        return "HallRow{" +
                "rowId=" + rowId +
                ", availableSeatsInRow=" + availableSeatsInRow +
                '}';
    }


}
