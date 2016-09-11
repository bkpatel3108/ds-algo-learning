
public class BinaryTreeTraversalWithStack<T> {

	public void doInOrderTraversal(BinaryTree<T> binaryTree) {
		// Initialize Stack object to use it in tree traversal
		System.out.println("\nInorder Traversal");
		Stack<Position> stack = new LinkedStack<Position>();
		Position<T> currentPosition = binaryTree.root();
		Node<T> currentNode = (Node<T>) currentPosition;
	
		while (currentNode != null || !stack.isEmpty()) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				Node<T> stackNode = (Node<T>) stack.pop();
				System.out.print(stackNode.getElement() + " ");
				currentNode = stackNode.getRight();
			}
		}
	}
	
	
	public void doPreorderTraversal(BinaryTree<T> binaryTree) {
		// Initialize Stack object to use it in tree traversal
		System.out.println("\nPreorder Traversal");
		Stack<Position> stack = new LinkedStack<Position>();
		Position<T> currentPosition = binaryTree.root();
		Node<T> currentNode = (Node<T>) currentPosition;
		
		while (currentNode != null || !stack.isEmpty()) {
			if (currentNode != null) {
				System.out.print(currentNode.getElement() + " ");
				if(currentNode.getRight() != null)
				{
					stack.push(currentNode.getRight());
				}
				currentNode = currentNode.getLeft();
			} else {
				currentNode = (Node<T>) stack.pop();
			}
		}
		System.out.println("\n");
	}
}
