package bk.queue.circular;

import bk.queue.Queue;

public interface CircularQueue<T> extends Queue<T> {
	void rotate();
}
