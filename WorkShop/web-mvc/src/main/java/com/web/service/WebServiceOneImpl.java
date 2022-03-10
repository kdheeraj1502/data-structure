package com.web.service;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.model.Student;


@Service
//@Qualifier("one")
public class WebServiceOneImpl {//implements WebService {
	
	private Student student;

	public WebServiceOneImpl(Student student) {
		this.student = student;
	}

	public Optional<Object> getData(){
		student.setFirstName("Dheeraj");
		student.setLastName("Kumar");
		student.setAge(32);
		List<String> list = new ArrayList<>();
		list.add("One Subject");
		student.setSubjects(list);
		return Optional.of(student);
	}
}
