import java.util.Vector;

public class UnionSetTest {
	
	public static void main(String[] args)
	{
		//Sequence A
		Vector<Integer> A = new Vector<Integer>();
		A.add(2);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(7);
		A.add(11);
		
		//Sequence B
		Vector<Integer> B = new Vector<Integer>();
		B.add(2);
		B.add(5);
		B.add(7);
		B.add(9);
		
		System.out.println("A >> "+A);
		System.out.println("B >> "+B);
		
		//Sequence S
		Vector<Integer> S = new Vector<Integer>();
		
		UnionSet unionSet = new UnionSet();
		unionSet.doUnionSet(S, A, B);
		System.out.println("S >> "+S);
	}
}
