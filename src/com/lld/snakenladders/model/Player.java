package com.lld.snakenladders.model;

public class Player {
    private int id;
    private String name;
    private int position;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps) {
        this.position += steps;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}