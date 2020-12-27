package com.beginnerlevel.coding.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.beginnerlevel.coding.Stock;

public class StockTest {

	@Test
	public void testProfit_1() {
		Stock s = new Stock();
		int[] prices = new int[] {7,1,5,3,6,4};
		assertEquals(7, s.maxProfit(prices));
	}
	
	@Test
	public void testProfit_2() {
		Stock s = new Stock();
		int[] prices = new int[] {1,2,3,4,5};
		assertEquals(4, s.maxProfit(prices));
	}
	
	@Test
	public void testProfit_3() {
		Stock s = new Stock();
		int[] prices = new int[] {7,6,4,3,1};
		assertEquals(0, s.maxProfit(prices));
	}
	
	@Test
	public void testProfit_4() {
		Stock s = new Stock();
		int[] prices = new int[] {7,1,5,3,6,4};
		assertEquals(7, s.maxProfit_1(prices));
	}
	
	@Test
	public void testProfit_5() {
		Stock s = new Stock();
		int[] prices = new int[] {1,2,3,4,5};
		assertEquals(4, s.maxProfit_1(prices));
	}
	
	@Test
	public void testProfit_6() {
		Stock s = new Stock();
		int[] prices = new int[] {7,6,4,3,1};
		assertEquals(0, s.maxProfit_1(prices));
	}
}
