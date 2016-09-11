public interface Graph<V, E> {

	public Vertex<V> insertVertex(V element);

	public Edge<E> insertEdge(E element, Vertex<V> u, Vertex<V> v);

	public Integer noOfVertices();

	public Integer noOfEdges();

	public Iterable<Vertex<V>> vertices();

	public Iterable<Edge<E>> edges();

	public void removeVertex(Vertex<V> vertex);

	public void removeEdge(Edge<E> edge);

	public Integer inDegree(Vertex<V> vertex);

	public Integer outDegree(Vertex<V> vertex);

	public Iterable<Edge> outgoingEdges(Vertex<V> vertex);

	public Iterable<Edge> incomingEdges(Vertex<V> vertex);

	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v);

	public Vertex<V>[] endVertices(Edge<E> edge);

	public Vertex<V> opposite(Edge<E> edge, Vertex<V> vertex);

}
