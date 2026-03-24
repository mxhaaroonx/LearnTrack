package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, String email, String batch){
        int newId= IdGenerator.getNextStudentId();
        Student student = new Student(newId, firstName, lastName, email, batch, true);
        students.add(student);
    }

    public ArrayList<Student> getAllStudents(){
        return students;
    }

    public Student findById(int id){
        for(Student s: students){
            if(s.getId() == id)
                return s;
        }
        throw new EntityNotFoundException("Student with ID "+id+"not found");
    }

    public void deactivateStudent(int id){
        for(Student s: students){
            if(s.getId() == id) {
                s.setActive(false);
                return;
            }
        }
        throw new EntityNotFoundException("Student with ID "+id+"not found");
    }

    public void updateStudent(int id, String firstName, String lastName, String email){
        for(Student s: students) {
            if (s.getId() == id) {
                s.setFirstName(firstName);
                s.setLastName(lastName);
                s.setEmail(email);
                return;
            }
        }
        throw new EntityNotFoundException("Student with ID "+id+"not found");
    }



}
