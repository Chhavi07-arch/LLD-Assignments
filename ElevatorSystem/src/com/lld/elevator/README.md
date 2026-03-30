# 🛗 Elevator System Design (LLD)

---

## 🚀 Features

* Multiple elevators managed by a central system
* External requests (Up/Down buttons on floors)
* Internal requests (floor selection inside elevator)
* Efficient request handling using scheduling strategies
* Supports multiple elevators moving simultaneously
* Weight limit handling with alarm system
* Door operations (open/close)
* Elevator states: IDLE, MOVING_UP, MOVING_DOWN, MAINTENANCE
* Extensible design to plug in new scheduling algorithms

---

## 🧠 Design Principles

* **Separation of Concerns** → model, service, strategy layers
* **Strategy Pattern** → pluggable elevator assignment algorithms
* **Encapsulation** → elevator manages its own state, movement, and requests
* **Scalability** → easy to add more elevators or strategies

---

## 📊 Class Diagram

```id="f0c5w9"
+--------------------------+
|     ElevatorSystem       |
+--------------------------+
| elevators               |
| scheduler               |
+--------------------------+
| requestElevator()       |
| assignElevator()        |
+--------------------------+

        | aggregation
        v

+--------------------------+
|        Elevator          |
+--------------------------+
| id                      |
| currentFloor            |
| direction               |
| state                   |
| currentWeight           |
| maxWeight               |
| upRequests              |
| downRequests            |
| door                    |
| alarm                   |
| panel                   |
+--------------------------+
| addRequest()            |
| move()                  |
| stopAtFloor()           |
| openDoor()              |
| closeDoor()             |
| isAvailable()           |
| isOverloaded()          |
+--------------------------+

        | composition
        v

+--------------------------+
|          Door            |
+--------------------------+
| state                   |
+--------------------------+
| open()                  |
| close()                 |
+--------------------------+

        | composition
        v

+--------------------------+
|          Alarm           |
+--------------------------+
| isOn                    |
+--------------------------+
| start()                 |
| stop()                  |
+--------------------------+

        | composition
        v

+--------------------------+
|     ElevatorPanel        |
+--------------------------+
| elevator                |
+--------------------------+
| pressFloorButton()      |
| pressOpenDoor()         |
| pressCloseDoor()        |
| pressAlarm()            |
+--------------------------+

--------------------------------------------------

+--------------------------+
|         Request          |
+--------------------------+
| floor                   |
| direction               |
| type                    |
+--------------------------+

+--------------------------+
|          Floor           |
+--------------------------+
| floorNumber             |
+--------------------------+
| pressUp()               |
| pressDown()             |
+--------------------------+

Floor ---> ElevatorSystem

--------------------------------------------------

+--------------------------+
|       Scheduler          | <<interface>>
+--------------------------+
| assignElevator()        |
+--------------------------+

        ^
        | implements

+------------------------------+
|      FCFSScheduler           |
+------------------------------+
```

---


## 🔥 Key Design Decisions

### ⭐ 1. Request Abstraction

* Unified handling of both internal and external requests
* Simplifies system design and extensibility

---

### ⭐ 2. Separate Up & Down Requests

* Each elevator maintains:

  * `upRequests (TreeSet)`
  * `downRequests (TreeSet)`

👉 Benefits:

* Efficient traversal
* Reduced direction switching
* Optimized movement

---

### ⭐ 3. Strategy Pattern (Scheduler)

* Elevator selection logic is decoupled
* Allows plugging in:

  * FCFS (First Come First Serve)
  * SCAN (Elevator algorithm)
  * Custom strategies

---

### ⭐ 4. Weight Handling

* Elevator checks overload before closing doors
* Triggers alarm if weight exceeds limit

---

### ⭐ 5. Modular Components

* Door, Alarm, Panel are separate classes
* Improves maintainability and extensibility

---

## ⚙️ System Flow

1. User presses button (Floor or Panel)
2. A `Request` is created
3. ElevatorSystem receives request
4. Scheduler selects best elevator
5. Elevator processes request:

   * Adds request to queue
   * Moves accordingly
   * Stops at required floors
6. Door operations are performed
7. Weight is checked before closing


---
