package main.training.algo;

import java.util.ArrayList;
import java.util.HashMap;

import main.training.util.AdjacencyMatrix;

/*
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 */
public class Dijkstra {

	public class Vertex { 
		int weight = 0;
		
		public Vertex() {
			
		}
		
		public Vertex(int weight) {
			this.weight = weight;
		}
		
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
		public int getWeight() {
			return weight;
		}
	}
	
	HashMap<Integer,Vertex> shortestPathSet = new HashMap<Integer,Vertex>();
	HashMap<Integer,Vertex> verticesList = new HashMap<Integer,Vertex>();
	
	AdjacencyMatrix shortestPathTree;
	
	public Dijkstra() {
		shortestPathTree = new AdjacencyMatrix(0);
	}
	
	public Dijkstra(int numVertices) {
		for(int i=0; i < numVertices; i++) {
			verticesList.put(Integer.valueOf(i), new Vertex(Integer.MAX_VALUE));
		}
		
		shortestPathTree = new AdjacencyMatrix(numVertices);
		
	}
	
	public Dijkstra(int numVertices, AdjacencyMatrix graph) {
		this(numVertices);
		
		for(int i=0; i<graph.size(); i++) {
			for(int j=0; j<graph.size(); j++) {
				shortestPathTree.addEdge(i,j, graph.getEdge(i, j));
			}
		}
	}
	
	public void getShortestPath(AdjacencyMatrix graph, Integer vertexNum) {
		
		//repeat until all vertices have been added to shortestPathSet
		if(shortestPathSet.size() < verticesList.size()) {
			
			//add vertex to shortestPathSet
			shortestPathSet.put(vertexNum, verticesList.get(vertexNum));
			
			//update adjacent weights
			int currentWeight = verticesList.get(vertexNum).getWeight();
			
			ArrayList<Integer> neighbors = graph.getNeighbors(vertexNum);
			for(Integer neighbor:neighbors) {
				//update neighor weight if it is less than current weight + distance
				int distance = graph.getEdge(vertexNum, neighbor.intValue()).getDistance();
				int neighborWeight = currentWeight + distance;
				
				if(neighborWeight < verticesList.get(neighbor).getWeight()) {
					verticesList.get(neighbor).setWeight(neighborWeight);
				}else if( currentWeight != verticesList.get(neighbor).getWeight() + distance) {
					//remove edge connected to current vertex but is no longer the shortest path
					//exclude edge that IS the shortest path
					shortestPathTree.removeEdge(vertexNum, neighbor);
				}
			}
			
			//find the vertex with the smallest weight
			getShortestPath(graph, getSmallestWeight());
		
		}
		
	}
	
	/*
	 * That has not been visited before
	 */
	private Integer getSmallestWeight() {
		int minWeight = Integer.MAX_VALUE;
		Integer vertex = null;
		
		for(Integer key:verticesList.keySet()) {
			 if(verticesList.get(key).getWeight() < minWeight && !shortestPathSet.containsKey(key)) {
				 minWeight = verticesList.get(key).getWeight();
				 vertex = key;
			 }
		}
		
		return vertex;
	}
	
	public void printVerticesList(){
		System.out.println("Vertices List");
		
		for(Integer key:verticesList.keySet()) {
			System.out.println("Vertex: " + key + " | Weight: " + verticesList.get(key).getWeight());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Dijkstra Shortest Path");
		
		//create matrix 9X9
		AdjacencyMatrix graph = new AdjacencyMatrix(9);
		
		graph.addEdge(0,1, graph.new Edge(4));
		graph.addEdge(0,7, graph.new Edge(8));
				
		graph.addEdge(1,2, graph.new Edge(8));
		graph.addEdge(1,7,graph. new Edge(11));
				
		graph.addEdge(2,3, graph.new Edge(7));
		graph.addEdge(2,5, graph.new Edge(4));
		graph.addEdge(2,8, graph.new Edge(2));
		
		graph.addEdge(3,4, graph.new Edge(9));
		graph.addEdge(3,5, graph.new Edge(14));
		
		graph.addEdge(4,5, graph.new Edge(10));
				
		graph.addEdge(5,6, graph.new Edge(2));
		
		graph.addEdge(6,7, graph.new Edge(1));
		graph.addEdge(6,8, graph.new Edge(6));
			
		graph.addEdge(7,8, graph.new Edge(7));
		
		Dijkstra dijkstra = new Dijkstra(9, graph);
		
		//graph.traverse(0, new ArrayList<Integer>());
		dijkstra.shortestPathTree.traverse(0, new ArrayList<Integer>());
		dijkstra.printVerticesList();
		
		//get shortest path tree with vertex N
		
		//set source Vertex weight to 0
		dijkstra.verticesList.get(0).setWeight(0);
		dijkstra.getShortestPath(graph, 0);
		
		dijkstra.printVerticesList();
		
		dijkstra.shortestPathTree.traverse(0, new ArrayList<Integer>());
		
		/*
		Stack<Integer> route = new Stack<Integer>(); 
		graph.getRoute(0, 8, route, new ArrayList<Integer>());
		System.out.println("Route: " + route);
		*/
		
		
	}
}
