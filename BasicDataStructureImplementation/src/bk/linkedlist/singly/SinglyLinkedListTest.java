package bk.linkedlist.singly;

public class SinglyLinkedListTest {
	
	public static void main(String[] args)
	{
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

		System.out.println("linkedList.size() >>"+ linkedList.size());
		
		linkedList.addFirst(1);
		linkedList.addLast(2);
		
		System.out.println("linkedList.size() >>"+linkedList.size());
		linkedList.addFirst(3);
		linkedList.addLast(4);
		
		System.out.println("linkedList.size() >>"+linkedList.size());
		System.out.println("linkedList.first() >>"+linkedList.first());
		System.out.println("linkedList.last() >>"+linkedList.last());
		
		System.out.println("linkedList.size() >>"+linkedList.size());
		System.out.println("linkedList.removeFirst() >>"+linkedList.removeFirst());
		System.out.println("linkedList.size() >>"+linkedList.size());
	}
	
}
