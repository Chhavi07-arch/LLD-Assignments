package com.lld.elevator.model;

public class Alarm {

    private boolean isOn;

    public void start() {
        isOn = true;
        System.out.println("Alarm ON 🚨");
    }

    public void stop() {
        isOn = false;
    }
}