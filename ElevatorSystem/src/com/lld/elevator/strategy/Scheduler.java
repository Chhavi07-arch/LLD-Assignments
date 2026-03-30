package com.lld.elevator.strategy;

import com.lld.elevator.model.*;

import java.util.List;

public interface Scheduler {

    Elevator assignElevator(Request request, List<Elevator> elevators);
}