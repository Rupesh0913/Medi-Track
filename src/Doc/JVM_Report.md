
---
# JVM Architecture & Understanding Report

## 1. Introduction
The Java Virtual Machine (JVM) is an abstract machine that enables Java programs
to run on any platform without modification. It is responsible for loading,
verifying, and executing Java bytecode.

---

## 2. Class Loader Subsystem
The Class Loader loads `.class` files into memory at runtime.

### Types of Class Loaders:
- Bootstrap Class Loader – loads core Java classes
- Extension Class Loader – loads extension libraries
- Application Class Loader – loads application classes

**Responsibilities:**
- Loading
- Linking
- Initialization

---

## 3. Runtime Data Areas

### 3.1 Heap
- Stores objects and class instances
- Shared across threads
- Garbage-collected memory

### 3.2 Stack
- Each thread has its own stack
- Stores method frames, local variables, and references

### 3.3 Method Area
- Stores class-level data
- Includes static variables and method bytecode

### 3.4 Program Counter (PC) Register
- Holds the address of the current instruction being executed
- One PC register per thread

---

## 4. Execution Engine
The Execution Engine executes bytecode instructions.

### Components:
- Interpreter
- Just-In-Time (JIT) Compiler
- Garbage Collector

---

## 5. JIT Compiler vs Interpreter

### Interpreter
- Executes bytecode line by line
- Slower execution
- Faster startup

### JIT Compiler
- Converts bytecode into native machine code
- Faster execution after compilation
- Improves performance for frequently used code

---

## 6. Write Once, Run Anywhere (WORA)
"Write once, run anywhere" (WORA) is a key principle of Java programming that emphasizes the platform independence of Java applications. It means that a Java program can be written and compiled on one platform (e.g., Windows, macOS, Linux) and then run on any other platform that has a compatible Java Virtual Machine (JVM) without requiring any modifications to the code.

This allows the same Java program to run on:
- Windows
- Linux
- macOS

Without any code changes.

---

## 7. Conclusion
The JVM provides platform independence, memory management,
security, and performance optimizations. Understanding JVM internals
helps developers write efficient and reliable Java applications.
