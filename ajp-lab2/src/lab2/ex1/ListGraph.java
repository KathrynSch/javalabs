package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListGraph<V> implements Graph<V> {
	
	private HashMap<V, Set<V>> adjacencyList;

	// constructor
	public ListGraph(){
		this.adjacencyList = new HashMap<>();
	}
	
	//add edge to graph
	public boolean addEdge(V fromVertex, V toVertex) {
		//check if both vertexes already exist
		if(!this.adjacencyList.containsKey(fromVertex) || !this.adjacencyList.containsKey(toVertex)) {
			System.out.println("Vertex missing. Unable to add edge");
			return false;
		}
		else {
			this.adjacencyList.get(fromVertex).add(toVertex);
			System.out.println("Edge successfully added");
			return true;
		}
	}

	// add vertex to graph 
	public boolean addVertex(V vertex) {
		// check if vertex not already in graph
		if(this.adjacencyList.containsKey(vertex)) {
			System.out.println("Vertex already in graph");
			return false;
		}
		else {
			this.adjacencyList.put(vertex, new HashSet<V>());
			System.out.println("Vertex added to graph");
			return true;
		}
	}

	
	public Set<V> getChildren(V vertex) {
		return this.adjacencyList.get(vertex); 
	}

	@Override
	public String toString() {	
		
		String graphString= "Graph: \n";
		Set<V> vertices = this.adjacencyList.keySet();
		
		Iterator<V> it = vertices.iterator();
		while(it.hasNext()) {
			V parent = (V) it.next();
			Set<V> children= this.getChildren(parent);
			graphString += parent +" : "+ children.hashCode()+" -> ";
			Iterator<V> itChildren = children.iterator();
			while(itChildren.hasNext()) {
				graphString += " "+ (V) itChildren.next();
			}
			graphString += "\n";
		}
		return graphString;
	}
	
	public static void main(String[] args) {
		
		ListGraph<String> graph = new ListGraph<>();
		String a = "A", b="B", c="C", d="D", e="E", f="F";
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		
		graph.addEdge(a, b);
		graph.addEdge(b, c);
		graph.addEdge(c, d);
		graph.addEdge(c, a);
		graph.addEdge(d, b);
		graph.addEdge(b, e);
		graph.addEdge(c, f);
		
		System.out.println(graph.toString());
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.execute(graph, a);
		
	}
	
	
}
