package lab2.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
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
	
	@Override
	public HashMap<V, Set<V>> getUniqueAdjacencies(){
		//go through all vertices
		Set<V> vertices = this.adjacencyList.keySet();
		Iterator<V> it = vertices.iterator();
		while(it.hasNext()) {
			V theParent = (V) it.next();
			Set<V> children= this.getChildren(theParent);
			Iterator<V> itChildren = children.iterator();
			while(itChildren.hasNext()) {
				V theChild = (V)itChildren.next();
				//check if reverse exists
				Set<V> childrenList = adjacencyList.get(theChild);
				if(childrenList.contains(theParent)) {
					//Remove vertex from adjacency list
					adjacencyList.get(theChild).remove(theParent);
				}
			}
		}
		return adjacencyList;
	}
}
