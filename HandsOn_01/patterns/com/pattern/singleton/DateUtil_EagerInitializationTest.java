package com.pattern.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DateUtil_EagerInitializationTest {

	@Test
	public void testDateUtilInstance() {
		assertNotNull(DateUtil_EagerInitialization.getInstance());
	}

	@Test
	public void testDateUtilSingleton() {
		DateUtil_EagerInitialization d1 = DateUtil_EagerInitialization.getInstance();
		DateUtil_EagerInitialization d2 = DateUtil_EagerInitialization.getInstance();
		assertEquals(d1, d2);
		assertTrue(d1==d2);
	}

}
