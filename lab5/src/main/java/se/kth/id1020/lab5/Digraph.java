package se.kth.id1020.lab5;

import edu.princeton.cs.algs4.Bag;

public class Digraph
{
	private final int vertices;
	private int edges;
	private Bag<Integer>[] adj;
	
	public Digraph(int V){
		this.vertices = V;
		this.edges = 0;
		
		adj = (Bag<Integer>[]) new Bag[V];
		
		//Fill the bag array with new bags.
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	public int numOfVertices(){
		return vertices; 
	}
	
	public int numOfEdges(){
		return edges;
		}
	
	public void addEdge(int v, int w){
		adj[v].add(w); //Add a mapping in the correct bag.
		edges++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	/**
	 * Creates a new graph with reversed edges.
	 * @return Returns a reversed graph.
	 */
	public Digraph reverse(){
		Digraph reversed = new Digraph(vertices);
		
		//Go through each vertex, and for each edge add a reversed version in the reversed graph.
		for (int v = 0; v < vertices; v++)
		{
			for (int w : adj(v))
			{
				reversed.addEdge(w, v);
			}
		}
		
		return reversed;
	}
}
