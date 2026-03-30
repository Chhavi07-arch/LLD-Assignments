package com.lld.ticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private List<Theater> theaters;

    public City(String name) {
        this.name = name;
        this.theaters = new ArrayList<>();
    }

    public void addTheater(Theater theater) {
        this.theaters.add(theater);
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public String getName() {
        return name;
    }
}