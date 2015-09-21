//Aemen Husain 

/* 
 * 
 * Coding problem 2:  Write the isConnected
 * method of the DiGraph class.  
 * 
 * The method should return true if there is
 * a path from v to w for every pair of 
 * vertices (v and w) in the graph.
 * 
 * The implementation is of a directed, weighted graph
 * 
 * When you are done, the correct output
 * should be
 * 
 * Connected? false
 * Connected? true
 */

package exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import stdlib.In;

public class DiGraph {
	// the number of vertices in the graph
    private final int V;
    // the number of edges
    private int E;
    private final List<Integer>[] adj;

    /**
     * Create an empty graph with V vertices.
     */
    public DiGraph(int V) {
    	if (V < 0) throw new Error("Number of vertices must be nonnegative");
    	this.V = V;
    	this.E = 0;
    	// each vertex has a Bag of adjacent vertices
    	// this is the representation of edges in the graph
    	this.adj = new ArrayList[V];
    	for (int v = 0; v < V; v++) {
    		adj[v] = new ArrayList<>();
    	}
    }

    /**
     * Create a digraph from input stream.
     */
    public DiGraph(In in) {
    	this(in.readInt());
    	final int E = in.readInt();
    	for (int i = 0; i < E; i++) {
    		final int v = in.readInt();
    		final int w = in.readInt();
    		addEdge(v, w);
    	}
    }

    /**
     * Return the number of vertices in the graph.
     */
    public int V() { return V; }

    /**
     * Return the number of edges in the graph.
     */
    public int E() { return E; }


    /**
     * Add the directed edge (v,w) to graph.
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E++;
        adj[v].add(w);
    }

    /**
     * Return the list of neighbors of vertex v as an Iterable.
     */
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }

    /**
     * Return a string representation of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public boolean isConnected() {

    	//iterate through collection of edges in adj, verify they are connected and compare it to the total count of edges
    	int count=0;
    	for (int v=0; v<V; v++){
    		for (int e: adj[v]){
    			Set<Integer> visited = new HashSet<Integer>();
    			if (path(e, v, visited))
    				count++;
          }}
    	if (count == E){
    		return true;
    	}
       return false;
   
    }

    // returns true is there is a path from v to w
    public boolean path(int v, int w, Set visited) {
        if (v == w) return true;
        if (!visited.contains(v)) {
            visited.add(v);
            for (int x : adj[v])
                if (path(x,w,visited))
                    return true;
        }
        return false;
    }

    /**
     * Test client.
     */
    public static void main(String[] args) {
    	DiGraph G;
    	In in = new In("data/tinyG.txt");
    	G = new DiGraph(in);
    	System.out.println("Connected? " + G.isConnected());
    	G.addEdge(4,0);
    	System.out.println("Connected? " + G.isConnected());
    }
}
