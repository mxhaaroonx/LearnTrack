# LearnTrack - Student & Course Management System

A console-based Student and Course Management System built using Core Java.
Allows admins to manage Students, Courses, and Enrollments through a
menu-driven console interface.

## Features
- Add, view, search, and deactivate students
- Add, view, activate, and deactivate courses
- Enroll students in courses and track enrollment status
- Basic exception handling for invalid input and missing records

## How to Compile and Run

1. Clone the repository:
   git clone https://github.com/mxhaaroonx/LearnTrack.git

2. Open the project in IntelliJ IDEA

3. Make sure JDK 21 is configured:
   File → Project Structure → SDK → JDK 21

4. Navigate to:
   src/com/airtribe/learntrack/ui/Main.java

5. Click the green play button or right click → Run 'Main'

## Project Structure
```
src/
└── com/airtribe/learntrack/
    ├── entity/     → Person, Student, Trainer, Course, Enrollment
    ├── service/    → StudentService, CourseService, EnrollmentService
    ├── exception/  → EntityNotFoundException, InvalidInputException
    ├── util/       → IdGenerator, InputValidator
    └── ui/         → Main.java
docs/
    ├── Setup_Instructions.md
    ├── JVM_Basics.md
    ├── Design_Notes.md
    └── class_diagram.png
```

## Class Diagram
![Class Diagram](docs/class_diagram.png)

## Tech Stack
- Java 21
- IntelliJ IDEA