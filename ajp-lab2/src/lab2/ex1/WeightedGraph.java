package lab2.ex1;

import java.util.HashMap;
import java.util.Set;

public interface WeightedGraph<V, E> extends Graph<V> {

	public boolean addEdge(V fromVertex, V toVertex, E edge);

}
