package com.lld.parkinglot.main;

import com.lld.parkinglot.model.*;
import com.lld.parkinglot.service.*;
import com.lld.parkinglot.strategy.*;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 🔹 Create slots
        ParkingSlot s1 = new ParkingSlot(1, SlotType.SMALL);
        ParkingSlot s2 = new ParkingSlot(2, SlotType.MEDIUM);
        ParkingSlot s3 = new ParkingSlot(3, SlotType.LARGE);

        List<ParkingSlot> floor1Slots = new ArrayList<>();
        floor1Slots.add(s1);
        floor1Slots.add(s2);
        floor1Slots.add(s3);

        Floor floor1 = new Floor(1, floor1Slots);

        List<Floor> floors = new ArrayList<>();
        floors.add(floor1);

        // 🔹 Entry Gate
        EntryGate gate1 = new EntryGate(1, 1);

        List<EntryGate> gates = new ArrayList<>();
        gates.add(gate1);

        // 🔹 Distance Map
        Map<Integer, List<SlotDistance>> distanceMap = new HashMap<>();

        List<SlotDistance> gate1Distances = new ArrayList<>();
        gate1Distances.add(new SlotDistance(s1, 10));
        gate1Distances.add(new SlotDistance(s2, 20));
        gate1Distances.add(new SlotDistance(s3, 30));

        distanceMap.put(1, gate1Distances);

        // 🔹 Pricing Strategy
        PricingStrategy pricingStrategy = new SimplePricingStrategy();

        // 🔹 Parking Lot Service
        ParkingLotService service = new ParkingLotService(
                floors, gates, distanceMap, pricingStrategy
        );

        // 🔹 Vehicle
        Vehicle vehicle = new Vehicle("KA01AB1234", "Black", "Honda");

        // 🔹 Generate Ticket
        Ticket ticket = service.generateTicket(
                vehicle,
                LocalDateTime.now(),
                SlotType.MEDIUM,
                gate1
        );

        if (ticket != null) {
            System.out.println("Ticket Generated: " + ticket.getTicketId());
        }

        // 🔹 Show Status
        service.showStatus();

        // 🔹 Exit after some time
        LocalDateTime exitTime = LocalDateTime.now().plusHours(2);

        Bill bill = service.generateBill(ticket, exitTime);

        System.out.println("Amount to pay: " + bill.getAmount());

        // 🔹 Show Status again
        service.showStatus();
    }
}