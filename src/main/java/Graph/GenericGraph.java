package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericGraph<T> {
	private Map map = new HashMap<T, List<T>>();

	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}

	public void addEdge(T source, T destination) {
		if (!map.containsKey(source)) {
			addVertex(source);
		}
		if (!map.containsKey(destination)) {
			addVertex(destination);
		}
		((List<T>) map.get(source)).add(destination);
		((List<T>) map.get(destination)).add(source);
	}

	public List<T> getVertexList() {
		Set<T> nodes = map.keySet();
		if (nodes != null || !nodes.isEmpty()) {
			return new ArrayList<>(nodes);
		} else {
			return new ArrayList<>();
		}
	}

	public List<T> getEdgesList(T s) {

		if (map.containsKey(s)) {
			return (List<T>) map.get(s);
		} else {
			return new ArrayList<>();
		}
	}

}
