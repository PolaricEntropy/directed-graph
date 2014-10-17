package se.kth.id1020.lab5;

public class DirectedDFS{

	private boolean[] markedArray;
	private final Digraph G;
	
	/**
	 * Does a search in the graph what vertices the specified vertex can reach.
	 * @param G The graph to search.
	 * @param s The vertex to search.
	 */
	public DirectedDFS(Digraph G, int s){
		markedArray = new boolean[G.numOfVertices()];
		this.G = G;
		
		dfs(s);
	}
	
	/**
	 * Search all connected vertices of this vertex to see if we can.
	 * @param vertexToSearch 
	 */
	private void dfs(int vertexToSearch){
		markedArray[vertexToSearch] = true;
			
		//Visit all vertices this vertex is connected to.
		for (int vertex : G.adj(vertexToSearch))
		{
			//We want to list all vertices we can reach from out first vertex.
			//If we haven't visited this vertex, then check what that vertex can reach and so on.
			if (!markedArray[vertex])
				dfs(vertex);
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