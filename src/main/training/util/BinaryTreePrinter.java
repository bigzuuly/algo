package main.training.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreePrinter {

	private void left(int index, ArrayList<Integer> tree) {
		
	}
	
    private void right(int index, ArrayList<Integer> tree) {
		
	}
	
    //iterative
	private void printBFS(ArrayList<Integer> tree) {
		System.out.println("BinaryTreePrinter - Breadth First Search");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		
		while(!queue.isEmpty()){
			//remove node, print and check children
			int node = queue.remove().intValue();
			System.out.println(node + " (" + tree.get(node)+")");
			
			//check left
			int leftChild = 2*node;
			if(leftChild < tree.size() && null != tree.get(leftChild)) {
				queue.add(new Integer(leftChild));
			}
			
			//check right
			int rightChild = 2*node + 1;
			if(rightChild < tree.size() && null != tree.get(rightChild)) {
				queue.add(new Integer(rightChild));
			}
		}
	}
	
	//iterative
	private void printDFS(ArrayList<Integer> tree) {
		System.out.println("BinaryTreePrinter - Depth First Search");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		
		while(!stack.empty()){
			//remove node, print and check children
			int node = stack.pop().intValue();
			System.out.println(node + " (" + tree.get(node)+")");
			
			//check right
			int rightChild = 2*node + 1;
			if(rightChild < tree.size() && null != tree.get(rightChild)) {
				stack.push(new Integer(rightChild));
			}
			
			//check left
			int leftChild = 2*node;
			if(leftChild < tree.size() && null != tree.get(leftChild)) {
				stack.push(new Integer(leftChild));
			}
		}
	}

	public static void main( String[] args ) {
		BinaryTreePrinter printer = new BinaryTreePrinter();
		
		//test array
		//https://nptel.ac.in/courses/106103069/51
		ArrayList<Integer> testTree = new ArrayList<Integer>(Arrays.asList(
			null,3,5,9,6,8,20,10,null,null,9
		));
		
		
		printer.printBFS(testTree);
		
		System.out.println("\n########################\n");
		
		printer.printDFS(testTree);
			
	}

}
