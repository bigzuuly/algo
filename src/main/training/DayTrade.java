package main.training;

import java.util.ArrayList;
import java.util.Arrays;

public class DayTrade {
	
	int maxProfit = 0;
	Integer min = Integer.MAX_VALUE;
	Integer max = 0;
	int minIndex = 0;
	int maxIndex = 0;
	/*
	public void getBestTrade(ArrayList<Integer> dayPrices) {
		
		//get minIndex and maxIndex where maxIndex > minIndex
		for(int i = 0; i<dayPrices.size(); i++ ) {
			for(int j = i; j<dayPrices.size(); j++) {
				int currentProfit = dayPrices.get(j) - dayPrices.get(i);
				if(currentProfit > maxProfit) {
					//set min max
					minIndex = i;
					maxIndex = j;
					
					//set max profit
					maxProfit = currentProfit;
				}
			}
		}
	}
	*/
	
	// Single Loop
	public void getBestTrade(ArrayList<Integer> dayPrices) {
		int currentMinIndex = 0;
		
		//get minIndex and maxIndex where maxIndex > minIndex
		for(int i = 0; i<dayPrices.size(); i++ ) {
			if(dayPrices.get(i) < min) {
				currentMinIndex = i;
				min = dayPrices.get(i);
			}
			
			int currentProfit = dayPrices.get(i) - dayPrices.get(currentMinIndex);
			if(currentProfit > maxProfit) {
				//set min max
				minIndex = currentMinIndex;
				maxIndex = i;
				
				//set max profit
				maxProfit = currentProfit; 
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		DayTrade dayTrade = new DayTrade();
		
		
		//dayTrade.getBestTrade(new ArrayList<Integer>(Arrays.asList(3, 6, 9, 1, 4, 2, 8)));
		dayTrade.getBestTrade(new ArrayList<Integer>(Arrays.asList(3, 8, 1, 2)));
		
		System.out.println("Best Trade yields a profit of: " + dayTrade.maxProfit);
		System.out.println("Buy at day: " + dayTrade.minIndex);
		System.out.println("Sell at day: " + dayTrade.maxIndex);
		
		
	}
}
