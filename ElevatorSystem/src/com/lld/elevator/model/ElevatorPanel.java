package com.lld.elevator.model;

public class ElevatorPanel {

    private Elevator elevator;

    public ElevatorPanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void pressFloorButton(int floor) {
        Request request = new Request(floor, null, RequestType.INTERNAL);
        elevator.addRequest(request);
    }

    public void pressOpenDoor() {
        elevator.openDoor();
    }

    public void pressCloseDoor() {
        elevator.closeDoor();
    }

    public void pressAlarm() {
        elevator.triggerAlarm();
    }
}