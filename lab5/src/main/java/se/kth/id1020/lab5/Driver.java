package se.kth.id1020.lab5;

import java.util.ArrayList;

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

    	//Close the stream to allow other stuff to use the file since we are done with it.
    	fs.close();
    	
    	search(args, G);
    	StdOut.println("\nSmallest index of each vertex:");
    	smallestVertex(G);
    }
    
    public static void search(String[] args, Digraph G){
    	
    	//Read our search file.
    	In fs = new In(args[1]);
    	
    	ArrayList<Integer> searchVertices = new ArrayList<Integer>();
    	
    	//Get each vertex in the file and add to our searchList.
    	while (fs.hasNextLine())
    	{
    		searchVertices.add(fs.readInt());
    	}	
    	
    	//Close the stream to allow other stuff to use the file since we are done with it.
    	fs.close();
    	
    	DirectedDFS search;
    	
    	StdOut.println("Search with recursive function:\n");
    	
    	for(int vertex : searchVertices)
    	{
    		StdOut.println("Reachable vertices from: " + vertex);
    		
    		//Create a new search and search for the vertex.
        	search = new DirectedDFSRecursive(G, vertex);
        	
    		//Check if each vertex in the graph was reachable from the one we searched for.
        	for (int v = 0; v < G.numOfVertices(); v++)
        	{
        		if (search.marked(v))
        			StdOut.print(v + " ");
        	}
        	
            StdOut.println();	
    	}
    	
    	StdOut.println("\nSearch with non-recursive function:\n");
    	
    	for(int vertex : searchVertices)
    	{
    		StdOut.println("Reachable vertices from: " + vertex);
    		
    		//Create a new search and search for the vertex.
        	search = new DirectedDFSStack(G, vertex);
        	
    		//Check if each vertex in the graph was reachable from the one we searched for.
        	for (int v = 0; v < G.numOfVertices(); v++)
        	{
        		if (search.marked(v))
        			StdOut.print(v + " ");
        	}
        	
            StdOut.println();
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
