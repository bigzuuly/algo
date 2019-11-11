package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;

/*
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
			for(int j=0; j < list.size()-(i+1); j++) {	
				if(list.get(j).compareTo(list.get(j+1)) > 0) {
					//swap
					E temp = list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1, temp);
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
