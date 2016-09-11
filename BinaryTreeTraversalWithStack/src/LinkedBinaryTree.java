public class LinkedBinaryTree<T> implements BinaryTree<T> {

	private int size = 0;
	private Node<T> root = null;

	public Node<T> createNode(T element, Node<T> parent, Node<T> left, Node<T> right) {
		return new Node<T>(element, parent, left, right);
	}

	public boolean isInternal(Position<T> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<T> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<T> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int numChildren(Position<T> p) {
		int count = 0;
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;
		return count;
	}

	/*
	 * Returns an iterable collection of the Positions representing p's
	 * children.
	 */
	// public Iterable<Position<T>> children(Position<T> p) {
	// List<Position<T>> snapshot = new ArrayList<>(2);
	// if (left(p) != null)
	// snapshot.add(left(p));
	// if (right(p) != null)
	// snapshot.add(right(p));
	// return snapshot;
	// }

	protected Node<T> validate(Position<T> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<T> node = (Node<T>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Position<T> root() {
		return root;
	}

	@Override
	public Position<T> parent(Position<T> p) throws IllegalArgumentException {
		Node<T> node = (Node<T>) p;
		return node.getParent();
	}

	@Override
	public Position<T> left(Position<T> p) throws IllegalArgumentException {
		Node<T> node = (Node<T>) p;
		return node.getLeft();
	}

	@Override
	public Position<T> right(Position<T> p) throws IllegalArgumentException {
		Node<T> node = (Node<T>) p;
		return node.getRight();
	}

	@Override
	public Position<T> sibling(Position<T> p) throws IllegalArgumentException {
		Node<T> node = (Node<T>) p;
		if (!isRoot(node)) {
			Node<T> parentNode = node.getParent();
			if (parentNode.getLeft().equals(node)) {
				parentNode.getRight();
			} else
				parentNode.getLeft();
		}
		return null;
	}

	@Override
	public Position<T> addRoot(T e) throws IllegalStateException {
		size = 1;
		root = new Node<T>(e, null, null, null);
		return root;
	}

	/*
	 * Creates a new left child of Position p storing element e; returns its
	 * Position.
	 */
	@Override
	public Position<T> addLeft(Position<T> p, T e) {
		Node<T> parentNode = validate(p);
		Node<T> childNode = null;
		if (parentNode.getLeft() == null) {
			childNode = new Node<T>(e, parentNode, null, null);
			parentNode.setLeft(childNode);
			size++;
		} else
			throw new IllegalArgumentException("Left node already exist for given node");
		return childNode;
	}

	@Override
	public Position<T> addRight(Position<T> p, T e) {
		Node<T> parentNode = validate(p);
		Node<T> childNode = null;
		if (parentNode.getRight() == null) {
			childNode = new Node<T>(e, parentNode, null, null);
			parentNode.setRight(childNode);
			size++;
		} else
			new IllegalArgumentException("Right node already exist for given node");
		return childNode;
	}

	/*Replaces the element at Position p with e and returns the replaced element*/
	@Override
	public T set(Position<T> p, T e) throws IllegalArgumentException {
		Node<T> node = validate(p);
		T replacedElement = node.getElement();
		node.setElement(e);
		return replacedElement;
	}

	@Override
	public T remove(Position<T> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
