package com.security;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.security.service.Ratings;

public class RatingRetrieverUnitTest {
	@Autowired
	private List<Ratings> ratings;

	@Test
	public void givenOrder_whenInjected_thenByOrderValue() {
		assertEquals(ratings.get(0).getRating(), is(equalTo(1)));
		assertEquals(ratings.get(1).getRating(), is(equalTo(2)));
		assertEquals(ratings.get(2).getRating(), is(equalTo(3)));
	}
}
