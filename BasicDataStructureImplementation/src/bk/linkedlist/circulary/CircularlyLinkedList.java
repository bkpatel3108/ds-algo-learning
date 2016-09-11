package bk.linkedlist.circulary;

//rotate method needs to be implemented

public class CircularlyLinkedList<T> {

	private Node<T> tail;
	private Integer size = 0;

	private class Node<T> {
		private T element;
		private Node<T> next;

		public Node(T element, Node<T> next) {
			this.element = element;
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
	}

	public Integer size() {
		return size;
	}

	public boolean isEmpty() {
		if (size <= 0)
			return true;
		else
			return false;
	}

	public void addFirst(T element) {
		Node<T> node = new Node<T>(element, null);
		if (tail != null) {
			node.setNext(tail.getNext());
		} else {
			tail = node;
		}
		tail.setNext(node);
		size++;
	}

	public void addLast(T element) {
		if (tail != null) {
			Node<T> node = new Node<T>(element, tail.getNext());
			tail.setNext(node);
			tail = node;
		} else {
			Node<T> node = new Node<T>(element, null);
			tail = node;
			tail.setNext(node);
		}
		size++;
	}

	public T first() {
		if (size > 1) {
			return tail.getNext().getElement();
		} else if (size == 1) {
			return tail.getElement();
		} else
			return null;
	}

	public T last() {
		if (size > 0) {
			return tail.getElement();
		} else
			return null;
	}

	public T removeFirst() {
		if (size > 0) {
			Node<T> node = tail.getNext();
			tail.setNext(node.getNext());
			size--;
			return node.getElement();
		} else
			return null;
	}

	public void rotate() {
		if (tail != null) {
			tail = tail.getNext();
		}
	}
}
