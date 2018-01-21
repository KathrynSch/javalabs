package lab2.ex1;

import java.util.Set;

public interface Graph<V> {

	//add edge to graph if not already existing
	boolean addEdge (V fromVertex , V toVertex);
	//add node vertex to graph
	boolean addVertex(V vertex);
	Set<V> getChildren(V vertex);
	
	//Set<V> addVertices(Set<V> vertices);

}
