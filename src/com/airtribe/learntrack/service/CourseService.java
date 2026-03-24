package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(String courseName, String description, int durationInWeeks){
        int newId= IdGenerator.getNextCourseId();
        Course course = new Course(newId, courseName, description, durationInWeeks, true);
        courses.add(course);
    }

    public ArrayList<Course> getAllCourses(){
        return courses;
    }

    public Course findById(int id){
        for(Course c: courses){
            if(c.getId() == id)
                return c;
        }
        throw new EntityNotFoundException("Course with ID "+id+"not found");
    }

    public void deactivateCourse(int id){
        for(Course c: courses){
            if(c.getId() == id) {
                c.setActive(false);
                return;
            }
        }
        throw new EntityNotFoundException("Course with ID "+id+"not found");
    }

    public void activateCourse(int id){
        for(Course c: courses){
            if(c.getId() == id) {
                c.setActive(true);
                return;
            }
        }
        throw new EntityNotFoundException("Course with ID "+id+"not found");
    }

}


