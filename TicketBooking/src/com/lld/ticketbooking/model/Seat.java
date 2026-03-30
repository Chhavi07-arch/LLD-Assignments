package com.lld.ticketbooking.model;

public class Seat {

    private String seatId;
    private String row;

    public Seat(String seatId, String row) {
        this.seatId = seatId;
        this.row = row;
    }

    public String getSeatId() {
        return seatId;
    }

    public String getRow() {
        return row;
    }
}