package com.lld.ticketbooking.model;

import java.util.List;

public class Booking {

    private String bookingId;
    private User user;
    private Show show;
    private List<ShowSeat> seats;
    private double totalAmount;
    private BookingStatus status;

    public Booking(String bookingId, User user, Show show, List<ShowSeat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
        this.totalAmount = calculateTotalAmount();
    }

    public double calculateTotalAmount() {
        double total = 0;

        for (int i = 0; i < seats.size(); i++) {
            total = total + seats.get(i).getPrice();
        }

        return total;
    }

    public void confirmBooking() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public BookingStatus getStatus() {
        return status;
    }
}