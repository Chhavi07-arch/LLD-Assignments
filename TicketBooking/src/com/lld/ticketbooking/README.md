# 🎬 Movie Ticket Booking System (LLD)

---

## 🚀 Features

* Multiple cities supported
* Multiple theaters and screens
* Shows for different movies at different timings
* Seat selection with real-time availability
* Different seat types (STANDARD, PREMIUM, VIP)
* Booking and cancellation functionality
* Payment handling (UPI, CARD)
* Prevents double booking using seat status (AVAILABLE, LOCKED, BOOKED)

---

## 🧠 Design Principles

* **Separation of Concerns** → model vs service
* **Encapsulation** → seat state handled inside ShowSeat
* **Single Responsibility Principle (SRP)** → each class has a clear role
* **Extensible Design** → pricing & concurrency can be added later

---

## 📊 Class Diagram

```
+----------------------+
|        City          |
+----------------------+
| name                 |
| theaters             |
+----------------------+
| addTheater()         |
| getTheaters()        |
+----------------------+

        | aggregation
        v

+----------------------+
|       Theater        |
+----------------------+
| name                 |
| location             |
| screens              |
+----------------------+
| addScreen()          |
| getScreens()         |
+----------------------+

        | composition
        v

+----------------------+
|        Screen        |
+----------------------+
| screenId             |
| seats                |
+----------------------+
| addSeat()            |
| getSeats()           |
+----------------------+

        | composition
        v

+----------------------+
|        Seat          |
+----------------------+
| seatId               |
| row                  |
+----------------------+

--------------------------------------------------

+----------------------+
|        Movie         |
+----------------------+
| movieId              |
| title                |
| duration             |
| language             |
+----------------------+

+----------------------+
|        Show          |
+----------------------+
| showId               |
| movie                |
| screen               |
| startTime            |
| showSeats            |
+----------------------+
| getAvailableSeats()  |
+----------------------+

        | composition
        v

+----------------------+
|      ShowSeat        |
+----------------------+
| seat                 |
| type                 |
| price                |
| status               |
+----------------------+
| isAvailable()        |
| bookSeat()           |
| lockSeat()           |
| releaseSeat()        |
+----------------------+

--------------------------------------------------

+----------------------+
|       Booking        |
+----------------------+
| bookingId            |
| user                 |
| show                 |
| seats                |
| totalAmount          |
| status               |
+----------------------+
| calculateTotal()     |
| confirmBooking()     |
| cancelBooking()      |
+----------------------+

        | association
        v

+----------------------+
|       Payment        |
+----------------------+
| paymentId            |
| amount               |
| status               |
| method               |
+----------------------+
| processPayment()     |
+----------------------+

+----------------------+
|        User          |
+----------------------+
| userId               |
| name                 |
+----------------------+

--------------------------------------------------

+----------------------+
|   BookingService     |
+----------------------+
|                      |
+----------------------+
| getAvailableSeats()  |
| bookSeats()          |
| cancelBooking()      |
+----------------------+
```

---

## 🔗 Relationships Explained

### 🔹 Aggregation

* **City → Theater**
* A city contains multiple theaters
* Theaters can exist independently

---

### 🔹 Composition

* **Theater → Screen**
* **Screen → Seat**
* **Show → ShowSeat**

👉 These are strong relationships:

* If parent is deleted → child is also gone

---

### 🔹 Association

* **Booking → Payment**
* **Booking → User**
* **Show → Movie**

👉 These are loose relationships

---

## 🔥 Key Design Decisions

### ⭐ 1. ShowSeat Abstraction

Instead of directly using Seat, we introduced ShowSeat.

Why?

* Seat type can change per show
* Price varies per show
* Seat availability is show-specific

---

### ⭐ 2. BookingService Layer

* Handles all business logic
* Keeps model classes clean
* Follows separation of concerns

---

### ⭐ 3. Seat Status Handling

Each ShowSeat maintains:

* AVAILABLE
* LOCKED
* BOOKED

This helps:

* Prevent double booking
* Handle concurrency

---

## ⚙️ Booking Flow

1. User selects a show
2. System fetches available seats
3. User selects seats
4. Seats are locked
5. Payment is processed
6. If successful → seats are booked
7. Else → seats are released

---



## ✅ Conclusion

This design provides:

* Clean structure
* Easy extensibility
* Strong separation of concerns
* Real-world modeling of ticket booking systems

---
