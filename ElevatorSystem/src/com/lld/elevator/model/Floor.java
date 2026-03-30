package com.lld.elevator.model;

import com.lld.elevator.service.ElevatorSystem;

public class Floor {

    private int floorNumber;
    private ElevatorSystem system;

    public Floor(int floorNumber, ElevatorSystem system) {
        this.floorNumber = floorNumber;
        this.system = system;
    }

    public void pressUp() {
        Request request = new Request(floorNumber, Direction.UP, RequestType.EXTERNAL);
        system.requestElevator(request);
    }

    public void pressDown() {
        Request request = new Request(floorNumber, Direction.DOWN, RequestType.EXTERNAL);
        system.requestElevator(request);
    }
}