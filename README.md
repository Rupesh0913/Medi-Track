# 🏥 MediTrack — Clinic & Appointment Management System

MediTrack is a modular, object-oriented clinic management system built in Core Java.  
It models doctors, patients, appointments, and billing while demonstrating strong OOP principles, design patterns, generics, and rule-based AI features.

---

## 🚀 Learning Objectives Covered

This project demonstrates:

- Java setup & JVM understanding
- Core OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Advanced OOP (Cloneable, Immutability, Enums, Static Initialization)
- Collections & Generics
- Exception handling with custom exceptions
- Design Patterns (Singleton, Factory, Observer)
- Rule-based AI feature
- Menu-driven console UI
- Clean layered architecture

---

## 📂 Project Structure

```

src/main/java/com/airtribe/meditrack/
├── Main.java
├── constants/
│ └── Constants.java
├── entity/
│ ├── MedicalEntity.java
│ ├── Person.java
│ ├── Doctor.java
│ ├── Patient.java
│ ├── Appointment.java
│ ├── Bill.java
│ └── BillSummary.java
├── service/
│ ├── DoctorService.java
│ ├── PatientService.java
│ └── AppointmentService.java
├── util/
│ ├── DataStore.java
│ ├── IdGenerator.java
│ └── AIHelper.java
├── exception/
│ ├── InvalidDataException.java
│ └── AppointmentNotFoundException.java
├── interface/
│ ├── Payable.java
│ └── Searchable.java
└── test/
└── TestRunner.java

docs/
├── Setup_Instructions.md
├── JVM_Report.md
└── Design_Decisions.md

```
---

## 🧠 Core Features

### 👨‍⚕️ Doctor Management
- Add Doctor
- View All Doctors
- Update Consultation Fee
- Update Specialization
- Delete Doctor

### 🧑‍⚕️ Patient Management
- Add Patient
- View All Patients
- Update Disease
- Delete Patient
- Search by ID / Name / Age / Keyword

### 📅 Appointment Management
- Create Appointment
- Confirm Appointment
- View All Appointments
- Generate Bill

### 💳 Billing
- Tax calculation via `Constants`
- `BillSummary` immutable snapshot
- Factory-based bill creation

### 🤖 AI Recommendation
- Rule-based specialization recommendation based on symptoms
- Auto-suggest appointment slot

---

## 🧩 Design Patterns Used

### 1️⃣ Singleton
`IdGenerator` ensures unique IDs across the application.

### 2️⃣ Factory
`BillFactory` centralizes bill creation logic.

### 3️⃣ Observer
Appointments notify observers on status changes.

---

## 🏗️ Architecture Overview

- **Entity Layer** → Domain models
- **Service Layer** → Business logic
- **Util Layer** → Reusable helpers (AI, ID generation, storage)
- **Exception Layer** → Custom error handling
- **Interface Layer** → Capability contracts

The system follows clean separation of concerns.

---

## 🔐 OOP Concepts Demonstrated

| Concept | Implementation |
|----------|----------------|
| Encapsulation | Private fields + controlled updates |
| Inheritance | MedicalEntity → Person → Doctor/Patient |
| Polymorphism | Method overloading & overriding |
| Abstraction | Abstract base classes & interfaces |
| Immutability | BillSummary class |
| Deep Copy | Cloneable for Patient & Appointment |
| Enums | Specialization, AppointmentStatus |
| Static Block | IdGenerator initialization |

---

## ▶️ How to Run

### 1️⃣ Compile

```bash
javac -d out src/main/java/com/airtribe/meditrack/**/*.java
```
### 2️⃣ Run

```bash
java -cp out com.airtribe.meditrack.Main
```
