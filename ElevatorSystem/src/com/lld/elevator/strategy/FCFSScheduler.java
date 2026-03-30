package com.lld.elevator.strategy;

import com.lld.elevator.model.*;

import java.util.List;

public class FCFSScheduler implements Scheduler {

    @Override
    public Elevator assignElevator(Request request, List<Elevator> elevators) {

        for (int i = 0; i < elevators.size(); i++) {
            Elevator elevator = elevators.get(i);

            if (elevator.isAvailable()) {
                return elevator;
            }
        }

        return null;
    }
}