package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DirectedListGraph<V> extends AbstractListGraph<V>{
	
	// constructor
	public DirectedListGraph(){
		super();
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

	
	protected String getDotType() {
		return "->";
	}
	

	
	
	public static void main(String[] args) {
		
		UndirectedListGraph<String> graph = new UndirectedListGraph<>();
		String a = "A", b="B", c="C", d="D", e="E", f="F";
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		
		//Set<Word> vertices = null;
		//graph.addVertices(vertices);
		
		graph.addEdge(a, b);
		graph.addEdge(b, c);
		graph.addEdge(c, d);
		graph.addEdge(c, a);
		graph.addEdge(d, b);
		graph.addEdge(b, e);
		graph.addEdge(c, f);
		
		System.out.println(graph.toString());
		
//		DepthFirstSearch dfs = new DepthFirstSearch();
//		dfs.execute(graph, a);
//		Word toto = new Word();
//		System.out.println(toto.toString());
	}
	
	
}
