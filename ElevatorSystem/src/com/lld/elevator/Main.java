package com.lld.elevator;

import com.lld.elevator.model.*;
import com.lld.elevator.service.ElevatorSystem;
import com.lld.elevator.strategy.FCFSScheduler;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Elevator e1 = new Elevator(1, 750);
        Elevator e2 = new Elevator(2, 750);

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(e1);
        elevators.add(e2);

        ElevatorSystem system = new ElevatorSystem(elevators, new FCFSScheduler());

        // simulate request
        Request request = new Request(5, Direction.UP, RequestType.EXTERNAL);

        system.requestElevator(request);
    }
}