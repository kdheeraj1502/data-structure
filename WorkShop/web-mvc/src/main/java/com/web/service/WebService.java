package com.web.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.model.Student;

public interface WebService {

	Optional<Object> getStudent();

	Object createStudent(Student student);

	Object updateStudent(String subject);

	Object deleteStudent();

	Object partialUpdateStudent(String subject);
}
