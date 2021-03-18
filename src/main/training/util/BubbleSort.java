package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://en.wikipedia.org/wiki/Bubble_sort
 * 
 * Time Complexity
 *  O(n) - Best
 *  O(n2) - Average 
 *  O(n2) - Worse
 *  
 *  Space Complexity
 *   O(n)
 * 
 */
public class BubbleSort<E extends Comparable<? super E>> {

	public ArrayList<E> sort(ArrayList<E> list) {
		System.out.println("Bubble Sort : " + list.size());
			
		//for each element in list, compare next and swap current is larger
		//repeat n-1 as the nth element will be sorted after the first pass
		
		for(int i=0; i < list.size(); i++) {
			for(int j=i; j < list.size(); j++) {	
				if(list.get(j).compareTo(list.get(i)) < 0) {
					//swap
					E temp = list.get(j);
					list.set(j,list.get(i));
					list.set(i, temp);
				}
			}
			
			//System.out.println(list);
		}
		
		return list;	
	}
	
	
	
	
	public static void main(String[] args) {
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        
		ArrayList<Integer> input = new ArrayList<Integer>();
        input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4)));
		//input.addAll(new ArrayList<Integer>( Arrays.asList(-1)));
		
		System.out.println(bubbleSort.sort(input));
	}
	
}
