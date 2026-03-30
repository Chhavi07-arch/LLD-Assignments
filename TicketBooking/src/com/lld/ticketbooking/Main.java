package com.lld.ticketbooking;

import com.lld.ticketbooking.model.*;
import com.lld.ticketbooking.service.BookingService;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // create user
        User user = new User("1", "Chhavi");

        // create movie
        Movie movie = new Movie("m1", "Inception", 120, "English");

        // create screen & seats
        Screen screen = new Screen("screen1");
        Seat seat1 = new Seat("A1", "A");
        Seat seat2 = new Seat("A2", "A");

        screen.addSeat(seat1);
        screen.addSeat(seat2);

        // create show
        Show show = new Show("s1", movie, screen, "10AM");

        ShowSeat ss1 = new ShowSeat(seat1, SeatType.PREMIUM, 200);
        ShowSeat ss2 = new ShowSeat(seat2, SeatType.PREMIUM, 200);

        show.addShowSeat(ss1);
        show.addShowSeat(ss2);

        // booking service
        BookingService service = new BookingService();

        List<ShowSeat> seatsToBook = new ArrayList<>();
        seatsToBook.add(ss1);

        Booking booking = service.bookSeats(user, show, seatsToBook);

        if (booking != null) {
            System.out.println("Booking successful: " + booking.getBookingId());
        } else {
            System.out.println("Booking failed");
        }
    }
}