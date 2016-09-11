public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int f = 0;
	private int sz = 0;
	private int CAPACITY = 100;

	public ArrayQueue() {
		data = (T[]) new Object[CAPACITY];
	}

	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
	}

	public int size() {
		return sz;
	}

	public boolean isEmpty() {
		return (sz == 0);
	}

	public void enqueue(T e) throws IllegalStateException {
		if (sz == data.length) {
			resize();
		}
		int avail = (f + sz) % data.length;
		data[avail] = e;
		sz++;
	}

	public T first() {
		if (isEmpty())
			return null;
		return data[f];
	}

	public T dequeue() {
		if (isEmpty())
			return null;
		T answer = data[f];
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}

	private void resize() {
		T[] newData = (T[]) new Object[2 * data.length];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}
