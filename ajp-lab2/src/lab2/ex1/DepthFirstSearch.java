package lab2.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {
	
	private List visitedVertices;
	
	public DepthFirstSearch() {
		this.visitedVertices = new ArrayList<>();
	}

	public <V>List<V> execute(Graph<V> graph, V vertex){
		
		//mark vertex as visited
		System.out.println("Visiting vertex: "+vertex);
		visitedVertices.add(vertex);

		//explore children of vertex 
		Set<V> children = graph.getChildren(vertex);
		Iterator<V> itChildren = children.iterator();
		while(itChildren.hasNext()) {
			V child = (V) itChildren.next();
			//if child not in list of visited vertices
			if(!visitedVertices.contains(child)) {
				//explore child
				this.execute(graph, child);
			}
		}
		
		return visitedVertices;
	}

}
