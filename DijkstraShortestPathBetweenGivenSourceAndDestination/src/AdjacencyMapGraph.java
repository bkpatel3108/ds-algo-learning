import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

	private List<Vertex<V>> vertices;
	private List<Edge<E>> edges;
	// default undirected
	private boolean isDirected = false;

	AdjacencyMapGraph() {
		vertices = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
	}

	AdjacencyMapGraph(boolean isDirected) {
		vertices = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
		this.isDirected = isDirected;
	}

	@Override
	public Vertex<V> insertVertex(V element) {
		// TODO Auto-generated method stub
		Vertex<V> vertex = new Vertex<V>(element, isDirected);
		vertices.add(vertex);
		return vertex;
	}

	@Override
	public Edge<E> insertEdge(E element, Vertex<V> u, Vertex<V> v) {
		// TODO Auto-generated method stub
		if (getEdge(u, v) == null) {
			Edge<E> edge = new Edge<E>(element, u, v);
			Map<Vertex<V>, Edge> outEdges = u.getOutgoingEdges();
			Map<Vertex<V>, Edge> inEdges = v.getIncomingEdges();
			outEdges.put(v, edge);
			inEdges.put(u, edge);
			edges.add(edge);
			return edge;
		}
		return null;
	}

	@Override
	public Integer noOfVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public Integer noOfEdges() {
		// TODO Auto-generated method stub
		return edges.size();
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return this.vertices;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return this.edges;
	}

	@Override
	public void removeVertex(Vertex<V> vertex) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeEdge(Edge<E> edge) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer inDegree(Vertex<V> vertex) {
		// TODO Auto-generated method stub
		return vertex.getIncomingEdges().size();
	}

	@Override
	public Integer outDegree(Vertex<V> vertex) {
		// TODO Auto-generated method stub
		return vertex.getOutgoingEdges().size();
	}

	@Override
	public Iterable<Edge> outgoingEdges(Vertex<V> vertex) {
		// TODO Auto-generated method stub
		return vertex.getOutgoingEdges().values();
	}

	@Override
	public Iterable<Edge> incomingEdges(Vertex<V> vertex) {
		// TODO Auto-generated method stub
		return vertex.getIncomingEdges().values();
	}

	@Override
	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
		// TODO Auto-generated method stub
		return (Edge<E>) u.getOutgoingEdges().get(v);
	}

	@Override
	public Vertex<V>[] endVertices(Edge<E> edge) {
		// TODO Auto-generated method stub
		return edge.getEndVertices();
	}

	@Override
	public Vertex<V> opposite(Edge<E> edge, Vertex<V> vertex) {
		// TODO Auto-generated method stub
		Vertex<V>[] endVertices = edge.getEndVertices();
		if (vertex == endVertices[0])
			return endVertices[1];
		else if (vertex == endVertices[1])
			return endVertices[0];
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Vertex<V> v : vertices) {
			sb.append("Vertex " + v.getElement() + " has");
			if (isDirected)
				sb.append(" [outgoing]");
			sb.append(" " + outDegree(v) + " adjacent vertices:");
			for (Edge<E> e : outgoingEdges(v))
				sb.append(String.format(" (%s, %s)", opposite(e, v).getElement(), e.getElement()));
			sb.append("\n");
			if (isDirected) {
				sb.append(" [incoming]");
				sb.append(" " + inDegree(v) + " adjacent vertices:");
				for (Edge<E> e : incomingEdges(v))
					sb.append(String.format(" (%s, %s)", opposite(e, v).getElement(), e.getElement()));
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
