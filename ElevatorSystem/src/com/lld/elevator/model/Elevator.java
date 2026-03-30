package com.lld.elevator.model;

import java.util.TreeSet;

public class Elevator {

    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;

    private int currentWeight;
    private int maxWeight;

    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;

    private Door door;
    private Alarm alarm;
    private ElevatorPanel panel;

    public Elevator(int id, int maxWeight) {
        this.id = id;
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
        this.direction = Direction.UP;
        this.maxWeight = maxWeight;

        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>();

        this.door = new Door();
        this.alarm = new Alarm();
        this.panel = new ElevatorPanel(this);
    }

    // ---------------- REQUEST HANDLING ----------------

    public void addRequest(Request request) {
        int floor = request.getFloor();

        if (floor > currentFloor) {
            upRequests.add(floor);
        } else {
            downRequests.add(floor);
        }
    }

    // ---------------- MOVEMENT ----------------

    public void move() {

        if (!upRequests.isEmpty()) {
            state = ElevatorState.MOVING_UP;
            direction = Direction.UP;

            while (!upRequests.isEmpty()) {
                int nextFloor = upRequests.pollFirst();
                goToFloor(nextFloor);
            }
        }

        if (!downRequests.isEmpty()) {
            state = ElevatorState.MOVING_DOWN;
            direction = Direction.DOWN;

            while (!downRequests.isEmpty()) {
                int nextFloor = downRequests.pollLast();
                goToFloor(nextFloor);
            }
        }

        state = ElevatorState.IDLE;
    }

    private void goToFloor(int floor) {
        System.out.println("Elevator " + id + " moving to floor " + floor);
        currentFloor = floor;

        stopAtFloor();
    }

    public void stopAtFloor() {
        System.out.println("Elevator " + id + " stopped at floor " + currentFloor);
        openDoor();
        closeDoor();
    }

    // ---------------- DOOR ----------------

    public void openDoor() {
        door.open();
    }

    public void closeDoor() {
        if (isOverloaded()) {
            alarm.start();
            return;
        }
        door.close();
    }

    // ---------------- STATUS ----------------

    public boolean isAvailable() {
        return state != ElevatorState.MAINTENANCE;
    }

    public boolean isOverloaded() {
        return currentWeight > maxWeight;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }

    // ---------------- ALARM ----------------

    public void triggerAlarm() {
        alarm.start();
    }
}