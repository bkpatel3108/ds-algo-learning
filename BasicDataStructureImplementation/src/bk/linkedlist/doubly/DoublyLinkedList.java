package bk.linkedlist.doubly;

public class DoublyLinkedList<T> {

	private Node<T> header;
	private Node<T> trailer;
	private Integer size = 0;

	public DoublyLinkedList() {
		header = new Node<>(null, null, trailer);
		trailer = new Node<>(null, header, null);
	}

	private class Node<T> {
		private T element;
		private Node<T> prev;
		private Node<T> next;

		public Node(T element, Node<T> prev, Node<T> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}

	}

	public Integer size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	private void addBetween(T element, Node<T> predecessor, Node<T> successor) {
		Node<T> node = new Node<T>(element, predecessor, successor);
		predecessor.setNext(node);
		successor.setPrev(node);
		size++;
	}

	private void remove(Node<T> node) {
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		size--;
	}

	public void addFirst(T element) {
		addBetween(element, header, header.getNext());
	}

	public void addLast(T element) {
		addBetween(element, trailer.getPrev(), trailer);
	}

	public T removeFirst() {
		if (size > 0) {
			Node<T> firstNode = header.getNext();
			remove(firstNode);
			return firstNode.getElement();
		}
		return null;
	}

	public T removeLast() {
		if (size > 0) {
			Node<T> lastNode = trailer.getPrev();
			remove(lastNode);
			return lastNode.getElement();
		}
		return null;
	}
	
	public T first() {
		if (size > 0) {
			Node<T> firstNode = header.getNext();
			return firstNode.getElement();
		}
		return null;
	}

	public T last() {
		if (size > 0) {
			Node<T> lastNode = trailer.getPrev();
			return lastNode.getElement();
		}
		return null;
	}
	

}
