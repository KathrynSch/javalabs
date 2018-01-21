package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

abstract class AbstractWeightedListGraph<V, E> extends AbstractListGraph<V> implements WeightedGraph<V, E> {

	private final HashMap<Tuple, E> adjacencyList;

	public AbstractWeightedListGraph(){
		this.adjacencyList = new HashMap<>();
	}
	
	//inner class 
	private class Tuple{
		
		public V fromVertex, toVertex;

		Tuple(V fromVertex, V toVertex){
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
		}
	}
	
	
	public boolean addEdge(V fromVertex, V toVertex, E edge) {
		//check if both vertexes already exist

//		if(!this.adjacencyList.containsKey(Tuple.fromVertex) || !this.adjacencyList.containsKey(Tuple.this.toVertex)) {
//			System.out.println("Vertex missing. Unable to add edge");
//			return false;
//		}
//		else {
//			Tuple theTuple = new Tuple(fromVertex, toVertex);
//			this.adjacencyList.put(theTuple, edge);
//			System.out.println("Edge successfully added");
//			
//			return true;
//		}
	}
	
}
