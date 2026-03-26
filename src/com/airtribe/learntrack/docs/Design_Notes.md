# Design Notes

## Why ArrayList instead of Array?

ArrayList was used to store Students, Courses, and Enrollments because the
number of records is dynamic — we don't know how many will be added at
runtime. 

## Where Static Members Were Used

Static variables and methods were used in IdGenerator and InputValidator.
IdGenerator uses static counters (studentIdCounter, courseIdCounter,
enrollmentIdCounter) to generate unique IDs across the application. Since
these counters need to be shared across all instances, static made sense.

## Where Inheritance Was Used and What We Gained

A Person base class was created with common fields like id, firstName,
lastName, and email. Both Student and Trainer extend Person, inheriting
these fields without repeating them. This follows the DRY (Don't Repeat
Yourself) principle.