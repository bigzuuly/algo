package main.training.util;

public class LinkedList<E extends Comparable<? super E>> {

	private Node<E> head = null;
	private Node<E> tail = null;
	
	class Node<E extends Comparable<? super E>>{
		
		private Node<E> next;
		private E element;
		
		public E getValue() {
			return this.element;
		}
		
		public Node<E> next() {
			return this.next;
		}
		
		public Node (E element){
			this.next = null;
			this.element = element;
			
		}
	}

	public void add(E element) {
		Node<E> node = new Node<E>(element);
		
		//check head, set if null
		if(null == head) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			tail = tail.next();
		}
		
	}
	
	public void reverse() {
		//setup references
		tail = head;
		Node<E> current = head;
		Node<E> next = null;
		Node<E> previous = null;
		
		//while current is not null
		//swap pointers to reverse
		
		while(null != current) {
			System.out.println("reverse " + current.getValue());

			next = current.next();
			current.next = previous;
			previous = current;
						
			current = next;
						
		}
		
		//set head
		head = current;
		
	}
	
	public void print() {
		Node<E> current = head;
		
		while(null != current) {
			System.out.println("Node: " + current.getValue());
			current = current.next();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Linked List");
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(4);
		
		linkedList.print();
		
		linkedList.reverse();
		linkedList.print();
		
	}
}
