package bk.queue.circular;

public class CircularLinkedQueue<T> implements CircularQueue<T> {

	private Node<T> tail;
	private Integer size = 0;

	private class Node<T> {
		private T element;
		private Node<T> next;

		Node(T element, Node<T> next) {
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

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size > 0) {
			return false;
		} else
			return true;
	}

	@Override
	public void enqueue(Object element) {
		// TODO Auto-generated method stub
		Node<T> node;
		if (size > 0) {
			node = new Node(element, tail.getNext());
			tail.setNext(node);
		} else {
			node = new Node(element, null);
			node.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T firstElement;
		if (size == 0)
			return null;
		if (size > 1) {
			Node<T> firstNode = tail.getNext();
			firstElement = firstNode.getElement();
			tail.setNext(firstNode.getNext());
		} else {
			Node<T> firstNode = tail;
			firstElement = firstNode.getElement();
			tail = null;
		}
		size--;
		return firstElement;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		T firstElement;
		if (size == 0)
			return null;
		if (size > 1) {
			Node<T> firstNode = tail.getNext();
			firstElement = firstNode.getElement();
		} else {
			Node<T> firstNode = tail;
			firstElement = firstNode.getElement();
		}
		return firstElement;
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		if(tail != null)
		{
			tail = tail.getNext();
		}
	}

}
