package com.web.repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.web.model.Student;

@Repository
public interface WebRepository {
	
	static AtomicInteger id = new AtomicInteger(2);
	static Map<Integer, Student> students = new HashMap<>();

	public static Map<Integer, Student> createStudent(Student student){
		students.put(id.getAndIncrement(), student);
		return students;
	}
}
