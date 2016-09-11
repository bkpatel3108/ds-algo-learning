public class SetADTUsingBinaryVector {

	private boolean[] B;

	SetADTUsingBinaryVector(Integer size) {
		B = new boolean[size];
	}

	public void resize(Integer element) {
		boolean[] newB = new boolean[element];
		for (int i = 0; i < B.length; i++) {
			newB[i] = B[i];
		}
		B = newB;
	}

	// Adds the element e to Set (if not already present).
	public void add(Integer element) {
		if (element >= B.length) {
			resize(element+1);
			B[element] = true;
		} else if (!contains(element)) {
			B[element] = true;
		}
	}

	// Removes the element e from Set (if it is present).
	public void remove(Integer element) {
		if (contains(element)) {
			B[element] = false;
		}
	}

	// : Returns whether e is an element of Set.
	public boolean contains(Integer element) {
		if (element < B.length)
			if (B[element] == true)
				return true;
		return false;
	}

	// Union -> Add all
	// Updates This Set to also include all elements of set T, effectively replacing This set
	// by this Set ∪ T .
	public void addAll(SetADTUsingBinaryVector T) {
		for (int i = 0; i < T.B.length; i++) {
			if (T.B[i] == true) {
				this.add(i);
			}
		}
	}

	// intersection -> retainAll
	// Updates This Set so that it only keeps those elements that are also elements of
	// set T , effectively replacing This Set by This Set ∩ T
	public void retainAll(SetADTUsingBinaryVector T) {
		for (int i = 0; i < this.B.length; i++) {
			if (T.B[i] != true) {
				this.remove(i);
			} 
		}
	}

	// subtraction -> removeAll
	// Updates This Set by removing any of its elements that also occur in set T , effectively
	// replacing This Set by This Set − T .
	public void removeAll(SetADTUsingBinaryVector T) {
		for (int i = 0; i < T.B.length && i < this.B.length; i++) {
			if (T.B[i] == true) {
				this.remove(i);
			}
		}
	}
	
	public void printSet()
	{
		for(int i=0;i<B.length;i++)
		{
			System.out.print(i+"-"+B[i]+" ");
		}
		System.out.print("\n");
	}
}
