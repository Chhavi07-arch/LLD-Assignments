package com.lld.parkinglot.service;

import com.lld.parkinglot.model.ParkingSlot;

public class SlotDistance {

    private ParkingSlot slot;
    private int distance;

    public SlotDistance(ParkingSlot slot, int distance) {
        this.slot = slot;
        this.distance = distance;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public int getDistance() {
        return distance;
    }
}