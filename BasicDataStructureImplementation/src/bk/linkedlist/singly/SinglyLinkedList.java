package bk.linkedlist.singly;

public class SinglyLinkedList<T> {

	private Node<T> head;
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
		if (size > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void addFirst(T element) {
		Node node = new Node(element, head);

		if (size == 0) {
			tail = node;
		}
		head = node;
		size++;
	}

	public void addLast(T element) {
		Node node = new Node(element, null);
		if (size == 0) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	public T first() {
		if (isEmpty())
			return null;
		return head.getElement();

	}

	public T last() {
		if (isEmpty())
			return null;
		return tail.getElement();

	}

	public T removeFirst() {
		if (isEmpty())
			return null;
		Node<T> first = head;
		head = head.getNext();
		size--;
		return first.getElement();
	}
}
