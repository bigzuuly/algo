package main.training;

import java.util.Arrays;
import java.util.HashSet;

public class gTechExample {
	

	private static int sum;
	
	public gTechExample(int sum) {
		gTechExample.sum = sum;
	}

	/*
	 * Assuming Ordered list in ascending order of int, could include negative numbers
	 */
	public int[] testSumOrdered(int[] input) {
		
		int low = 0;
		int high = input.length-1;
		
		//if second element intersects first then sum is not found
		while(high > low) {
			System.out.println(low +" " + high);
			//check sum of high + low
			int currentValue = input[low] + input[high];
			
			if(currentValue == sum) {
				return new int[] {low,high};
			}else if (currentValue < sum) {
				low+=1;
			}else if(currentValue >sum) {
				high-=1;
			}
			
		}
		
		return null;
		
	}
	
	/*
	 * Assuming UnOrdered list in ascending order of int, could include negative numbers
	 */
	public int[] testSumUnordered(int[] input) {
		
		HashSet<Integer> complement = new HashSet<Integer>();
		
		for(int i = 0; i < input.length; i++){
						
			System.out.println(i);
			
			//check if complement exists
			if(complement.contains(input[i])) {
				return new int[] {input[i], sum - input[i] };
			}else {
				//enter complement
				complement.add(sum - input[i]);
			}
			
		}
		
		return null;
	}
	
			
	public static void main (String[] args) {
		
		int[] invalidInput = {7,2,3,1,9};
		int[] validInput = {-3,4,2,5,11};
		
		gTechExample example = new gTechExample(8);
		
		//example.testSumOrdered(new int[] {1,2,3,7,9});
		//System.out.println("Invalid Input " + Arrays.toString(example.testSumUnordered(invalidInput)));
		System.out.println("Valid Input " + Arrays.toString(example.testSumUnordered(validInput)));
	}
}
