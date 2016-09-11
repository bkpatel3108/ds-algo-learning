package hackerrank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearchShortestReach {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		// create graph from input
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		// repeat the process q times
		for (int cnt = 0; cnt < q; cnt++) {
			int n = in.nextInt();
			int m = in.nextInt();
			// graph
			Graph<Integer, Integer> g = new AdjacencyMapGraph<Integer, Integer>(false);
			Map<Integer, Vertex<Integer>> inputVertices = new HashMap<Integer, Vertex<Integer>>();

			// enter vertices to graph
			for (int i = 1; i <= n; i++) {
				Vertex<Integer> v = g.insertVertex(i);
				inputVertices.put(i, v);
			}

			// enter edges to graph
			for (int i = 0; i < m; i++) {
				Integer uEle = in.nextInt();
				Integer vEle = in.nextInt();
				g.insertEdge(6, inputVertices.get(uEle), inputVertices.get(vEle));
			}

			// source node
			Integer sEle = in.nextInt();
			Vertex<Integer> s = inputVertices.get(sEle);

			// perform BFS
			Set<Vertex<Integer>> visitedNodes = new HashSet<Vertex<Integer>>();
			Queue<Vertex<Integer>> nextNodesQueue = new LinkedList<Vertex<Integer>>();
			Map<Vertex<Integer>, Integer> pathLengthsMap = new HashMap<Vertex<Integer>, Integer>();
			nextNodesQueue.add(s);
			pathLengthsMap.put(s, 0);
			visitedNodes.add(s);
			while (!nextNodesQueue.isEmpty()) {
				// System.out.println("nextNodesQueue.size()>>"+nextNodesQueue.size());
				Vertex<Integer> u = nextNodesQueue.poll();
				// if(!visitedNodes.contains(u)){
				// System.out.println("Visting Node>>"+u.getElement());
				for (Edge<Integer> e : g.outGoingEdges(u)) {
					Vertex<Integer> v = g.opposite(e, u);
					if (!visitedNodes.contains(v)) {
						// System.out.println("Visting opposite Node and
						// length>>"+v.getElement()+" "+pathLengthsMap.get(u) +
						// 6);
						pathLengthsMap.put(v, pathLengthsMap.get(u) + 6);
						visitedNodes.add(v);
						nextNodesQueue.add(v);
					}
				}
				// }
			}

			for (int i = 1; i <= n; i++) {
				if (i != sEle) {
					Integer len = pathLengthsMap.get(inputVertices.get(i));
					if (len != null) {
						System.out.print(len + " ");
					} else {
						System.out.print("-1" + " ");
					}
				}
			}
			System.out.println("");
		}
	}
}

class Vertex<V> {
	private V element;
	private Map<Vertex<V>, Edge> incomingEdges;
	private Map<Vertex<V>, Edge> outgoingEdges;

	Vertex(V element, boolean isGraphDirected) {
		this.element = element;
		incomingEdges = new HashMap<Vertex<V>, Edge>();
		if (isGraphDirected)
			outgoingEdges = new HashMap<Vertex<V>, Edge>();
		else
			outgoingEdges = incomingEdges;
	}

	public V getElement() {
		return this.element;
	}

	public Map<Vertex<V>, Edge> getIncomingEdges() {
		return this.incomingEdges;
	}

	public Map<Vertex<V>, Edge> getOutcomingEdges() {
		return this.outgoingEdges;
	}
}

class Edge<E> {
	private E element;
	private Vertex[] endVertices;

	Edge(E e, Vertex u, Vertex v) {
		this.element = e;
		endVertices = new Vertex[2];
		endVertices[0] = u;
		endVertices[1] = v;
	}

	public E getElement() {
		return this.element;
	}

	public Vertex[] getEndVertices() {
		return this.endVertices;
	}

}

interface Graph<V, E> {
	public Vertex<V> insertVertex(V element);

	public Edge<E> insertEdge(E element, Vertex<V> u, Vertex<V> v);

	// public int noOfVertices();
	// public int noOfEdges();
	// public Iterable<Vertex<V>> vertices();
	// public Iterable<Edge<E>> edges();
	// public int outDegree(Vertex<V> v);
	// public int inDegree(Vertex<V> v);
	public Iterable<Edge> outGoingEdges(Vertex<V> v);

	public Iterable<Edge> inGoingEdges(Vertex<V> v);

	public Vertex<V> opposite(Edge<E> e, Vertex<V> v);
}

class AdjacencyMapGraph<V, E> implements Graph<V, E> {

	List<Vertex<V>> vertices;
	List<Edge<E>> edges;
	boolean isDirected = false; // default undirected

	AdjacencyMapGraph() {
		vertices = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
	}

	AdjacencyMapGraph(boolean isDirected) {
		vertices = new ArrayList<Vertex<V>>();
		edges = new ArrayList<Edge<E>>();
		this.isDirected = isDirected;
	}

	public Vertex<V> insertVertex(V element) {
		Vertex<V> v = new Vertex<V>(element, isDirected);
		vertices.add(v);
		return v;
	}

	public Edge<E> insertEdge(E element, Vertex<V> u, Vertex<V> v) {
		Edge<E> e = new Edge<E>(element, u, v);
		edges.add(e);
		u.getOutcomingEdges().put(v, e);
		v.getIncomingEdges().put(u, e);
		return e;
	}

	public Iterable<Edge> outGoingEdges(Vertex<V> v) {
		return v.getOutcomingEdges().values();
	}

	public Iterable<Edge> inGoingEdges(Vertex<V> v) {
		return v.getIncomingEdges().values();
	}

	public Vertex<V> opposite(Edge<E> e, Vertex<V> v) {
		Vertex[] endVertices = e.getEndVertices();
		if (v == endVertices[0])
			return endVertices[1];
		else
			return endVertices[0];
	}
}
