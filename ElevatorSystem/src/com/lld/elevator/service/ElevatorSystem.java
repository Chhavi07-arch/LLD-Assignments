package com.lld.elevator.service;

import com.lld.elevator.model.*;
import com.lld.elevator.strategy.Scheduler;

import java.util.List;

public class ElevatorSystem {

    private List<Elevator> elevators;
    private Scheduler scheduler;

    public ElevatorSystem(List<Elevator> elevators, Scheduler scheduler) {
        this.elevators = elevators;
        this.scheduler = scheduler;
    }

    public void requestElevator(Request request) {

        Elevator elevator = scheduler.assignElevator(request, elevators);

        if (elevator == null) {
            System.out.println("No elevator available");
            return;
        }

        System.out.println("Elevator " + elevator.getId() + " assigned");

        elevator.addRequest(request);
        elevator.move();
    }
}