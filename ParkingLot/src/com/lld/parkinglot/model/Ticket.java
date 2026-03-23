package com.lld.parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {

    private int ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private EntryGate entryGate;
    private ParkingSlot slot;

    public Ticket(int ticketId, Vehicle vehicle, LocalDateTime entryTime,
                  EntryGate entryGate, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.entryGate = entryGate;
        this.slot = slot;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public ParkingSlot getSlot() {
        return slot;
    }
}