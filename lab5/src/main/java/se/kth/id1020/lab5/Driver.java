package se.kth.id1020.lab5;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Driver 
{
    public static void main(String[] args)
    {
    	//Read the file from the arguments.
    	In fs = new In(args[0]);
    	
    	//Create a graph with the number of vertecies.
    	Digraph G = new Digraph(fs.readInt());
    	
    	//The amount of edges we should add.
    	int edges = fs.readInt();
    	
    	//Read the edges from the file and add then to the graph.
    	for(int i = 0; i < edges; i++)
    		G.addEdge(fs.readInt(), fs.readInt());

    	//searchRecursive(args, G);
    	
    	searchNonRecursive(args, G);
    }
    
    public static void searchRecursive(String[] args, Digraph G){
    	
    	//Read our search file.
    	In fs = new In(args[1]);
    	
    	while (fs.hasNextLine())
    	{
    		int vertex = fs.readInt();
    		
    		StdOut.println("Searching for: " + vertex);
    		
    		//Create a new search.
        	DirectedDFS reachable = new DirectedDFS(G, vertex);
        	
        	for (int v = 0; v < G.numOfVertices(); v++)
        		if (reachable.marked(v)) StdOut.print(v + " ");
        	
        	StdOut.println();
    	}
    	
    }
    
    public static void searchNonRecursive(String[] args, Digraph G){
    	//Read our search file.
    	In fs = new In(args[1]);
    	
    	while (fs.hasNextLine())
    	{
    		int vertex = fs.readInt();
    		
    		StdOut.println("Searching for: " + vertex);
    		
    		//Create a new search.
    		DirectedDFSStack reachable = new DirectedDFSStack(G, vertex);
        	
    		for (int v = 0; v < G.numOfVertices(); v++) {
    			if (reachable.hasPathTo(v)) {
    				StdOut.printf("%d to %d:  ", vertex, v);
    				for (int x : reachable.pathTo(v)) {
    					if (x == vertex) StdOut.print(x);
    					else        StdOut.print("-" + x);
    				}
    				StdOut.println();
    			}
    
    			else {
    				StdOut.printf("%d to %d:  not connected\n", vertex, v);
    			}
    		}
    	}
    }
}
