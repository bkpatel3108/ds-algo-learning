package bk.queue;

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private Integer f = -1;
	private Integer size = 0;
	private Integer defaultCapacity = 100;
	private Integer capacity;

	ArrayQueue() {
		this.capacity = defaultCapacity;
	}

	ArrayQueue(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer size() {
		return size;
	}

	public boolean isEmpty() {
		if (size > 0) {
			return false;
		}
		return true;
	}

	public void enqueue(T element) {
		if (size <= capacity) {
			Integer newElmplace = (f + size) % capacity;
			data[newElmplace] = element;
			size++;
		} else
			throw new IllegalStateException("Queue is full");
	}

	public T dequeue() {
		if (size > 0) {
			T frontElement = data[f];
			data[f] = null;
			f = (f + 1) % capacity;
			size--;
			return frontElement;
		} else
			return null;
	}

	public T first() {
		if (size > 0) {
			T frontElement = data[f];
			return frontElement;
		} else
			return null;
	}

}
