package com.lld.ticketbooking.model;

public class Movie {

    private String movieId;
    private String title;
    private int duration;
    private String language;

    public Movie(String movieId, String title, int duration, String language) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getMovieId() {
        return movieId;
    }
}