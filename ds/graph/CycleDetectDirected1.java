package com.ds.graph;

//A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDetectDirected1 {

	private final int V;
	private final List<List<Integer>> adj;

	public CycleDetectDirected1(int V)
	{
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	// This function is a variation of DFSUtil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited)
	{

		// Mark the current node as visited and
		// part of recursion stack
		//if (recStack[i])
		//	return true;

		if (visited[i])
			return true;

		visited[i] = true;

		//recStack[i] = true;
		List<Integer> children = adj.get(i);

		for (Integer c: children)
			if (isCyclicUtil(c, visited))
				return true;

		//recStack[i] = false;

		return false;
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic()
	{

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		//boolean[] recStack = new boolean[V];


		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++) {
			if(!visited[i]) {
				if (isCyclicUtil(i, visited))
					return true;
			}
			
			visited[i] = false;
		}			

		return false;
	}

	// Driver code
	public static void main(String[] args)
	{
		CycleDetectDirected1 graph = new CycleDetectDirected1(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if(graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
					+ "contain cycle");
	}
}