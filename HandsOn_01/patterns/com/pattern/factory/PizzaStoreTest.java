package com.pattern.factory;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PizzaStoreTest {

	@Test
	public void orderPizzaVeg() {
		PizzaStore store = new PizzaStore();
		assertEquals(true, store.orderPizza("veg") instanceof VegPizza);
	}
	
	@Test
	public void orderPizzaCheese() {
		PizzaStore store = new PizzaStore();
		assertEquals(true, store.orderPizza("cheese") instanceof CheesePizza);
	}
}
