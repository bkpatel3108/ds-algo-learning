import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
	T element;
	Map<Vertex<T>, Edge> incomingEdges;
	Map<Vertex<T>, Edge> outgoingEdges;
	
	Vertex(T element, boolean graphIsDirected)
	{
		this.element = element;
		incomingEdges = new HashMap<Vertex<T>, Edge>();
		if(graphIsDirected)
			outgoingEdges = new HashMap<Vertex<T>, Edge>();
		else
			outgoingEdges = incomingEdges;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public Map<Vertex<T>, Edge> getIncomingEdges() {
		return incomingEdges;
	}

	public void setIncomingEdges(Map<Vertex<T>, Edge> incomingEdges) {
		this.incomingEdges = incomingEdges;
	}

	public Map<Vertex<T>, Edge> getOutgoingEdges() {
		return outgoingEdges;
	}

	public void setOutgoingEdges(Map<Vertex<T>, Edge> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
	
}
