package com.pattern.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DateUtil_LazyInitializationTest {

	@Test
	public void testDateUtilInstance() {
		assertNotNull(DateUtil_LazyInitialization.getInstance());
	}

	@Test
	public void testDateUtilSingleton() {
		DateUtil_LazyInitialization d1 = DateUtil_LazyInitialization.getInstance();
		DateUtil_LazyInitialization d2 = DateUtil_LazyInitialization.getInstance();
		assertEquals(d1, d2);
		assertTrue(d1==d2);
	}

}
