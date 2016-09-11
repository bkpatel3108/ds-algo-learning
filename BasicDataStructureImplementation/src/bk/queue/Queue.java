package bk.queue;

public interface Queue<T> {
	public Integer size();
	public boolean isEmpty();
	public void enqueue(T element);
	public T dequeue();
	public T first();
}
