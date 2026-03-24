package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enroll(int studentId, int courseId, String enrollmentDate) {
        int newid = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(newid, studentId, courseId, enrollmentDate, "ACTIVE");
        enrollments.add(enrollment);
    }
    public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId){
        ArrayList<Enrollment> result= new ArrayList<>();
        for(Enrollment e: enrollments){
            if(e.getStudentId()==studentId){
                result.add(e);
            }
        }
        return result;
    }

    public void updateStatus(int enrollmentId, String status){
        for(Enrollment e: enrollments){
            if(e.getId()==enrollmentId){
                e.setStatus(status);
                return;
            }
        }
        throw new EntityNotFoundException("Enrollment ID "+enrollmentId+ " not found");

    }

}
