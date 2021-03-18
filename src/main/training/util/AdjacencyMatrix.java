package main.training.util;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Using the following graph as an example:
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * 
 */
public class AdjacencyMatrix {

	public class Edge {
		int distance = 0;
		
		public Edge() {
			
		}
		
		public Edge(int distance) {
			this.distance = distance;
		}
		
		public void setDistance(int distance) {
			this.distance = distance;
		}
		
		public int getDistance() {
			return distance;
		}
	}
	
	ArrayList<ArrayList<Edge>> matrix;
	
	public AdjacencyMatrix() {
		
	}
	
	public AdjacencyMatrix(int numVertices) {
		matrix = new ArrayList<ArrayList<Edge>>(numVertices);
		
		for(int i = 0; i<numVertices; i++) {
			ArrayList<Edge> tempList = new ArrayList<Edge>(numVertices);
			
			for(int j=0; j < numVertices; j++) {
				tempList.add(null);
			}
			
			matrix.add(tempList);
		}
	}
	
	public ArrayList<Integer> getNeighbors(Integer vertex){
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		
		for(int i=0; i<matrix.get(vertex).size(); i++) {
			Edge node = matrix.get(vertex).get(i);
			if( null != node) {
				neighbors.add(Integer.valueOf(i));
			}
		}

		//Collections.reverse(neighbors);
		return neighbors;
	}
	
	public boolean isNeighbor(Integer vertexA, Integer vertexB) {
		if(null != matrix.get(vertexA).get(vertexB)) return true;
		
		return false;
	}
	
	public void traverse(Integer start, ArrayList<Integer> visited) {
		//takes in a vertex and traverses graph
		//first by visiting all neighbors
		//and then neighbors neighbor
		//prevent loop by maintaining a list of visited vertices
		
		//check if vertex has been visited
		if(!visited.contains(start)) {
			System.out.println(start);
			visited.add(start);
			
			//get neighbors
			ArrayList<Integer> neighbors = getNeighbors(start);
			System.out.println("Neighbors:" + neighbors);
			for (Integer neighbor:neighbors) {
				traverse(neighbor, visited);
			}
		}
		
		//otherwise
		return;
	}
	
	public boolean getRoute(Integer start, Integer end, Stack<Integer> route, ArrayList<Integer> visited) {
		
		System.out.println("Start: " + start + " End: " + end);
		
		//check if end has been reach
		if(start.compareTo(end) == 0) {
			System.out.println("found: " + start);
			return true;
		}
		
		//check if vertex is not visited
		if(!visited.contains(start)) {
			visited.add(start);
			
			System.out.println("Visited:" + visited);
			
			//get neighbors
			ArrayList<Integer> neighbors = getNeighbors(start);
			System.out.println("Neighbors:" + neighbors);
			
			
			for (Integer neighbor:neighbors) {
				boolean found = getRoute(neighbor, end, route, visited);

				if(found) {
					System.out.println("found");
					route.push(neighbor);
					
					System.out.println("---- " + route);
					
					return found;
				}
			}
			
		}
		
		return false;
		
	}
	
	/*
	public static ArrayList<Node> initializeArray(int size) {
		ArrayList<Node> tempList = new ArrayList<Node>(size);
		
		for(int i=0; i < size; i++) {
			tempList.add(null);
		}
		
		return tempList;
	}
	*/
	
	/*
	 * Can be used to update edge as well
	 */
	public void addEdge(int vertex1, int vertex2, Edge edge) {
		matrix.get(vertex1).set(vertex2, edge);
		matrix.get(vertex2).set(vertex1, edge);
	}
	
	public void removeEdge(int vertex1, int vertex2) {
		matrix.get(vertex1).set(vertex2, null);
		matrix.get(vertex2).set(vertex1, null);
	}
	
	public Edge getEdge(int vertex1, int vertex2) {
		return matrix.get(vertex1).get(vertex2);
	}
	
	public int size() {
		return matrix.size();
	}
	
	public static void main(String[] args) {
	
		System.out.println("Adjancency Matrix");
		//create matrix 5X5
		AdjacencyMatrix graph = new AdjacencyMatrix(5);
		
		graph.addEdge(0,1, graph.new Edge());
		graph.addEdge(0,4, graph.new Edge());
				
		graph.addEdge(1,2, graph.new Edge());
		graph.addEdge(1,3, graph.new Edge());
		graph.addEdge(1,4, graph.new Edge());
		
		graph.addEdge(2,3, graph.new Edge());
		
		graph.addEdge(3,4, graph.new Edge());
		
		System.out.println(graph.getNeighbors(3));
		
		//graph.traverse(0, new ArrayList<Integer>());
		
		//System.out.println(graph.isNeighbor(3, 1));
		
		//get route
		Stack<Integer> route = new Stack<Integer>(); 
		graph.getRoute(0, 4, route, new ArrayList<Integer>());
		System.out.println("Route: " + route);
	}
	
}
