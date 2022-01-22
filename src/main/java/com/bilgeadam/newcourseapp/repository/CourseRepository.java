package com.bilgeadam.newcourseapp.repository;

import com.bilgeadam.newcourseapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
