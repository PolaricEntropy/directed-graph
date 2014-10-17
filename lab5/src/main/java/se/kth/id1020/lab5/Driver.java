package se.kth.id1020.lab5;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Driver 
{
    public static void main(String[] args)
    {
    	//Read the file from the arguments.
    	In fs = new In(args[0]);
    	
    	//Create a graph with the number of vertices.
    	Digraph G = new Digraph(fs.readInt());
    	
    	//The amount of edges we should add.
    	int edges = fs.readInt();
    	
    	//Read the edges from the file and add then to the graph.
    	for(int i = 0; i < edges; i++)
    		G.addEdge(fs.readInt(), fs.readInt());

    	//searchRecursive(args, G);
    	
    	searchNonRecursive(args, G);
    	
    	//smallestVertex(G);
    }
    
    public static void searchRecursive(String[] args, Digraph G){
    	
    	//Read our search file.
    	In fs = new In(args[1]);
    	
    	//Search for each thing in the file, line by line.
    	while (fs.hasNextLine())
    	{
    		int vertex = fs.readInt();
    		
    		StdOut.println("Reachable vertices from: " + vertex);
    		
    		//Create a new search and search for the vertex.
        	DirectedDFS search = new DirectedDFS(G, vertex);
        	
        	//Check if each vertex in the graph was reachable from the one we searched for.
        	for (int v = 0; v < G.numOfVertices(); v++)
        	{
        		if (search.marked(v))
        			StdOut.print(v + " ");
        	}
        	
        	StdOut.println();
    	} 	
    }
    
    public static void searchNonRecursive(String[] args, Digraph G){
    	
    	//Read our search file.
    	In fs = new In(args[1]);
    	
    	//Search for each thing in the file, line by line.
    	while (fs.hasNextLine())
    	{
    		int vertex = fs.readInt();
    		
    		StdOut.println("Searching for: " + vertex);
    		
    		//Create a new search.
    		DirectedDFSStack search = new DirectedDFSStack(G, vertex);
        	
    		//Check each vertex in the graph.
    		for (int v = 0; v < G.numOfVertices(); v++)
    		{
    			if (search.hasPathTo(v))
    			{
    				StdOut.printf("%d to %d:  ", vertex, v);
    				for (int x : search.pathTo(v))
    				{
    					if (x == vertex)
    						StdOut.print(x);
    					else
    						StdOut.print("-" + x);
    				}
    				StdOut.println();
    			}
    			else
    				StdOut.printf("%d to %d:  not connected\n", vertex, v);
    		}
    	}
    }
    
    public static void smallestVertex(Digraph G){
    	
    	minVertexSearch search = new minVertexSearch(G);
    	
    	Integer[] minList = search.getMin();
    	
    	for(int i = 0; i < minList.length; i++)
		{
    		//If list element is null, then that vertex is not pointing to anything, thus it doesn't have a min value.
			if(minList[i] != null)
				StdOut.printf("%s -> %s\n", i, minList[i]);	
		}
    }
}
