package com.lld.elevator.model;

public class Door {

    private DoorState state;

    public Door() {
        this.state = DoorState.CLOSED;
    }

    public void open() {
        state = DoorState.OPEN;
        System.out.println("Door opened");
    }

    public void close() {
        state = DoorState.CLOSED;
        System.out.println("Door closed");
    }

    public boolean isOpen() {
        return state == DoorState.OPEN;
    }
}