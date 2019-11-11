package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://en.wikipedia.org/wiki/Quicksort
 * 
 * Divide And Conquer
 * 
 * Time Complexity
 *  O(n log n) - Best
 *  O(n log n) - Average 
 *  O(n2) - Worse
 *  
 *  Space Complexity
 *   O(n)
 * 
 */
public class QuickSort<E extends Comparable<? super E>> {
	
    
    //in place sort
	public ArrayList<E> sort(ArrayList<E> list) {
		System.out.println("Quick Sort : " + list.size());
		
		qSort(list);
		
		return list;	
	}
	
	private void qSort(List<E> list) {
		//repeat until array has 1 or 0 elements - as this is sorted
		if(list.size() == 0 || list.size() == 1) {
			return;
		}
		
		//step 1 - partition (elements greater or equal value is placed after pivot in the array, while elements less than are placed before)
		int pivotIndex = partition(list);
		
		//step 2 - partition left array 0 -> pivotIndex - 1
		qSort(list.subList(0, pivotIndex));
		
		//step 3 - partition right array pivotIndex -> last element
		qSort(list.subList(pivotIndex, list.size()));
		
		System.out.println("Pivot: " + pivotIndex);
	}
	
	private int partition(List<E> list) {
		System.out.println("Partition:");
		
		//pick last element in array as pivot
		E pivot = list.get(list.size() - 1);
		int pivotIndex = list.size() - 1;
		int current = 0;
		
		while(current < pivotIndex) {
			if(list.get(current).compareTo(pivot) > 0) {
				//move item to end of array (right of pivot)
				E temp = list.get(current);
				
				//insert after pivot
				list.add(pivotIndex+1, temp);
				list.remove(current);
				
				pivotIndex--;
				
				
			}else {
				//nothing moved, check the next element
				current++;
			}
			System.out.println(list);
		}
		
		return pivotIndex;
	}
	
	
	
	
	public static void main(String[] args) {
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
        
		/*
		heapSort.insert(5); 
		heapSort.insert(3); 
		heapSort.insert(17); 
		heapSort.insert(10); 
		heapSort.insert(84); 
		heapSort.insert(19); 
		heapSort.insert(6); 
		heapSort.insert(22); 
		heapSort.insert(9); 
		
		heapSort.print(0);
		*/
		
		ArrayList<Integer> input = new ArrayList<Integer>();
        //input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4)));
		input.addAll(new ArrayList<Integer>( Arrays.asList(5,3,17,10,84,19,6,22,-3,9)));
		
		System.out.println(quickSort.sort(input));
	}
	
}
