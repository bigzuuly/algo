package main.training.util;

/* https://en.wikipedia.org/wiki/Binary_search_tree
 * 
 * Time Complexity - Search / Insert / Delete
 *  O(log n) - Best
 *  O(log n) - Average 
 *  O(n) - Worse
 *  
 *  Space Complexity
 *   O(n) - Average
 *   O(n) - Worse
 */
public class BinaryTree {
    Node head = null;
    
	public class Node{
    	private Node left = null;
    	private Node right = null;
    	private Integer value = null;
      private Boolean isRed = false;  // use for red black tree
    	
    	public Node() {
    	}
    	
    	public Node(Integer value) {
    		this.value = value;
    	}
    }
    
	//DFS Print
    public void printTree(Node head) {
    	if(null == head) return;
    	System.out.println(head.value);
    	
    	printTree(head.left);
    	printTree(head.right);
    }
    
    public Node search(Integer value, Node head) {
    	if(null == head) return null;
    	System.out.println("Search " + head.value);
    	
    	if(head.value == value) return head;
    	
    	if(value > head.value) {
    		return search(value, head.right);
    	}else {
    		return search(value, head.left);
    	}
    
    }
    
    public void insert(Integer value) {
    	if(head == null) {
    		head = new Node(value);
    		return;
    	}
    	
    	Node current = head;
    		
		while (true) {
    		//already there
    		if(value == current.value) return;
    		
    		if(value > current.value) {
    			if(current.right == null) {
    				current.right = new Node(value);
    				return;
    			}else{
    				current = current.right;
    			}
    		}else if (value < current.value) {
    			if(current.left == null) {
    				current.left = new Node(value);
    			}else {
    				current = current.left;
    			}
    		}
    	}
    }
    
    public void delete(Integer value) {
    	
    	//traverse tree to find reference to deleteNode
    	boolean isFound = false;
    	Node current = head;
    	Node parent = head;
    	
    	while(!isFound) {
    		if(null == current || current.value == value) {
    			isFound = true;
    			break;
    		}
    		
    		parent = current;
    		if(value > current.value) {
    			current = current.right;
    		}else {
    			current = current.left;
    		}
    		
    	}
    	
    	System.out.println("Parent: " + parent.value);
    	System.out.println("Current: " + current.value);
    	
    	if(null == current) return; //not found
    
    	//figure out correct parent reference
    	boolean isRight = false; //default left
    	if(current.value > parent.value) {
    		isRight = true;
    	}
    	
    	//case remove node if it has no children
    	if(null == current.left && null == current.right) {
    		if(isRight) {
    			parent.right = null;
    		} else {
    			parent.left = null;
    		}
    		
    		return;
    	}
    	
    	//case if has two children, find the min value on the right tree which is next largest value - successor
    	if(current.left != null && current.right != null) {
    		
        	// -- replace value to be deleted with successor
        	Node min = findMin(current.right);
        	System.out.println("Current Right:" + current.right.value);
        	System.out.println("Min:" + min.value);
    		
    		// -- delete min
    		delete(min.value);
    		
    		current.value = min.value;
        		
        
    	//case if has a single child, replace node with either left or right child
    	}else if(current.left != null) {
    		if(isRight) {
    			parent.right = current.left;
    		}else {
    			parent.left = current.left;
    		}
    	}else if(current.right != null) {
    		if(isRight) {
    			parent.right = current.right;
    		}else {
    			parent.left = current.right;
    		}
    	}
    }
    
    public Node findMin(Node start) {
    	if(start == null) return null;
    	
    	if(start.left == null) return start;
    	
    	return findMin(start.left);
    }
    
    Integer maxHeight = 0;
    public void getHeight(Node head, Integer height) {
    	if(head == null) return;
    	
    	height++;
    	
    	if(height > maxHeight) {
    		maxHeight = height;
    	}
    	
    	
    	getHeight(head.left, height);
    	getHeight(head.right, height);
    	
    }
    
	public static void main(String[] args) {
		//create example binary tree
		
		BinaryTree bt = new BinaryTree();
	
		bt.insert(8);
		bt.insert(3);
		bt.insert(10);
		bt.insert(1);
		bt.insert(6);
		bt.insert(14);
		bt.insert(7);
		bt.insert(13);
		bt.insert(4);
		
		bt.printTree(bt.head);
		
		/*
		Node result = bt.search(14, bt.head);
		if(null != result) {
			System.out.println("Found: " + result.value);
		}else {
			System.out.println("Not Found");
		}
		*/
		
		//System.out.println("####");
		//bt.delete(8);
		//Node result = bt.search(6, bt.head);
		
		//bt.printTree(bt.head);
		//Node min = bt.findMin(bt.head.right);
		//System.out.println("MMMMin: " + min.value);

		bt.getHeight(bt.head, 0);
		System.out.println("Height: " + bt.maxHeight);
		
	}
}
