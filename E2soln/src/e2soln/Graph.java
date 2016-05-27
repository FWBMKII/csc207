package e2soln;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

//Class for a graph
public class Graph<T> {
	
	private Map<T, Set<T>> graph;
	
	/*
	 * connect two edges with a edge
	 * if one of node does not exist, then add it into the map then connect them.
	 * Request: At least one of two nodes are in the graph.
	 */
	public Graph() {
		this.graph = new HashMap<T, Set<T>>();
	}
	
	public void addEdge(T N1, T N2) {
		if (graph.containsKey(N1)){
			if (! graph.containsKey(N2)) {
				graph.put(N2, new HashSet<T>());
			}
		}
		else if (graph.containsKey(N2)) {
			graph.put(N1, new HashSet<T>());
		}
		else {
			graph.put(N1, new HashSet<T>());
			graph.put(N2, new HashSet<T>());
		}
		if (! graph.get(N2).contains(N1)) {
		    graph.get(N2).add(N1);
		}
		if (! graph.get(N1).contains(N2)) {
		    graph.get(N1).add(N2);
		}
	}
	
	/**
	 * 
	 * @param N1 Node 1
	 * @param N2 Node 2
	 * @return true if there is a edge between two Nodes, else return false
	 * @throws EdgeException at least one of Node does not exist in the Graph
	 */
	public boolean areAdjacent(T N1, T N2) throws EdgeException {
		if (! (graph.containsKey(N1) && graph.containsKey(N2))) {
			throw new EdgeException("yoooo~");
		}
		else {
			if (graph.get(N1).contains(N2) && graph.get(N2).contains(N1)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * 
	 * @return a set of all Nodes in the Graph
	 */
	public Set<T> getNodes() {
		return graph.keySet();
	}
	
	/**
	 * 
	 * @param N1 given Node
	 * @return a set of Nodes connected to N1
	 */
	public Set<T> getNeighbours(T N1) {
		return graph.get(N1);
	}
	
    /**
     * Returns the number of nodes in this Graph.
     * @return The number of nodes in this Graph.
     */
    public int getNumNodes() {
        return getNodes().size();   
    }
    
    /**
     * Returns the number of edges in this undirected Graph.
     * @return The number of edges in this undirected Graph. 
     */
    public int getNumEdges() {  
        int total = 0;
    
        for (T node : getNodes()) {
            total += getNeighbours(node).size();
        }
    
        return total / 2;
    }
  
    @Override
    public String toString() {       
        String result = "";
        result += "Number of nodes: " + getNumNodes() + "\n";
        result += "Number of edges: " + getNumEdges() + "\n";
        
        for (T node: getNodes()) {
            result += node + " is adjacent to: ";
            for  (T neighbour: getNeighbours(node)) {
                result += neighbour + " ";
            }
            result += "\n";
        }
        return result;
    }
	
    public static void main(String[] args) throws EdgeException{
    	Graph<String> a = new Graph<String>();
    	String N1 = "1";
    	String N2 = "2";
    	String N3 = "3";
    	a.addEdge(N1, N2);
    	print(a.toString());
    	a.addEdge(N1, N3);
    	print(a.toString());
    	print(a.areAdjacent(N1, N3));
    	print(a.areAdjacent(N2, N3));
    }

	public static void print(Object obj){
    	System.out.println(obj);
    }
}
