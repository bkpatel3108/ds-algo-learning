
public class Edge<T> {
	private T element;
	private Vertex[] endVertices;
	
	Edge(T element, Vertex<?> u, Vertex<?> v)
	{
		endVertices =  new Vertex[]{u,v};
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Vertex[] getEndVertices() {
		return endVertices;
	}
}
