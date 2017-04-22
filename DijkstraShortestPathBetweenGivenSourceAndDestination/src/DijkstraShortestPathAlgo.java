import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraShortestPathAlgo {

	public static <V> Object[] getShortestPath(Graph<V, Integer> graph, Vertex<V> srcVertex, Vertex<V> desVertex) {
		
		//outputContainer[0] will contain shortest path length
		//outputContainer[1] will contain shortest path
		Object[] outputContainer = new Object[2];
		
		final Map<Vertex<V>, Integer> pathLengthsMap = new HashMap<Vertex<V>, Integer>();
		Map<Vertex<V>, Edge<Integer>> shortestPathMap = new HashMap<Vertex<V>, Edge<Integer>>();
		List<Vertex<V>> shortestPath = new ArrayList<Vertex<V>>();
		Integer shortestPathLength = 0;

		// priority queue
		Comparator<Vertex> comparator = new Comparator<Vertex>() {

			@Override
			public int compare(Vertex v1, Vertex v2) {
				// TODO Auto-generated method stub
				return pathLengthsMap.get(v1) - pathLengthsMap.get(v2);
			}
		};
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>(20,comparator);

		// Add all vertices to currentPathLengthsMap and priorityQueue
		// Initialize D[s] = 0 and D[v] = ∞ for each vertex v != s.
		for (Vertex<V> vertex : graph.vertices()) {
			if (vertex == srcVertex) {
				pathLengthsMap.put(vertex, 0);
			} else {
				pathLengthsMap.put(vertex, Integer.MAX_VALUE);
			}
			priorityQueue.add(vertex);
		}

		// while Q is not empty do
		while (!priorityQueue.isEmpty()) {
			Vertex<V> u = priorityQueue.poll();
			if (u == desVertex)
				break;
			// for each edge (u,v) such that v is in Q do
			// get outgoing edges of u
			for (Edge<Integer> e : graph.outgoingEdges(u)) {
				// check opposite vertex v is in Q?
				Vertex<V> v = graph.opposite(e, u);
				if (priorityQueue.contains(v)) {
					// {perform the relaxation procedure on edge (u,v)}
					// if D[u] + w(u, v) < D[v] then
					if (pathLengthsMap.get(u) + e.getElement() < pathLengthsMap.get(v)) {
						// D[v] = D[u]+w(u,v)
						pathLengthsMap.put(v, pathLengthsMap.get(u) + e.getElement());
						// Change the key of vertex v in Q to D[v].
						priorityQueue.add(v);
						shortestPathMap.put(v, e);
					}
				}
			}
		}

		// compute shortest path and length
		shortestPathLength = pathLengthsMap.get(desVertex);
		outputContainer[0] =  shortestPathLength;

		// start from desVertex; repeat until reach to srcVertex
		shortestPath.add(desVertex);
		Vertex<V> currentVertex = desVertex;
		while (currentVertex != srcVertex) {
			Edge<Integer> edge = shortestPathMap.get(currentVertex);
			if (edge != null) {
				currentVertex = graph.opposite(edge, currentVertex);
				shortestPath.add(currentVertex);
			} else
				break;
		}
		
		outputContainer[1] =  shortestPath;

		return outputContainer;

	}
}
