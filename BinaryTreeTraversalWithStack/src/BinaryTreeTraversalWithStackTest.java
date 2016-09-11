import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeTraversalWithStackTest {
	public static void main(String[] args) {
		// create binary tree
		BinaryTree<String> binaryTree = new LinkedBinaryTree<String>();

		Scanner reader = new Scanner(System.in); // Reading from System.in
		System.out.println("Enter a number: \n1 - For quick test \n2 - For manual test ");
		int testType = reader.nextInt();

		if (testType == 1) {
			Position<String> rootPos = binaryTree.addRoot("1");

			Position<String> node2Pos = binaryTree.addLeft(rootPos, "2");
			Position<String> node3Pos = binaryTree.addRight(rootPos, "3");

			Position<String> node4Pos = binaryTree.addLeft(node2Pos, "4");
			Position<String> node5Pos = binaryTree.addRight(node2Pos, "5");

			Position<String> node6Pos = binaryTree.addLeft(node3Pos, "6");
			Position<String> node7Pos = binaryTree.addRight(node3Pos, "7");

		} else if (testType == 2) {
			System.out.println("Please enter 'end' to end adding nodes to tree");
			System.out.println("Please enter 'null' to make left or right child null");
			System.out.println("Please enter root element");

			String root = reader.next();
			Position<String> rootPos = binaryTree.addRoot(root);

			// used for taking input from user to build tree
			Queue<Position<String>> parentNodeQueue = new LinkedList<Position<String>>();
			parentNodeQueue.add(rootPos);

			while (true) {
				Position<String> currentNodePos = parentNodeQueue.poll();
				System.out.println("Please enter value of left child of " + currentNodePos.getElement());

				String leftNodeValue = reader.next();
				if (leftNodeValue.equals("end")) {
					break;
				} else {
					if (!leftNodeValue.trim().equals("null")) {
						Position<String> leftNodePos = binaryTree.addLeft(currentNodePos, leftNodeValue);
						parentNodeQueue.add(leftNodePos);
					}
				}

				System.out.println("Please enter value of right child of " + currentNodePos.getElement());
				String rightNodeValue = reader.next();
				if (rightNodeValue.equals("end")) {
					break;
				} else {
					if (!rightNodeValue.trim().equals("null")) {
						Position<String> rightNodePos = binaryTree.addRight(currentNodePos, rightNodeValue);
						parentNodeQueue.add(rightNodePos);
					}
				}

			}

		}

		BinaryTreeTraversalWithStack<String> binaryTreeTraversalWithStack = new BinaryTreeTraversalWithStack<String>();
		binaryTreeTraversalWithStack.doInOrderTraversal(binaryTree);
		binaryTreeTraversalWithStack.doPreorderTraversal(binaryTree);
	}
}
