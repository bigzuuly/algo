package main.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class coinCounter {
	
	private int numCents;
	
	//quarters, dimes, nickels and pennies
	private static ArrayList<Integer> coins = new ArrayList<Integer>(Arrays.asList(25,10,5,1));
	private HashMap<Integer, Integer> changeMap;
	
	public coinCounter(int numCents) {
		this.numCents = numCents;
		changeMap = new HashMap<Integer, Integer>();
		
	}
	
	public int getNumCoins() {
				
		int currentTotal = numCents;
		
		for(Integer coin: coins){
			//find num coins
			if(currentTotal / coin > 0) {
				changeMap.put(coin, currentTotal / coin);
				currentTotal = currentTotal % coin;
			}
		}
		
		int numCoins = 0;
		Iterator<Integer> iter = changeMap.values().iterator();
		while(iter.hasNext()) {
			numCoins += iter.next();
		}
		
		return numCoins;
	}

	public static void main (String[] args) {
		
		coinCounter example = new coinCounter(8);
		
		//example.testSumOrdered(new int[] {1,2,3,7,9});
		//System.out.println("Invalid Input " + Arrays.toString(example.testSumUnordered(invalidInput)));
		System.out.println("Number of Coins " + example.getNumCoins());
	
	}
}
