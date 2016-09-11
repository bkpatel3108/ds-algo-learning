//
//package bk.treetemp;
//
//import bk.tree.Tree;
//
//public class TreeFunctionsUsingADT {
//	
//	public static void main(String[] arg)
//	{
//		//Construct the tree
//		Tree tree = new Tree(...);
//		
//		//get the root Node
//		Node rootNode = tree.root();
//		
//		//print no of leaves of tree
//		System.out.println(noOfLeaves(rootNode));
//		
//		//print no of arcs of tree
//		System.out.println(noOfArcs(rootNode));
//		
//		//print no of nodes of tree
//		System.out.println(noOfNodes(rootNode));
//		
//		//print no of internal nodes of tree
//		System.out.println(noOfInternalNodes(rootNode));
//		
//		//print no of depth of tree
//		System.out.println(depth(rootNode));
//	}
//	
//	/**
//	 * 
//	 * @param node
//	 * @return no of leaves of given tree which has "@param node" as root node
//	 */
//	public Integer noOfLeaves(Node node)
//	{
//		if(isInternal(node))
//			return noOfLeavaes(node.leftChild()) + noOfLeaves(node.rightChild());
//		else
//			return 1;	
//	}
//	
//	
//	/**
//	 * 
//	 * @param node
//	 * @return no of arcs in given tree which has "@param node" as root node
//	 */
//	public Integer noOfArcs(Node node)
//	{
//		if(isInternal(node))
//			return 2 + noOfArcs2(node);
//		else
//			return 0;
//	}
//	
//	/**
//	 * 
//	 * @param node
//	 * @return no of arcs in given tree which has "@param node" as root node
//	 */
//	public Integer noOfArcs1(Node node)
//	{
//		return noOfNodes(node) - 1;
//	}
//	
//	
//	/**
//	 * 
//	 * @param node
//	 * @return no of nodes in given tree which has "@param node" as root node
//	 */
//	public Integer noOfNodes(Node node)
//	{
//		if(isInternal(node))
//			return 1 + noOfNodes(node.leftChild()) + noOfNodes(node.rightChild());
//		else
//			return 1;
//	}
//	
//	/**
//	 * 
//	 * @param node
//	 * @return no of internal nodes in given tree which has "@param node" as root node
//	 */
//	public Integer noOfInternalNodes(Node node)
//	{
//		if(isInternal(node))
//			return 1 + noOfInternalNodes(node.leftChild()) + noOfInternalNodes(node.rightChild());
//		else
//			return 0;
//	}
//	
//	/**
//	 * 
//	 * @param node
//	 * @return depth of given tree which has "@param node" as root node
//	 */
//	public Integer depth(Node node)
//	{
//		if(isInternal(node))
//		{
//			return 1 + ( depth(node.leftChild()) > depth(node.rightChild()) ? depth(node.leftChild()) : depth(node.rightChild()) );
//		}
//		else
//			return 0;
//	}
//	
//}
