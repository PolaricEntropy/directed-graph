package se.kth.id1020.lab5;

public class DirectedDFS{

	private boolean[] markedArray;

	/**
	 * Does a search in the graph what vertices the specified vertex can reach.
	 * @param G The graph to search.
	 * @param s The vertex to search.
	 */
	public DirectedDFS(Digraph G, int s){
		markedArray = new boolean[G.numOfVertices()];
		dfs(G, s);
	}
	
	/**
	 * Searches the graph what vertices the specified vertices can reach.
	 * @param G The graph to search.
	 * @param sources The vertices to search.
	 */
	public DirectedDFS(Digraph G, Iterable<Integer> sources){
		markedArray = new boolean[G.numOfVertices()];
		
		//Add all edges to the graph.
		for (int s : sources)
		{
			if (!markedArray[s])
				dfs(G, s);
		}
	}
	
	private void dfs(Digraph graph, int vertexToSearch){
		markedArray[vertexToSearch] = true;
			
		//Visit all vertices this vertex is connected to.
		for (int vertex : graph.adj(vertexToSearch))
		{
			//If we haven't visited this vertex, then check what that vertex can reach.
			if (!markedArray[vertex])
				dfs(graph, vertex);
		}	
	}

	public boolean marked(int v){
		return markedArray[v];
	}
}