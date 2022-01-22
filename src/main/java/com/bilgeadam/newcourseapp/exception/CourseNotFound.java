package com.bilgeadam.newcourseapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CourseNotFound extends RuntimeException {

    public CourseNotFound(String message) {
        super(message);
    }
}
