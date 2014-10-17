package se.kth.id1020.lab5;

import edu.princeton.cs.algs4.Stack;

public class DirectedDFSStack {
	
	private boolean[] marked;  // marked[v] = true if v is reachable from s
	private int[] lastVertex;  // lastVertex[v] = last vertex on path from s to v
	private final int sourceVertex;
	private final Digraph G;

	/**
	 * Does a search in the graph what vertices the specified vertex can reach.
	 * @param G Graph to search.
	 * @param s Vertex to search for.
	 */
	public DirectedDFSStack(Digraph G, int s) {
		marked = new boolean[G.numOfVertices()];
		lastVertex = new int[G.numOfVertices()];
		this.G = G;
		this.sourceVertex = s;
		
		dfs(s);
	}

	/**
	 * Search all connected vertices of this vertex to see if we can.
	 * @param vertexToSearch The vertex to search for.
	 */
	public void dfs(int vertexToSearch) { 
		marked[vertexToSearch] = true;
		
		//Search all vertices connected to this vertex.
		for (int w : G.adj(vertexToSearch))
		{
			//If we haven't been here before.
			if (!marked[w])
			{
				//Set the connected vertex's lastVertex/edge to the vertexToSearch so we know where we came from.
				lastVertex[w] = vertexToSearch;
				dfs(w);
			}
		}
	}

	/**
	 * Checks if there is a path from the source vertex to the specified one.
	 * @param v The vertex to check.
	 * @return Returns true if there is a path between the two vertices.
	 */
	public boolean hasPathTo(int v) {
		//If we've visted this vertex we have a path to it.
		return marked[v];
	}
	
	/**
	 * Returns the directed path from the source vertex to the supplied vertex.
	 * @param v The destination vertex.
	 * @return Returns an iterable list of vertices that's in the path, or returns null if there is no path. 
	 */
	public Iterable<Integer> pathTo(int v) {
		//Check if we have a path.
		if (!hasPathTo(v))
			return null;
		
		//Create a new stack to store the path to.
		Stack<Integer> path = new Stack<Integer>();
		
		//Start from the end of the path and go backwards.
		for (int x = v; x != sourceVertex; x = lastVertex[x])
			path.push(x);
		
		//Push the source vertex last.
		path.push(sourceVertex);
		return path;
	}
}