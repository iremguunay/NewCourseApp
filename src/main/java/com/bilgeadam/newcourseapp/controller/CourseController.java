package com.bilgeadam.newcourseapp.controller;

import com.bilgeadam.newcourseapp.entity.Course;
import com.bilgeadam.newcourseapp.exception.CourseNotFound;
import com.bilgeadam.newcourseapp.repository.CourseRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable("courseId") long id) {

        Course course = null;

        Optional<Course> courseDB = courseRepository.findById(id);

        if (courseDB.isPresent()) {
            course = courseDB.get();
            return course;
        } else {
            throw new CourseNotFound("Course not found with id: "+id);
        }

    }

    @GetMapping("/course")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
