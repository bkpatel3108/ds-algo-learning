
public class ArrayQueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayQueue<Integer>(2);
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println("queue.dequeue()>>" + queue.dequeue());
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		System.out.println("queue.dequeue()>>" + queue.dequeue());
	}
}
