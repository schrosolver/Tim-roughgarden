package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS<T> {
	public boolean search(GenericGraph<T> graph,T source, T find){
		List<T> vertices= graph.getVertexList();
		if(!vertices.isEmpty()||vertices!=null){
			Map<T,Boolean> isExplored = new HashMap<>();
			for(T s :vertices ){
				isExplored.put(s, false);				
			}
			Queue<T> queue = new LinkedList();
			queue.add(source);
			isExplored.put(source, true);
			while(!queue.isEmpty()){
				T node = queue.remove();
				for(T s : graph.getEdgesList(node)){
					if(s==find){
						return true;
					}
					else if(!isExplored.get(s)){
						isExplored.put(s, true);
						queue.add(s);
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		GenericGraph<String> graph = new GenericGraph<>();
		graph.addEdge("s", "a");
		graph.addEdge("s", "b");
		graph.addEdge("a", "c");
		graph.addEdge("c", "d");
		graph.addEdge("d", "e");
		graph.addEdge("b", "c");
		graph.addEdge("c", "e");
	
		BFS<String> bfs = new BFS<>();
		boolean isValid=bfs.search(graph, "s", "b");
		boolean isInvalid=bfs.search(graph, "s", "l");
		System.out.println("is Valid :"+ isValid);
		System.out.println("is inValid : "+isInvalid);	
	}

}
