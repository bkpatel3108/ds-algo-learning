package bk.tree;

import java.util.Vector;

public class BinaryTreeVectorImpl<T> implements BinaryTree<T> {

	private Vector<T> S;

	BinaryTreeVectorImpl() {
		S = new Vector<T>();
	}

	/**
	 * Returns a value of root node of tree
	 * 
	 * @return value of root node
	 */
	public T root() {
		if (S.size() > 0) {
			T root = S.get(0);
			return root;
		} else
			return null;
	}

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
	public T parent(Integer nodePosition) {
		if (S.size() > 1) {
			Integer parentElementVectorPos = ((int) nodePosition / 2) - 1;
			if (parentElementVectorPos > 0) {
				T parentElement = S.get(parentElementVectorPos);
				return parentElement;
			} else
				return null;
		} else
			return null;
	}

	/**
	 * Returns a value of left child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose left child's value we want to access
	 * @return value of left child of the node which is at position
	 *         nodePosition
	 */
	public T leftChild(Integer nodePosition) {
		Integer leftChildVectorPos = (2 * nodePosition) - 1;
		if (S.size() > leftChildVectorPos) {
			T leftElement = S.get(leftChildVectorPos);
			return leftElement;
		} else
			return null;
	}

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
	public T rightChild(Integer nodePosition) {
		Integer rightChildVectorPos = (2 * nodePosition);
		if (S.size() > rightChildVectorPos) {
			T rightElement = S.get(rightChildVectorPos);
			return rightElement;
		} else
			return null;
	}

	/**
	 * Creates a root of tree if tree is empty else set the value of root node
	 * of tree; returns its Position.
	 * 
	 * @param nodeValue
	 *            -> value of root node
	 * @return position of root node
	 */
	public Integer setRoot(T nodeValue) {
		if (S.size() > 0)
			S.setElementAt(nodeValue, 0);
		else
			S.insertElementAt(nodeValue, 0);
		return 1;
	}

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
	public Integer setLeftChild(Integer nodePosition, T nodeValue) {
		// As vector index start from 0
		Integer leftChildPos = (2 * nodePosition) - 1;
		if (leftChildPos + 1 > S.size()) {
			for (int i = S.size(); i < leftChildPos; i++) {
				S.insertElementAt(null, i);
			}
			S.insertElementAt(nodeValue, leftChildPos);
		} else
			S.setElementAt(nodeValue, leftChildPos);
		return leftChildPos + 1;
	}

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
	public Integer setRightChild(Integer nodePosition, T nodeValue) {
		// As vector index start from 0
		Integer rightChildPos = (2 * nodePosition);
		if (rightChildPos + 1 > S.size()) {
			for (int i = S.size(); i < rightChildPos; i++) {
				S.insertElementAt(null, i);
			}
			S.insertElementAt(nodeValue, rightChildPos);
		} else
			S.setElementAt(nodeValue, rightChildPos);
		return rightChildPos + 1;
	}

	/**
	 * Checks a node, which is at position nodePosition, is internal to tree
	 * or not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            internal or not
	 * @return true or false based on element is internal or not
	 */
	public boolean isInternal(Integer nodePosition) {
		// if it has not null left child or not null right child then return
		// true
		if (leftChild(nodePosition) != null || rightChild(nodePosition) != null)
			return true;
		return false;
	}

	/**
	 * Checks a node, which is at position nodePosition, is external to tree
	 * or not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            external or not
	 * @return true or false based on element is external or not
	 */
	public boolean isExternal(Integer nodePosition) {
		// if it has null left child and null right child then return
		// true
		if (leftChild(nodePosition) == null && rightChild(nodePosition) == null)
			return true;
		return false;
	}

	/**
	 * Checks a node, which is at position nodePosition, is root of tree or
	 * not
	 * 
	 * @param nodePosition
	 *            -> position of node which needs to be checked whether it is
	 *            root of tree or not
	 * @return true or false based on element is root of tree or not
	 */
	public boolean isRoot(Integer nodePosition) {
		if (nodePosition == 1)
			return true;
		else
			return false;
	}

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
	public Integer noOfLeaves(Integer nodePosition) {
		if (isInternal(nodePosition)) {
			Integer noOfLeavesOfLeftChild;
			Integer noOfLeavesOfRightChild;
			Integer leftChildPos = left(nodePosition);
			Integer rightChildPos = right(nodePosition);

			if (leftChildPos != null)
				noOfLeavesOfLeftChild = noOfLeaves(leftChildPos);
			else
				noOfLeavesOfLeftChild = 0;

			if (rightChildPos != null)
				noOfLeavesOfRightChild = noOfLeaves(rightChildPos);
			else
				noOfLeavesOfRightChild = 0;

			return noOfLeavesOfLeftChild + noOfLeavesOfRightChild;
		} else
			return 1;
	}

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
	public Integer noOfArcs(Integer nodePosition) {
		if (isInternal(nodePosition)) {
			Integer noOfArcsOfLeftChild;
			Integer noOfArcsOfRightChild;
			Integer leftChildPos = left(nodePosition);
			Integer rightChildPos = right(nodePosition);

			if (leftChildPos != null)
				noOfArcsOfLeftChild = noOfArcs(leftChildPos);
			else
				noOfArcsOfLeftChild = 0;

			if (rightChildPos != null)
				noOfArcsOfRightChild = noOfArcs(rightChildPos);
			else
				noOfArcsOfRightChild = 0;

			return 2 + noOfArcsOfLeftChild + noOfArcsOfRightChild;
		} else
			return 0;
	}

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
	public Integer noOfNodes(Integer nodePosition) {
		if (isInternal(nodePosition)) {
			Integer noOfNodesOfLeftChild;
			Integer noOfNodesOfRightChild;
			Integer leftChildPos = left(nodePosition);
			Integer rightChildPos = right(nodePosition);

			if (leftChildPos != null)
				noOfNodesOfLeftChild = noOfNodes(leftChildPos);
			else
				noOfNodesOfLeftChild = 0;

			if (rightChildPos != null)
				noOfNodesOfRightChild = noOfNodes(rightChildPos);
			else
				noOfNodesOfRightChild = 0;

			return 1 + noOfNodesOfLeftChild + noOfNodesOfRightChild;
		} else
			return 1;
	}

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
	public Integer noOfInternalNodes(Integer nodePosition) {
		if (isInternal(nodePosition)) {
			Integer noOfInternalNodesOfLeftChild;
			Integer noOfInternalNodesOfRightChild;
			Integer leftChildPos = left(nodePosition);
			Integer rightChildPos = right(nodePosition);

			if (leftChildPos != null)
				noOfInternalNodesOfLeftChild = noOfInternalNodes(leftChildPos);
			else
				noOfInternalNodesOfLeftChild = 0;

			if (rightChildPos != null)
				noOfInternalNodesOfRightChild = noOfInternalNodes(rightChildPos);
			else
				noOfInternalNodesOfRightChild = 0;

			return 1 + noOfInternalNodesOfLeftChild + noOfInternalNodesOfRightChild;
		} else
			return 0;
	}

	/**
	 * Returns depth of the tree whose root node position is nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of root node of tree whose depth we want to
	 *            calculate
	 * @return depth of tree which has "@param nodePosition" as position of
	 *         root node
	 */
	public Integer depth(Integer nodePosition) {
		if (isInternal(nodePosition)) {
			Integer depthOfLeftChild;
			Integer depthOfRightChild;
			Integer leftChildPos = left(nodePosition);
			Integer rightChildPos = right(nodePosition);

			if (leftChildPos != null)
				depthOfLeftChild = depth(leftChildPos);
			else
				depthOfLeftChild = 0;

			if (rightChildPos != null)
				depthOfRightChild = depth(rightChildPos);
			else
				depthOfRightChild = 0;

			return 1 + (depthOfLeftChild > depthOfRightChild ? depthOfLeftChild : depthOfRightChild);
		} else
			return 0;
	}

	/**
	 * Returns a position of left child of the node which is at position
	 * nodePosition
	 * 
	 * @param nodePosition
	 *            -> position of Node whose left child's position we want to get
	 * @return position of left child of the node which is at position
	 *         nodePosition
	 */
	public Integer left(Integer nodePosition) {
		Integer leftChildPos = (2 * nodePosition);
		if (S.size() >= leftChildPos) {
			return leftChildPos;
		} else
			return null;
	}

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
	public Integer right(Integer nodePosition) {
		Integer rightChildPos = (2 * nodePosition) + 1;
		if (S.size() >= rightChildPos) {
			return rightChildPos;
		} else
			return null;
	}

}
