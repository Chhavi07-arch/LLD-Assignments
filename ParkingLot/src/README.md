# Parking Lot LLD

## Features
- Multi-level parking
- Slot types: Small, Medium, Large
- Nearest slot allocation
- Ticket generation
- Billing system
- Status display

## Design Principles
- SOLID principles
- Strategy Pattern for pricing
- Clean separation of concerns


## Class Diagram

```text
+----------------------+
|     ParkingLotService|
+----------------------+
| floors               |
| gates                |
| distanceMap          |
| pricingStrategy      |
+----------------------+
| generateTicket()     |
| generateBill()       |
| showStatus()         |
| findNearestSlot()    |
+----------------------+

        | composition
        v

+----------------------+
|       Floor          |
+----------------------+
| floorNumber          |
| slots                |
+----------------------+

        | composition
        v

+----------------------+
|    ParkingSlot       |
+----------------------+
| slotId               |
| slotType             |
| isOccupied           |
+----------------------+
| occupy()             |
| free()               |
+----------------------+

+----------------------+
|      Vehicle         |
+----------------------+
| number               |
| color                |
| model                |
+----------------------+

+----------------------+
|     EntryGate        |
+----------------------+
| gateId               |
| floorNumber          |
+----------------------+

+----------------------+
|      Ticket          |
+----------------------+
| ticketId             |
| vehicle              |
| entryTime            |
| entryGate            |
| slot                 |
+----------------------+

+----------------------+
|       Bill           |
+----------------------+
| ticket               |
| exitTime             |
| amount               |
+----------------------+

+--------------------------+
|   PricingStrategy        |
+--------------------------+
| calculatePrice()         |
+--------------------------+

        ^
        | implements
+------------------------------+
|  SimplePricingStrategy       |
+------------------------------+

+----------------------+
|   SlotDistance       |
+----------------------+
| slot                 |
| distance             |
+----------------------+
```


Design follows:
- SRP (separate model, service, strategy)
- Open/Closed (pricing strategy)
- Encapsulation (slot state management)