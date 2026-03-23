package com.lld.parkinglot.service;

import com.lld.parkinglot.model.*;
import com.lld.parkinglot.strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLotService {

    private List<Floor> floors;
    private List<EntryGate> gates;
    private Map<Integer, List<SlotDistance>> distanceMap;
    private PricingStrategy pricingStrategy;
    private int ticketCounter = 1;

    public ParkingLotService(List<Floor> floors,
                             List<EntryGate> gates,
                             Map<Integer, List<SlotDistance>> distanceMap,
                             PricingStrategy pricingStrategy) {

        this.floors = floors;
        this.gates = gates;
        this.distanceMap = distanceMap;
        this.pricingStrategy = pricingStrategy;
    }

    // 🔹 Generate Ticket
    public Ticket generateTicket(Vehicle vehicle, LocalDateTime entryTime,
                                 SlotType slotType, EntryGate gate) {

        ParkingSlot slot = findNearestSlot(slotType, gate.getGateId());

        if (slot == null) {
            System.out.println("No slot available");
            return null;
        }

        synchronized (slot) {
            if (slot.isOccupied()) {
                return null;
            }
            slot.occupy();
        }

        Ticket ticket = new Ticket(ticketCounter++, vehicle, entryTime, gate, slot);
        return ticket;
    }

    // 🔹 Find nearest slot
    private ParkingSlot findNearestSlot(SlotType type, int gateId) {

        List<SlotDistance> list = distanceMap.get(gateId);

        for (int i = 0; i < list.size(); i++) {
            ParkingSlot slot = list.get(i).getSlot();

            if (!slot.isOccupied() && slot.getSlotType() == type) {
                return slot;
            }
        }

        return null;
    }

    // 🔹 Generate Bill
    public Bill generateBill(Ticket ticket, LocalDateTime exitTime) {

        ParkingSlot slot = ticket.getSlot();

        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();
        if (hours == 0) hours = 1;

        double amount = pricingStrategy.calculatePrice(slot.getSlotType(), hours);

        slot.free();

        return new Bill(ticket, exitTime, amount);
    }

    // 🔹 Show Status
    public void showStatus() {

        int small = 0, medium = 0, large = 0;

        for (int i = 0; i < floors.size(); i++) {

            List<ParkingSlot> slots = floors.get(i).getSlots();

            for (int j = 0; j < slots.size(); j++) {

                ParkingSlot slot = slots.get(j);

                if (!slot.isOccupied()) {

                    if (slot.getSlotType() == SlotType.SMALL) small++;
                    else if (slot.getSlotType() == SlotType.MEDIUM) medium++;
                    else large++;
                }
            }
        }

        System.out.println("Available Slots:");
        System.out.println("Small: " + small);
        System.out.println("Medium: " + medium);
        System.out.println("Large: " + large);
    }
}