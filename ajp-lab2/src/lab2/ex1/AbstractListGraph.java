package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class AbstractListGraph<V> implements Graph<V>{

	protected HashMap<V, Set<V>> adjacencyList;

	public AbstractListGraph(){
		this.adjacencyList = new HashMap<>();
	}
	
	public abstract boolean addEdge(V fromVertex, V toVertex);

	
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
	
	public Set<V> getUniqueChildren(V vertex) {
		return this.getUniqueAdjacencies().get(vertex); 
	}
	
	protected abstract String getDotType() ;
	
	public HashMap<V, Set<V>> getUniqueAdjacencies(){
		
		return adjacencyList;
	}
	
	@Override
	public String toString() {	
		
		String graphString= "Graph: \n";
		Set<V> vertices = this.getUniqueAdjacencies().keySet();
		
		Iterator<V> it = vertices.iterator();
		while(it.hasNext()) {
			V parent = (V) it.next();
			Set<V> children= this.getUniqueChildren(parent);
			graphString += parent +" : "+ children.hashCode()+"\t"+ this.getDotType();
			Iterator<V> itChildren = children.iterator();
			while(itChildren.hasNext()) {
				graphString += " "+ (V) itChildren.next();
			}
			graphString += "\n";
		}
		return graphString;
	}
	
	public Set<Word> addVertices(Set<? extends Word> vertices){
		boolean isVertexAdded = false;
		Iterator<Word> it = (Iterator<Word>) vertices.iterator();
		Set<Word> rejectedVertices = null;
		
		while(it.hasNext()) {
			Word vertex = (Word) it.next();
			isVertexAdded = addVertex((V) vertex);			//returns true if vertex successfully added
			
			//If Vertex not added because already in graph
			if(isVertexAdded == false) {
				//add to Set of vertices not added to the graph
				rejectedVertices.add(vertex);
			}
		}
		
		return rejectedVertices;
	}
}
