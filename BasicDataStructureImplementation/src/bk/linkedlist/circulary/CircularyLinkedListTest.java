package bk.linkedlist.circulary;

public class CircularyLinkedListTest {
	public static void main(String[] args)
	{
		CircularlyLinkedList<String> circularlyLinkedList = new CircularlyLinkedList<String>();
		System.out.println("linkedList.size() >>"+circularlyLinkedList.size());
		System.out.println("linkedList.isEmpty() >>"+circularlyLinkedList.isEmpty());
		
		circularlyLinkedList.addFirst("Chrome process");
		circularlyLinkedList.addFirst("Webcam process");
		circularlyLinkedList.addFirst("Safari process");
		
		System.out.println("linkedList.first() >>"+circularlyLinkedList.first());
		System.out.println("linkedList.last() >>"+circularlyLinkedList.last());
		
		circularlyLinkedList.removeFirst();
		System.out.println("linkedList.size() >>"+circularlyLinkedList.size());
		System.out.println("linkedList.isEmpty() >>"+circularlyLinkedList.isEmpty());
		System.out.println("linkedList.first() >>"+circularlyLinkedList.first());
		System.out.println("linkedList.last() >>"+circularlyLinkedList.last());

		circularlyLinkedList.removeFirst();
		System.out.println("linkedList.size() >>"+circularlyLinkedList.size());
		System.out.println("linkedList.isEmpty() >>"+circularlyLinkedList.isEmpty());
		System.out.println("linkedList.first() >>"+circularlyLinkedList.first());
		System.out.println("linkedList.last() >>"+circularlyLinkedList.last());
		
		circularlyLinkedList.addLast("Eclipse process");
		circularlyLinkedList.addLast("Github process");
		System.out.println("linkedList.size() >>"+circularlyLinkedList.size());
		System.out.println("linkedList.isEmpty() >>"+circularlyLinkedList.isEmpty());
		System.out.println("linkedList.first() >>"+circularlyLinkedList.first());
		System.out.println("linkedList.last() >>"+circularlyLinkedList.last());
		
		circularlyLinkedList.removeFirst();
		System.out.println("linkedList.size() >>"+circularlyLinkedList.size());
		System.out.println("linkedList.isEmpty() >>"+circularlyLinkedList.isEmpty());
		System.out.println("linkedList.first() >>"+circularlyLinkedList.first());
		System.out.println("linkedList.last() >>"+circularlyLinkedList.last());

	}
}
