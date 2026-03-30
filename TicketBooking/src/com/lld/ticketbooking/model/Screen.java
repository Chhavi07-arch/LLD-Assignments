package com.lld.ticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private String screenId;
    private List<Seat> seats;

    public Screen(String screenId) {
        this.screenId = screenId;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getScreenId() {
        return screenId;
    }
}