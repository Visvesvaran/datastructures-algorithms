package com.pattern.factory;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonWishTest {

	@Test
	public void getWishMale() {
		PersonWish p = new PersonWish();
		assertEquals(true, p.getWish("Male", "Wish by Male") instanceof Male);
	}
	
	@Test
	public void getWishFemale() {
		PersonWish p = new PersonWish();
		assertEquals(true, p.getWish("Female", "Wish by Female") instanceof Female);
	}
}
