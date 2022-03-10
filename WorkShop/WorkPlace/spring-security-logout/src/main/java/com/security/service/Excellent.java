package com.security.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Excellent implements Ratings {

	@Override
	public int getRating() {
		return 1;
	}
}