package se.kth.id1020.lab5;

public class minVertexSearch {

	private boolean[] marked; 	//Contains info if we've visited this vertex before.
	private Integer[] minList; 	//The minimum values of each vertex. 
	private final Digraph G;
	
	public minVertexSearch(Digraph G){
		marked = new boolean[G.numOfVertices()];
		minList = new Integer[G.numOfVertices()];
		this.G = G.reverse(); //We are reversing the entire graph.
		
		calcMinValues();
	}

	/**
	 * Returns a list with the min values of each vertex.
	 * @return An Integer array.
	 */
	public Integer[] getMin(){
		return minList;
	}

	/**
	 * Calculates the minimum values for each vertex in the graph.
	 */
	private void calcMinValues(){
		//Calculate for each vertex.
		for (int i = 0; i < G.numOfVertices(); i++)
		{			
			//Don't do it if we've already done this vertex in a previous calculation.
			if (!marked[i])
			{
				//Set to null before we do anything, if this vertex turns out to not be reachable it will sill be null.
				minList[i] = null;
				calculateMin(i, i);
			}
		}
	}

	/**
	 * Calculates the min value for every vertex this vertex is connected to.
	 * @param curVertex Current vertex we are investigating. 
	 * @param sourceVertex The original vertex we are searching from.
	 */
	private void calculateMin(int curVertex, int sourceVertex){
		//Search all vertices going out of this vertex (curVertex). Since we have reversed the graph, these vertices are normally pointing to the curVertex.
		for (Integer adjVertex : G.adj(curVertex))
		{
			//Don't do this vertex if it's already been done.
			if (!marked[adjVertex])
			{
				minList[adjVertex] = sourceVertex; //Set the adjacent vertex's min value to the sourceVertex. Since we are doing this in order sourceVertex is the lowest value if we haven't been here before.    
				marked[adjVertex] = true; //We've been here, so don't do this vertex again.
				calculateMin(adjVertex, sourceVertex); //Calculate the min for all of these vertices.
			}
		}
	}
}
