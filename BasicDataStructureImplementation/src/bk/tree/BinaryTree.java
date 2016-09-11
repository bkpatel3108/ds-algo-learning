package bk.tree;

public interface BinaryTree<T> {

	/**
	 * Returns a value of root node of tree
	 * 
	 * @return value of root node
	 */
	public T root();

	/**
	 * Returns a value of parent node of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of node whose parent node's value we want to
	 *            access
	 * @return value of parent node of the node which is at position
	 *         nodePosition
	 */
	public T parent(Integer nodePosition);

	/**
	 * Returns a value of left child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose left child's value we want to access
	 * @return value of left child of the node which is at position
	 *         nodePosition
	 */
	public T leftChild(Integer nodePosition);

	/**
	 * Returns a value of right child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose right child's value we want to
	 *            access
	 * @return value of right child of the node which is at position
	 *         nodePosition
	 */
	public T rightChild(Integer nodePosition);

	/**
	 * Creates a root of tree if tree is empty else set the value of root node
	 * of tree; returns its Position.
	 * 
	 * @param nodeValue
	 *            -> value of root node
	 * @return position of root node
	 */
	public Integer setRoot(T nodeValue);

	/**
	 * Creates a new left child of Node which is at position nodePosition,and
	 * storing new node value as nodeValue; returns its Position.
	 * 
	 * @param nodePosition
	 *            -> position of Node whose left child we want to create
	 * @param nodeValue
	 *            -> value of new left child
	 * @return position of newly created left child
	 */
	public Integer setLeftChild(Integer nodePosition, T nodeValue);

	/**
	 * Creates a new right child of Node which is at position
	 * nodePosition,and storing new node value as nodeValue; returns its
	 * Position.
	 * 
	 * @param nodePosition
	 *            -> position of Node whose right child we want to create
	 * @param nodeValue
	 *            -> value of new right child
	 * @return position of newly created right child
	 */
	public Integer setRightChild(Integer nodePosition, T nodeValue);

	/**
	 * Checks a node, which is at position nodePosition, is internal to tree
	 * or not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            internal or not
	 * @return true or false based on element is internal or not
	 */
	public boolean isInternal(Integer nodePosition);

	/**
	 * Checks a node, which is at position nodePosition, is external to tree
	 * or not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            external or not
	 * @return true or false based on element is external or not
	 */
	public boolean isExternal(Integer nodePosition);

	/**
	 * Checks a node, which is at position nodePosition, is root of tree or
	 * not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            root of tree or not
	 * @return true or false based on element is root of tree or not
	 */
	public boolean isRoot(Integer nodePosition);

	/**
	 * Returns numbers of leaves of the tree whose root node position is
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose no of leaves we want to
	 *            count
	 * @return no of leaves of tree which has "@param nodePosition" as
	 *         position of root node
	 */
	public Integer noOfLeaves(Integer nodePosition);

	/**
	 * Returns numbers of arcs in the tree whose root node position is
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose no of arcs we want to
	 *            count
	 * @return no of arcs in tree which has "@param nodePosition" as position
	 *         of root node
	 */
	public Integer noOfArcs(Integer nodePosition);

	/**
	 * Returns numbers of nodes of the tree whose root node position is
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose no of nodes we want to
	 *            count
	 * @return no of nodes of tree which has "@param nodePosition" as
	 *         position of root node
	 */
	public Integer noOfNodes(Integer nodePosition);

	/**
	 * Returns numbers of internal nodes of the tree whose root node position is
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose no of internal nodes we
	 *            want to count
	 * @return no of internal nodes of tree which has "@param nodePosition"
	 *         as position of root node
	 */
	public Integer noOfInternalNodes(Integer nodePosition);

	/**
	 * Returns depth of the tree whose root node position is nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose depth we want to
	 *            calculate
	 * @return depth of tree which has "@param nodePosition" as position of
	 *         root node
	 */
	public Integer depth(Integer nodePosition);

	/**
	 * Returns a position of left child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose left child's position we want to get
	 * @return position of left child of the node which is at position
	 *         nodePosition
	 */
	public Integer left(Integer nodePosition);

	/**
	 * Returns a position of right child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose right child's position we want to
	 *            get
	 * @return position of right child of the node which is at position
	 *         nodePosition
	 */
	public Integer right(Integer nodePosition);
}
