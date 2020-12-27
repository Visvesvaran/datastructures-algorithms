package com.beginnerlevel.coding;

public class Stock {
	
	    public int maxProfit(int[] prices) {
	        int i = 0;
	        int profit = 0;
	        for(int j = 1; j < prices.length; j++) {
	            if(prices[i] < prices[j]){
                    profit = profit + prices[j] - prices[i];
                    i=j;
	            } else {
	            	i++;
	            }
	        }
	        return profit;
	    }
	    
	    public int maxProfit_1(int[] prices) {
	        int profit = 0;
	        for(int i = 1; i < prices.length; i++) {
	            if(prices[i] > prices[i-1]){
                    profit = profit + prices[i] - prices[i-1];
	            }
	        }
	        return profit;
	    }

}
