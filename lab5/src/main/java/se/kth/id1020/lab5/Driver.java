package se.kth.id1020.lab5;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Driver 
{
    public static void main(String[] args)
    {
    	//Read the file from the arguments.
    	In fs = new In(args[0]);
    	
    	Digraph G = new Digraph(fs.readInt());
    	
    	int edges = fs.readInt();
    	
    	for(int i = 0; i < edges; i++)
    		G.addEdge(fs.readInt(), fs.readInt());
    	
//    	DirectedDFS reachable = new DirectedDFS(G, sources);
//    	
//    	for (int v = 0; v < G.V(); v++)
//    		if (reachable.marked(v)) StdOut.print(v + " ");
//    	
//    	StdOut.println();
    }
}
