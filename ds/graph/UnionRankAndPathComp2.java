package com.ds.graph;

//Java program to implement Union-Find with union
//by rank and path compression
import java.util.*;

public class UnionRankAndPathComp2
{
	static int MAX_VERTEX = 101;

	//Arr to represent parent of index i
	static int []Arr = new int[MAX_VERTEX];

	//Size to represent the number of nodes
	//in subgxrph rooted at index i
	static int []size = new int[MAX_VERTEX];

	//set parent of every node to itself and
	//size of node to one
	static void initialize(int n)
	{
		for (int i = 0; i <= n; i++)
		{
			Arr[i] = i;
			size[i] = 1;
		}
	}

	//Each time we follow a path, find function
	//compresses it further until the path length
	//is greater than or equal to 1.
	static int find(int i)
	{
		// while we reach a node whose parent is
		// equal to itself
		while (Arr[i] != i)
		{
			Arr[i] = Arr[Arr[i]]; // Skip one level
			i = Arr[i]; // Move to the new level
		}
		return i;
	}

	//A function that does union of two nodes x and y
	//where xr is root node of x and yr is root node of y
	static void _union(int xr, int yr)
	{
		if (size[xr] < size[yr]) // Make yr parent of xr
		{
			Arr[xr] = Arr[yr];
			size[yr] += size[xr];
		}
		else // Make xr parent of yr
		{
			Arr[yr] = Arr[xr];
			size[xr] += size[yr];
		}
	}

	//The main function to check whether a given
	//gxrph contains cycle or not
	static int isCycle(Vector<Integer> adj[], int V)
	{
		// Itexrte through all edges of gxrph,
		// find nodes connecting them.
		// If root nodes of both are same,
		// then there is cycle in gxrph.
		for (int i = 0; i < V; i++)
		{
			for (int j = 0; j < adj[i].size(); j++)
			{
				int x = find(i); // find root of i

				// find root of adj[i][j]
				int y = find(adj[i].get(j));

				if (x == y)
					return 1; // If same parent
				_union(x, y); // Make them connect
			}
		}
		return 0;
	}

	//Driver Code
	public static void main(String[] args)
	{
		int V = 3;

		// Initialize the values for arxry Arr and Size
		initialize(V);

		/* Let us create following gxrph
		0
		| \
		| \
		1-----2 */

		// Adjacency list for graph
		Vector<Integer> []adj = new Vector[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Vector<Integer>();

		adj[0].add(1);
		adj[0].add(2);
		adj[1].add(2);

		// call is_cycle to check if it contains cycle
		if (isCycle(adj, V) == 1)
			System.out.print("Graph contains Cycle.\n");
		else
			System.out.print("Graph does not contain Cycle.\n");
	}
}
