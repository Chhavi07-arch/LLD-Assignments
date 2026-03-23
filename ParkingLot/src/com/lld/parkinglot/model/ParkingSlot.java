package com.lld.parkinglot.model;

public class ParkingSlot {

    private int slotId;
    private SlotType slotType;
    private boolean isOccupied;

    public ParkingSlot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void free() {
        this.isOccupied = false;
    }
}