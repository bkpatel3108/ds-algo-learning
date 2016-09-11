//Node class
public class Node<T> implements Position<T> {
		private T element;
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;

		public Node(T element, Node<T> parent, Node<T> left, Node<T> right) {
			super();
			this.element = element;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		public T getElement() throws IllegalStateException {
			return element;
		}

		public Node<T> getParent() {
			return parent;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public void setElement(T element) {
			this.element = element;
		}

	}
