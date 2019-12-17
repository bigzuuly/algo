package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * https://en.wikipedia.org/wiki/Insertion_sort
 * 
 * Time Complexity
 *  O(n) comparisons, O(1) swaps - Best
 *  О(n2) comparisons and swaps - Average 
 *  О(n2) comparisons and swaps - Worse
 *  
 *  Space Complexity
 *   O(n)
 * 
 */
public class InsertionSort<E extends Comparable<? super E>> {

	public LinkedList<E> sort(LinkedList<E> list) {
		System.out.println("Insertion Sort : " + list.size());
			
		//for each element in list, look at all previous elements and insert in correct sorted order 
		for(int i=0; i<list.size(); i++) {
			
			int j = i;
			boolean found = false;
			while(!found) {
				
				if(j > 0 && list.get(i).compareTo(list.get(j-1)) < 0) {
					j--;
					//System.out.println(i + ":j--" + j);
				}else {
					//System.out.println(j + "swap");
					//if j=0, then swap as well to move the element to the first position
					//insert element at j and remove from i
					E currentElement = list.get(i);
					list.remove(i);
					list.add(j, currentElement);
					
					found = true;
				}
			}
			
			//System.out.println("####");
		}
		
		return list;	
	}
	
	
	
	
	public static void main(String[] args) {
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        
		LinkedList<Integer> input = new LinkedList<Integer>();
        input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2)));
		//input.addAll(new ArrayList<Integer>( Arrays.asList(-1,-51,-44,-2)));
		
		System.out.println(insertionSort.sort(input));
	}
	
}
