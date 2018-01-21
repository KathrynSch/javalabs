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
	
	protected String edgeString(V fromVertex, V toVertex) {
		String edgeString = fromVertex+" "+ this.getDotType()+" "+toVertex+"\n";
		return edgeString;
	}
	
	@Override
	public String toString() {	
		
		String graphString= "Graph: \n";
		Set<V> vertices = this.adjacencyList.keySet();
		
		Iterator<V> it = vertices.iterator();
		while(it.hasNext()) {
			V parent = (V) it.next();
			Set<V> children= this.getUniqueChildren(parent);
			graphString += parent +" : "+ children.hashCode()+"\n";
		}
		it = vertices.iterator();
		while(it.hasNext()) {
			V parent = (V) it.next();
			Set<V> children= this.getUniqueChildren(parent);
			
			Iterator<V> itChildren = children.iterator();
			
			while(itChildren.hasNext()) {
				V child =  (V) itChildren.next();
				graphString += edgeString(parent,child);
			}
		}
		return graphString;
	}
	
	public Set<V> addVertices(Set<? extends Word> vertices){

		Set<V> rejectedVertices = new HashSet<>();
		Iterator<? extends Word> it = vertices.iterator();
		//go through vertices to add	
		while(it.hasNext()) {
			V vertex = (V) it.next();
			boolean isExisting = false;
			//check if vertex already in graph
			Set<V> existingVertices = this.adjacencyList.keySet();
			Iterator<V> existingIt = existingVertices.iterator();
			// go through existing vertices
			while(existingIt.hasNext()) {
				V existingVertex = existingIt.next();
				if(existingVertex.equals(vertex)) {
					isExisting = true;
				}
			}
			if(isExisting) {
				// if already exists: do not add to graph, add to rejectedVertices
				rejectedVertices.add(vertex);
			}
			else {	//if not, add to graph
				this.addVertex(vertex);
			}
						
		}
		return rejectedVertices;
	}
}
