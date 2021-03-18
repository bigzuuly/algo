package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://en.wikipedia.org/wiki/Selection_sort
 * 
 * Time Complexity
 *  O(n2) Comparisons / O(n) Swaps - Best
 *  O(n2) Comparisons / O(n) Swaps - Average 
 *  O(n2) Comparisons / O(n) Swaps - Worse
 *  
 *  Space Complexity
 *   O(n)
 * 
 */
public class SelectionSort<E extends Comparable<? super E>> {

	public ArrayList<E> sort(ArrayList<E> list) {
		System.out.println("Selection Sort : " + list.size());
			
		//for each iteration, look for the next smallest number and swap places with
		//the number in the correct index
		
		for(int i=0; i < list.size(); i++) {
			//set min
			E min = list.get(i);
			int minIndex = i;
			
			//look for min number
			for(int j = i+1; j < list.size(); j++) {
				if(list.get(j).compareTo(min) < 0) {
					min = list.get(j);
					minIndex = j;
				}
			}
			
			//peform swap
			E temp = list.get(i);
			list.set(i,list.get(minIndex));
			list.set(minIndex, temp);
			
			
			System.out.println(list);
		}
		
		return list;	
	}
	
	
	
	
	public static void main(String[] args) {
		SelectionSort<Integer> selection = new SelectionSort<Integer>();
        
		ArrayList<Integer> input = new ArrayList<Integer>();
        input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4)));
		//input.addAll(new ArrayList<Integer>( Arrays.asList(-1)));
		
		System.out.println(selection.sort(input));
	}
	
}
