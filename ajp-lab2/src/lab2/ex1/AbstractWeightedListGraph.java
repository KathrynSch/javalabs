package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class AbstractWeightedListGraph<V, E> extends AbstractListGraph<V> implements WeightedGraph<V, E> {

	private Map<Tuple, E> edges;

	public AbstractWeightedListGraph(){
		super();
		this.edges = new HashMap<>();
	}
	
	//inner class 
	private class Tuple{
		
		private V fromVertex, toVertex;

		Tuple(V fromVertex, V toVertex){
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
		}
	}
	
	
	public boolean addEdge(V fromVertex, V toVertex, E edge) {
		//check if both vertexes already exist
		if(!this.adjacencyList.containsKey(fromVertex) || !this.adjacencyList.containsKey(toVertex)) {
			System.out.println("Vertex missing. Unable to add edge");
			return false;
		}
		else {
			//link tovertex to fromvertex
			this.adjacencyList.get(fromVertex).add(toVertex);
			//add edge weight to edges map
			Tuple theTuple = new Tuple(fromVertex, toVertex);
			edges.put(theTuple, edge);
			System.out.println("Edge successfully added");
			return true;
		}
	}
	
	@Override
	protected String edgeString(V fromVertex, V toVertex) {
		Tuple tuple = new Tuple(fromVertex, toVertex);
		E weight = this.edges.get(tuple);
		String edgeString = fromVertex+" "+ this.getDotType()+" "+toVertex+" ("+weight+") "+"\n";
		return edgeString;
	}
	
}
