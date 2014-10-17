package se.kth.id1020.lab5;

import edu.princeton.cs.algs4.Stack;

public class DirectedDFSStack implements DirectedDFS {
	
	private boolean[] markedArray;
	private Stack<Integer> stack;
	private final Digraph G;

	/**
	 * Does a search in the graph what vertices the specified vertex can reach.
	 * @param G Graph to search.
	 * @param sourceVertex Vertex to search for.
	 */
	public DirectedDFSStack(Digraph G, int sourceVertex) {
		markedArray = new boolean[G.numOfVertices()];
		stack = new Stack<Integer>();
		this.G = G;
		
		dfs(sourceVertex);
	}
	
	/**
	 * Search all connected vertices of this vertex to see what we can reach.
	 * @param curVertex The current vertex to search from.
	 */
	public void dfs(int curVertex){
		//Push the source onto the stack.
		stack.push(curVertex);
		
		while (!stack.isEmpty())
		{
			//Do the next vertex that's on the stack.
			curVertex = stack.pop();
			
			//If we haven't done this vertex yet.
			if (!markedArray[curVertex])
			{
				markedArray[curVertex] = true;
				
				//Push all adjacent vertices onto the stack so we will do them later. 
				for (int vertex : G.adj(curVertex))
					stack.push(vertex);
			}
		}
	}

	/**
	 * Returns true if this vertex was checked in the search.
	 * @param v Vertex to check.
	 * @return Boolean value if this vertex has been checked.
	 */
	public boolean marked(int v){
		return markedArray[v];
	}
	
}