import java.util.Vector;

public class UnionSet {

	void doUnionSet(Vector<Integer> S, Vector<Integer> A, Vector<Integer> B) {
		while (!(A.isEmpty() || B.isEmpty())) {
			if (A.firstElement() <= B.firstElement()) {
				if (S.isEmpty() || A.firstElement() != S.lastElement()) {
					S.insertElementAt(A.remove(0), S.size());
				}
				else
					A.remove(0);
			} else {
				if (S.isEmpty() || B.firstElement() != S.lastElement()) {
					S.insertElementAt(B.remove(0), S.size());
				}
				else 
					B.remove(0);
			}
		}
		
		while(!A.isEmpty())
		{
			if (A.firstElement() != S.lastElement()) {
				S.insertElementAt(A.remove(0), S.size());
			}
			else
				A.remove(0);
		}
		
		while(!B.isEmpty())
		{
			if (B.firstElement() != S.lastElement()) {
				S.insertElementAt(B.remove(0), S.size());
			}
			else
				B.remove(0);
		}
	}

}
