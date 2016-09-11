package bk.queue.circular;

public class JosephusProblem {

	private CircularQueue<String> circularQueue;
	private Integer josephusInt;

	JosephusProblem(String[] elements, Integer josephusInt) {
		this.circularQueue = new CircularLinkedQueue<String>();
		for (int i = 0; i < elements.length; i++) {
			circularQueue.enqueue(elements[i]);
		}

		this.josephusInt = josephusInt;
	}

	public String getWinner() {
		if (circularQueue.isEmpty())
			return null;
		while (circularQueue.size() > 1) {
			for (int i = 0; i < josephusInt - 1; i++) {
				circularQueue.rotate();
			}

			circularQueue.dequeue();
		}
		return circularQueue.dequeue();
	}

	public static void main(String[] args) {
		// add data to circular Queue
		String[] elements = new String[6];
		Integer josephusInt = 5;

		elements[0] = "Alice";
		elements[1] = "Bob";
		elements[2] = "Roy";
		elements[3] = "Jo";
		elements[4] = "Micky";
		elements[5] = "Fred";

		JosephusProblem josephusProblem = new JosephusProblem(elements, josephusInt);
		System.out.println("josephusProblem.getWinner()>>" + josephusProblem.getWinner());

	}
}
