package com.lld.parkinglot.model;

import java.util.List;

public class Floor {

    private int floorNumber;
    private List<ParkingSlot> slots;

    public Floor(int floorNumber, List<ParkingSlot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}