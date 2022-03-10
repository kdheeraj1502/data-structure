package com.web.cotroller;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.service.WebService;

@RestController
@RequestMapping("/students")
public class WebController {

	private WebService webservice;

	public WebController(WebService webservice) {
		this.webservice = webservice;
	}

	@GetMapping(value = "/all")
	public Object getStudent() {
		return webservice.getStudent();
	}

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object createStudent(@RequestBody Student student) {

		return webservice.createStudent(student);
	}

	@PutMapping(value = "/add-subject/{subject}")
	public Object updateStudent(@PathVariable(value = "subject") String subject) {

		return webservice.updateStudent(subject);
	}

	@DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object deleteStudent() {

		return webservice.deleteStudent();
	}	

	@PatchMapping(value = "/add-subject/only/{subject}")
	public Object partialUpdateStudent(@PathVariable(value = "subject") String subject) {

		return webservice.partialUpdateStudent(subject);
	}
	
	 @RequestMapping(value="/", method = RequestMethod.OPTIONS)
     ResponseEntity<?> collectionOptions() 
     {
		 
          return ResponseEntity
                  .ok()
                  .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                  .build();
     }
}
