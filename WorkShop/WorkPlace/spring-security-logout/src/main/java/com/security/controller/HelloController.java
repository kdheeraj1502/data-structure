package com.security.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	public String sayHello(String name) {
		return "Hello " + name;
	}

	@GetMapping("/admin/hello")
	public String sayAdminHello(String name) {
	//	Map<K, V>
	//	HashMap<K, V>
	//	Collections.synchronizedMap(null)
		
		return "Hello Admin " + name;
	}
}
