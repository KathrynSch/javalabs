package lab2.ex1;

import java.util.HashSet;
import java.util.Set;

public class UndirectedListGraph<V> extends AbstractListGraph<V> {

	// constructor
		public UndirectedListGraph(){
			super();
		}
		
	
	public boolean addEdge(V fromVertex, V toVertex) {
		//check if both vertexes already exist
		if(!this.adjacencyList.containsKey(fromVertex) || !this.adjacencyList.containsKey(toVertex)) {
			System.out.println("Vertex missing. Unable to add edge");
			return false;
		}
		else {
			this.adjacencyList.get(fromVertex).add(toVertex);
			this.adjacencyList.get(toVertex).add(fromVertex);
			System.out.println("Edge successfully added");
			return true;
		}
	}
	
	protected String getDotType() {
		return "--";
	}

}
