package com.lld.ticketbooking.model;

public class ShowSeat {

    private Seat seat;
    private SeatType type;
    private double price;
    private SeatStatus status;

    public ShowSeat(Seat seat, SeatType type, double price) {
        this.seat = seat;
        this.type = type;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    public void bookSeat() {
        this.status = SeatStatus.BOOKED;
    }

    public void lockSeat() {
        this.status = SeatStatus.LOCKED;
    }

    public void releaseSeat() {
        this.status = SeatStatus.AVAILABLE;
    }

    public double getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

    public SeatStatus getStatus() {
        return status;
    }
}