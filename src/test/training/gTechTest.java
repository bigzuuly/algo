package test.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import main.training.gTechExample;
import main.training.util.BubbleSort;
import main.training.util.HeapSort;
import main.training.util.InsertionSort;
import main.training.util.MergeSort;
import main.training.util.QuickSort;
import main.training.util.SelectionSort;

@RunWith(JUnitPlatform.class)
class gTechTest {

	@Test
	void testUnordered() {
		gTechExample example = new gTechExample(8);
		
		Assert.assertArrayEquals(new int[]{1,7}, example.testSumUnordered(new int[] {7,2,3,1,9}));
		Assert.assertArrayEquals(new int[]{11,-3}, example.testSumUnordered(new int[] {-3,4,2,5,11}));
		Assert.assertArrayEquals(new int[]{4,4}, example.testSumUnordered(new int[] {4,2,5,4}));
		
	}
	
	@Test
	void testOrdered() {
		gTechExample example = new gTechExample(8);
		
		Assert.assertArrayEquals(new int[] {0,5}, example.testSumOrdered(new int[] {-1,1,2,3,7,9}));
		Assert.assertArrayEquals(new int[]{2,3}, example.testSumOrdered(new int[] {1,2,4,4}));
		
	}
	
	@Test
	void testInsertion() {
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        
		LinkedList<Integer> input = new LinkedList<Integer>();
        input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2)));
		
        LinkedList<Integer> out = insertionSort.sort(input);
        int[] outArray =  out.stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-2, 1, 2, 2, 3, 4, 5, 7},  outArray);
	}
	
	@Test
	void testMerge() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		
		int[] outArray = mergeSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,2,7,-2,3,2))).stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-2, 1, 2, 2, 3, 4, 7},  outArray);
		
	}
	
	@Test
	void testBubble() {
		BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
		
		int[] outArray = bubbleSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4))).stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-4, -2, 1, 2, 2, 3, 4, 5, 7},  outArray);
		
	}
	
	@Test
	void testSelection() {
		SelectionSort<Integer> selectionSort = new SelectionSort<Integer>();
		
		int[] outArray = selectionSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4))).stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-4, -2, 1, 2, 2, 3, 4, 5, 7},  outArray);
		
	}

	@Test
	void testHeap() {
		HeapSort<Integer> heapSort = new HeapSort<Integer>();
		
		int[] outArray = heapSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4))).stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-4, -2, 1, 2, 2, 3, 4, 5, 7},  outArray);
		
	}
	
	@Test
	void testQuick() {
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		
		int[] outArray = quickSort.sort(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4))).stream().mapToInt(Integer::intValue).toArray();
		
		Assert.assertArrayEquals(new int[] {-4, -2, 1, 2, 2, 3, 4, 5, 7},  outArray);
		
	}
}
