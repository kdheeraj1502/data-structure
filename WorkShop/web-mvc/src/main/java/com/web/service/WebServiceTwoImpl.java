package com.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repository.WebRepository;

@Service
//@Qualifier("two")
public class WebServiceTwoImpl implements WebService {

	private Student student;
	static private List<String> list;

	public WebServiceTwoImpl(Student student) {
		this.student = student;
		this.list = new ArrayList<>();
	}

	public Optional<Object> getStudent() {
		Student stus = null;
		for(Map.Entry<Integer, Student> entry : WebRepository.students.entrySet()) {
			stus = entry.getValue();
		}
		return Optional.of(stus);
	}

	@Override
	public Object createStudent(Student student) {
		WebRepository.createStudent(student);
		return student;
	}

	@Override
	public Object updateStudent(String subject) {
		Student stud = null;
		for(Map.Entry<Integer, Student> entry : WebRepository.students.entrySet()) {
			entry.getValue().getSubjects().add(subject);
			stud = entry.getValue();
		}
		return stud;
	}

	@Override
	public Object deleteStudent() {
		WebRepository.students.remove(WebRepository.students.size() - 1);
		return "success";
	}

	@Override
	public Object partialUpdateStudent(String subject) {
		Student stud = null;
		for(Map.Entry<Integer, Student> entry : WebRepository.students.entrySet()) {
			entry.getValue().getSubjects().add(subject);
			stud = entry.getValue();
		}
		return stud;
	}
}
