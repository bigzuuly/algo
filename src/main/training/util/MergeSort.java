package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;

/* Divide And Conquer
 * 
 * Time Complexity
 *  O(n log n) - Best
 *  O(n log n) - Average
 *  O(n log n) - Worse
 *  
 *  Space Complexity
 *   O(n)
 * 
 */
public class MergeSort<E extends Comparable<? super E>> {

	public ArrayList<E> sort(ArrayList<E> list) {
		System.out.println("Merge Sort : " + list.size());
				
		//break array in half
		int arraySize = list.size();
		int middleIndex = (int) arraySize / 2;
		
		//sorted
		if(arraySize == 1) {
			return list;
		}
		
		ArrayList<E> left = new ArrayList<E>(list.subList(0, middleIndex));
		ArrayList<E> right = new ArrayList<E>(list.subList(middleIndex, arraySize));
		
		if(left.size() != 0) {
			left = sort(left);
		}
		
		if(right.size() != 0) {
			right = sort(right);
		}
		
		//compare and sort through merge
		list = doMerge(left, right);
		System.out.println("Do Merge : " + list.size() );
		
		return list;	
	}
	
	/*
	 * Assume left and right list are in order and both left and right will have 0 or more elements
	 */
	private ArrayList<E> doMerge(ArrayList<E> left, ArrayList<E> right){
		
		//loop through each list and sort them
		int leftIndex = 0;
		int rightIndex = 0;
		int total = left.size() + right.size();
				
		ArrayList<E> sortedList = new ArrayList<E>(total);
		
		while( leftIndex + rightIndex < total ) {
			//check for 0 length array
			if(leftIndex == left.size()) {
				sortedList.addAll(right.subList(rightIndex, right.size()));
				return sortedList;
			}
			
			if(rightIndex == right.size()) {
				sortedList.addAll(left.subList(leftIndex, left.size()));
				return sortedList;
			}
			
			E leftValue = left.get(leftIndex);
			E rightValue = right.get(rightIndex);
			
			
			//System.out.println("Left Value: " + leftValue);
			//System.out.println("Right Value: " + rightValue);
			
			if(leftValue.compareTo(rightValue) < 0) {
				sortedList.add(leftValue);
				leftIndex++;
			}else {
				sortedList.add(rightValue);
				rightIndex++;
			}
		}
		
		return sortedList;
	}
	
	
	public static void main(String[] args) {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
				
		System.out.println(mergeSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,2,7,2,3,2))));
	}
	
}
