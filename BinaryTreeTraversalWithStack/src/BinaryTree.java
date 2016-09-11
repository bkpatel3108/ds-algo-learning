
public interface BinaryTree<T> {
	
	/* Returns the number of nodes in the tree. */
	public int size();

	/* Returns the root Position of the tree (or null if tree is empty). */
	public Position<T> root();
	
	/*Returns the Position of p's parent (or null if p is root).*/
	public Position<T> parent(Position<T> p) throws IllegalArgumentException;
	
	/* Returns the Position of p's left child (or null if no child exists). */
	public Position<T> left(Position<T> p) throws IllegalArgumentException;

	/* Returns the Position of p's right child (or null if no child exists). */
	public Position<T> right(Position<T> p) throws IllegalArgumentException;

	/* Returns the Position of p's sibling (or null if no sibling exists). */
	public Position<T> sibling(Position<T> p) throws IllegalArgumentException;
	
	/*Places element e at the root of an empty tree and returns its new Position. */
	public Position<T> addRoot(T e) throws IllegalStateException;
	
	/*Creates a new left child of Position p storing element e; returns its Position.*/
	public Position<T> addLeft(Position<T> p, T e);
	
	/*Creates a new right child of Position p storing element e; returns its Position.*/
	public Position<T> addRight(Position<T> p, T e);
	
	/*Replaces the element at Position p with e and returns the replaced element*/
	public T set(Position<T> p, T e) throws IllegalArgumentException;
	
	/*Removes the node at Position p and replaces it with its child, if any.*/
	public T remove(Position<T> p) throws IllegalArgumentException;
}
