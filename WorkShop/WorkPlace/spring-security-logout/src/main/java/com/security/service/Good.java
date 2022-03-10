package com.security.service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Good implements Ratings {

	@Override
	public int getRating() {
		return 2;
	}
}