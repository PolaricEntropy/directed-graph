package se.kth.id1020.lab5;

public class minVertexSearch {

	Digraph G;
	boolean[] marked;
	Integer[] minList;

	public minVertexSearch(Digraph G){
		marked = new boolean[G.numOfVertices()];
		minList = new Integer[G.numOfVertices()];
		this.G = G.reverse(); //We are reversing the entire graph.
		
		//Calculate the min values for all vertices.
		calcMinValues();
	}

	public Integer[] getMin(){
		return minList;
	}

	private void calcMinValues(){
		//Calculate for each vertex.
		for (int i = 0; i < G.numOfVertices(); i++)
		{			
			//Don't do it if we've already done this vertex in a previous calculation.
			if (!marked[i])
			{
				//Set to null before we do anything, if this vertex turns out to not be reachable it will will be null.
				minList[i] = null;
				min(i, i);
			}
		}
	}

	private void min(int vertex, int min){
		//Search all vertices going out of this vertex.
		//Since we have reversed these vertices are normally pointing to this vertex. Their min is thus the original vertex we are calculating for.
		for (Integer v : G.adj(vertex))
		{
			if (!marked[v])
			{
				minList[v] = min;
				marked[v] = true; //We've been here, so don't do this vertex again.
				min(v, min); //Calculate the min for all of these vertices.
			}
		}
	}
}
