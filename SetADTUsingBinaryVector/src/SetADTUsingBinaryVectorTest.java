
public class SetADTUsingBinaryVectorTest {

	public static void main(String[] args) {
		// create set A
		SetADTUsingBinaryVector A = new SetADTUsingBinaryVector(20);

		// Add elements to it
		A.add(0);
		A.add(2);
		A.add(5);
		A.add(7);
		A.add(3);
		A.add(6);
		A.add(9);
		A.add(17);
		A.add(19);
		A.add(15);
		A.add(11);

		// test contains method
		System.out.println("A.contains(15) >>" + A.contains(15));
		System.out.println("A.contains(12) >>" + A.contains(12));

		// test remove method
		System.out.println("A.contains(9) >>" + A.contains(9));
		System.out.println("A.contains(8) >>" + A.contains(8));
		A.remove(8);
		A.remove(9);
		System.out.println("A.contains(9) >>" + A.contains(9));
		System.out.println("A.contains(8) >>" + A.contains(8));

		// create set T
		SetADTUsingBinaryVector T1 = new SetADTUsingBinaryVector(24);
		T1.add(17);
		T1.add(15);
		T1.add(19);
		T1.add(21);
		T1.add(23);

		SetADTUsingBinaryVector T2 = new SetADTUsingBinaryVector(14);
		T2.add(12);
		T2.add(11);
		T2.add(19);

		// test Union
		// for loop will be executed 25 times as T1's length is 25
		// So, if T1 has m element then it will run in O(m) time. Here, m is 25
		A.addAll(T1);
		System.out.println("\nA after Union with T1 >>");
		A.printSet();

		// for loop will be executed 15 times as T2's length is 15
		// So, if T2 has m element then it will run in O(m) time. Here, m is 15
		A.addAll(T2);
		System.out.println("\nA after Union with T2 >>");
		A.printSet();

		// test Subtraction
		// for loop will be executed 15 times as A's new length is 25 and T2's
		// length is 15, and 15 < 25
		// So, if T2 has m element, and A has n element then it will run in O(m)
		// time if m < n and O(n) if n < m.
		A.removeAll(T2);
		System.out.println("\nA after Subtraction with T2 >>");
		A.printSet();

		// test Intersection
		// for loop will be executed 25 times as A's length is 25
		// So, if A has n element then it will run in O(n) time. Here, n is 25
		A.retainAll(T1);
		System.out.println("\nA after Intersection with T1 >>");
		A.printSet();
	}

}
