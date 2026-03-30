package com.lld.ticketbooking.service;

import com.lld.ticketbooking.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {

    public List<ShowSeat> getAvailableSeats(Show show) {
        return show.getAvailableSeats();
    }

    public Booking bookSeats(User user, Show show, List<ShowSeat> selectedSeats) {

        // check availability
        for (int i = 0; i < selectedSeats.size(); i++) {
            if (!selectedSeats.get(i).isAvailable()) {
                System.out.println("Seat not available");
                return null;
            }
        }

        // lock seats
        for (int i = 0; i < selectedSeats.size(); i++) {
            selectedSeats.get(i).lockSeat();
        }

        // create booking
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, user, show, selectedSeats);

        // payment
        Payment payment = new Payment("pay_" + bookingId, booking.calculateTotalAmount(), PaymentMethod.UPI);
        payment.processPayment();

        if (payment.getStatus() == PaymentStatus.SUCCESS) {

            for (int i = 0; i < selectedSeats.size(); i++) {
                selectedSeats.get(i).bookSeat();
            }

            booking.confirmBooking();
            return booking;
        } else {
            for (int i = 0; i < selectedSeats.size(); i++) {
                selectedSeats.get(i).releaseSeat();
            }
        }

        return null;
    }

    public void cancelBooking(Booking booking) {
        booking.cancelBooking();
    }
}