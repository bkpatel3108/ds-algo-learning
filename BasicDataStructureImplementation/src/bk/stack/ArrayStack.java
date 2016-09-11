package bk.stack;

public class ArrayStack<T> implements Stack<T> {

	private T[] data;
	private Integer counter = -1;
	private Integer defaultCapacity = 100;
	private Integer capacity;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.capacity = defaultCapacity;
		data = (T[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(Integer capacity) {
		this.capacity = capacity;
		data = (T[]) new Object[capacity];
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		counter = counter + 1;
		if (counter <= capacity) {
			data[counter] = t;
		} else {
			throw new IllegalStateException("ArrayStack is full");
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (counter >= 0) {
			T topElement = (T) data[counter];
			data[counter] = null;
			counter = counter - 1;
			return topElement;
		} else {
			return null;
		}
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (counter >= 0) {
			T topElement = (T) data[counter];
			return topElement;
		} else {
			return null;
		}
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return counter+1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (counter >= 0)
			return false;
		return true;
	}

}
