package bk.tree;

public class BinaryTreeVectorImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> T = new BinaryTreeVectorImpl<Integer>();
		Integer node1 = T.setRoot(23);

		Integer node2 = T.setLeftChild(node1, 22);
		Integer node3 = T.setRightChild(node1, 24);

		Integer node4 = T.setLeftChild(node2, 20);
		Integer node5 = T.setRightChild(node2, 21);

		Integer node6 = T.setLeftChild(node3, 10);
		Integer node7 = T.setRightChild(node3, 40);

		Integer node8 = T.setLeftChild(node4, 1);
		Integer node9 = T.setRightChild(node4, 5);

		Integer node14 = T.setLeftChild(node7, 45);
		Integer node15 = T.setRightChild(node7, 46);

		Integer node10 = T.setLeftChild(node5, 2);
		Integer node11 = T.setRightChild(node5, 3);

		// test root
		System.out.println("tree.root() >> " + T.root());

		// test leftChild
		System.out.println("tree.leftChild(node1) >> " + T.leftChild(node1));

		// test leftChild
		System.out.println("tree.rightChild(node1) >> " + T.rightChild(node1));

		// test isInternal
		System.out.println("tree.isInternal(node4) >> " + T.isInternal(node4));
		System.out.println("tree.isInternal(node11) >> " + T.isInternal(node11));

		// test isExternal
		System.out.println("tree.isExternal(node4) >> " + T.isExternal(node4));
		System.out.println("tree.isExternal(node11) >> " + T.isExternal(node11));

		// test root
		System.out.println("tree.isRoot(node4) >> " + T.isRoot(node4));
		System.out.println("tree.isRoot(node11) >> " + T.isRoot(node11));
		System.out.println("tree.isRoot(node1) >> " + T.isRoot(node1));

		// test parent
		System.out.println("tree.parent(node4) >> " + T.parent(node4));
		System.out.println("tree.parent(node11) >> " + T.parent(node11));
		System.out.println("tree.parent(node1) >> " + T.parent(node1));

		// test no of leaves
		System.out.println("tree.noOfLeaves(node1) >> " + T.noOfLeaves(node1));

		// test no of arcs
		System.out.println("tree.noOfArcs(node1) >> " + T.noOfArcs(node1));

		// test no of nodes
		System.out.println("tree.noOfNodes(node1) >> " + T.noOfNodes(node1));

		// test no of internal arcs
		System.out.println("tree.noOfInternalNodes(node1) >> " + T.noOfInternalNodes(node1));

		// test depth
		System.out.println("tree.depth(node1) >> " + T.depth(node1));

	}

}
