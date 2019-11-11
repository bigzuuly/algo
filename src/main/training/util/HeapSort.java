package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;

/* https://en.wikipedia.org/wiki/Heapsort
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
public class HeapSort<E extends Comparable<? super E>> {
	
	// max heap implementation
	private ArrayList<E> heap = new ArrayList<E>();
	
	// Returns position of parent 
    private int parent(int pos) 
    { 
        return (pos - 1) / 2; 
    } 
  
    // Below two functions return left and 
    // right children. 
    private int leftChild(int pos) 
    { 
        return (2 * pos) + 1; 
    }
    
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 2; 
    } 
    
    
    private void swap(int position1, int position2) {
		E temp = heap.get(position1);
		heap.set(position1, heap.get(position2));
		heap.set(position2, temp);
    }
    
    //siftup approach
    //rebuild heap by fixing each element again, n log n
    private void heapify(int position) {
    	boolean isHeapified = false;
    	
    	
    	//if 1 element, heap is sorted
    	if(position == 0) return;
    	
    	//place in correct order in heap
    	while(!isHeapified) {
    		
    		int parent = parent(position);
    		if( heap.get(parent).compareTo(heap.get(position)) < 0){
    			
    			//swap
    			swap(parent, position);
    			
    			//set new current
    			position = parent;
    			
    		} else {
    			isHeapified = true;
    		}
    	}
    }
    
    //Siftdown approach
    //fix broken heap starting at the root
    //assume that heaps under left and right children are valid
    private void heapifySiftDown(int current, int end) {
    	
    	//check left and right children
    	int leftChild = leftChild(current);
    	int rightChild = rightChild(current);
    	
    	//leaf node
    	if(leftChild > end && rightChild > end) return;
    	
    	//check left if right is END
    	if(rightChild > end) {
    		System.out.println("!!!!!! Current: "+current+" End: " + end );
    		
    		//check on left child and return
    		if( heap.get(current).compareTo(heap.get(leftChild)) < 0 ) {
    			System.out.println("Current: " + heap.get(current) + " Left Child: " + heap.get(leftChild) );
    			swap(current, leftChild);
    		}
    		
    		return;
    	}
    	
    	//continue swap so that parent is larger than both children
    	
    	//if both children are bigger
    	//compare left and right child to figure out which subtree to traverse
    	if( heap.get(current).compareTo(heap.get(leftChild)) < 0 && heap.get(current).compareTo(heap.get(rightChild)) < 0 ){
    		
    		//if right child is bigger than left child, swap current with right
    		if(heap.get(rightChild).compareTo(heap.get(leftChild)) > 0) {
    			swap(current, rightChild);
    			
    			//continue
    			heapifySiftDown(rightChild, end);
    		}else { //swap current with left
    			swap(current, leftChild);
    			
    			//continue
    			heapifySiftDown(leftChild, end);
    		}
    		
    	}
    	
    	//only right child is bigger
    	if ( heap.get(current).compareTo(heap.get(rightChild)) < 0 ) { 
    		swap(current, rightChild);
			
			//continue
			heapifySiftDown(rightChild, end);
    	}
    	
    	//only left child is bigger
    	if ( heap.get(current).compareTo(heap.get(leftChild)) < 0 ) { 
    		swap(current, leftChild);
			
			//continue
			heapifySiftDown(leftChild, end);
    	}
    	
    }
    
    
    private String getTabsByLevel(int level) {
    	//get total levels
    	int totalLevels = (int) (Math.log(heap.size()) / Math.log(2));
    	    	
    	StringBuffer tabString = new StringBuffer();
    	
    	for(int i=0; i < (int) totalLevels-level+1 / 2; i++) {
    		tabString.append("\t");
    		
    	}
    	
    	return tabString.toString();
    }
    
    //recursively traverses heap
    //breadth first 
    public void print(int level) {
    	
    	int numNodesByLevel = (int) Math.pow(2, level);
    	int firstIndexAtLevel = numNodesByLevel - 1;
    	
    	System.out.print(getTabsByLevel(level));
    	
    	for(int i=0; i < numNodesByLevel; i++) {
    		if(firstIndexAtLevel + i < heap.size()) {
    			System.out.print(heap.get(firstIndexAtLevel + i) + "\t");
    		}else {
    			return;
    		}
    	}
    	
    	System.out.println();
    	
    	print(level+1);
    	
    }
    	
    private void insert(E value) {
    	heap.add(value);
    	
    	//add new element in proper place in heap
    	heapify(heap.size()-1);
    }
    
    public ArrayList<E> getHeap(){
    	return heap;
    }
    
    
    //in place sort
	public ArrayList<E> sort(ArrayList<E> list) {
		System.out.println("Heap Sort : " + list.size());
			
		//step 1 - build heap
		//for each element add to heap
		//update heap to be a proper max heap
		
		for (E element : list) {
			insert(element);
		}
		
		
		//step 2 - sort
		
		//repeat until last element is first element - sorted
		//swap first element(largest) with last element
		//update heap to be a proper max heap
		
		int end = heap.size() - 1;
		while(end > 0) {
			System.out.println("Swap head ("+heap.get(0)+") with end:"  +  end);
			swap(0, end);
			
			end--;
			
			/*
			for(int i=0; i<end+1; i++) {
				heapify(i);
			}
			*/
			
			heapifySiftDown(0, end);
			
			print(0);
			System.out.println("########");
		}
		
		
		
		return heap;	
	}
	
	
	
	
	public static void main(String[] args) {
		HeapSort<Integer> heapSort = new HeapSort<Integer>();
        
		/*
			heapSort.print(0);
		*/
		
		ArrayList<Integer> input = new ArrayList<Integer>();
        //input.addAll(new ArrayList<Integer>( Arrays.asList(1,4,5,2,7,-2,3,2,-4)));
		input.addAll(new ArrayList<Integer>( Arrays.asList(5,3,17,10,84,19,6,22,-3,9)));
		//input.addAll(new ArrayList<Integer>( Arrays.asList(4,1,2)));
				
		System.out.println(heapSort.sort(input));
		
	}
	
}
