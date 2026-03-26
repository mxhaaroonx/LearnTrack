package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();
        CourseService courseService = new CourseService();

        while (true) {
            System.out.println("\n===== LearnTrack =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice= sc.nextInt();

            switch(choice){
                case 1: studentMenu(sc, studentService); break;
                case 2: courseMenu(sc, courseService); break;
                case 3: enrollmentMenu(sc, enrollmentService); break;
                case 0: System.out.println("See you later ! "); return;
                default: System.out.println("Invalid input");
            }

        }
    }

    public static void studentMenu(Scanner sc, StudentService studentService){
        while (true) {
            System.out.println("\n===== StudentManagement =====");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. search student by id");
            System.out.println("4. Deactivate student");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice= sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("First name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Batch: ");
                    String batch = sc.nextLine();
                    studentService.addStudent(firstName, lastName, email, batch);
                    System.out.println("Student added successfully!");
                    break;
                case 2:for (Student s : studentService.getAllStudents()) {
                    System.out.println(s.getId() + " - " + s.getDisplayName());
                }
                    break;
                case 3: {
                    System.out.println("Enter student id");

                    int id = sc.nextInt();
                    Student found = studentService.findById(id);
                    System.out.println(found.getId() + " - " + found.getDisplayName());
                    break;
                }

                case 4: {
                    System.out.println("Enter student id");
                    int id = sc.nextInt();
                    studentService.deactivateStudent(id);
                    System.out.println("Student deactivated succesfully");
                    break;
                }
                case 0: return;
                default: System.out.println("Invalid input");
            }

        }

    }

    public static void courseMenu(Scanner sc, CourseService courseService){
        while (true) {
            System.out.println("\n===== Course Management =====");
            System.out.println("1. Add Course");
            System.out.println("2. View all courses");
            System.out.println("3. Activate course");
            System.out.println("4. Deactivate course");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Course name: ");
                    String courseName = sc.nextLine();
                    System.out.print("Description: ");
                    String description = sc.nextLine();
                    System.out.print("Duration in weeks: ");
                    int duration = sc.nextInt();

                    courseService.addCourse(courseName, description, duration);
                    System.out.println("Course added successfully!");
                    break;
                case 2:
                    for (Course c : courseService.getAllCourses()) {
                        System.out.println(c.getCourseName() + " - " + c.getId() + " - " + c.getDescription());
                    }
                    break;
                case 3: {
                    System.out.println("Enter Course id");
                    int id = sc.nextInt();
                    courseService.activateCourse(id);
                    System.out.println("Course Activated");
                    break;
                }

                case 4: {
                    System.out.println("Enter Course id");
                    int id = sc.nextInt();
                    courseService.deactivateCourse(id);
                    System.out.println("Course deactivated succesfully");
                    break;
                }
                case 0:
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
        }

    public static void enrollmentMenu(Scanner sc, EnrollmentService enrollmentService) {
        while (true) {
            System.out.println("\n===== Enrollment Management =====");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments by Student");
            System.out.println("3. Update Enrollment Status");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();
                    System.out.print("Course ID: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enrollment Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    enrollmentService.enroll(studentId, courseId, date);
                    System.out.println("Student enrolled successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();
                    for (Enrollment e : enrollmentService.getEnrollmentsByStudentId(studentId)) {
                        System.out.println("Enrollment ID: " + e.getId() + " - Course ID: " + e.getCourseId() + " - Status: " + e.getStatus());
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enrollment ID: ");
                    int enrollmentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Status (ACTIVE/COMPLETED/CANCELLED): ");
                    String status = sc.nextLine();
                    enrollmentService.updateStatus(enrollmentId, status);
                    System.out.println("Status updated successfully!");
                    break;
                }
                case 0: return;
                default: System.out.println("Invalid input!");
            }
        }
    }

}
