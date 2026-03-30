package com.lld.ticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Show {

    private String showId;
    private Movie movie;
    private Screen screen;
    private String startTime;
    private List<ShowSeat> showSeats;

    public Show(String showId, Movie movie, Screen screen, String startTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.showSeats = new ArrayList<>();
    }

    public void addShowSeat(ShowSeat showSeat) {
        this.showSeats.add(showSeat);
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public List<ShowSeat> getAvailableSeats() {
        List<ShowSeat> available = new ArrayList<>();

        for (int i = 0; i < showSeats.size(); i++) {
            ShowSeat seat = showSeats.get(i);
            if (seat.isAvailable()) {
                available.add(seat);
            }
        }

        return available;
    }

    public String getShowId() {
        return showId;
    }
}