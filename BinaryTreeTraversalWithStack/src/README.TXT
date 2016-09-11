Run following command to start this program
java BinaryTreeTraversalWithStackTest

You can test this program 2 ways.
1. Quick Test 2. Manual Test
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

1. Quick Test
Binary Tree is hard coded in program.
To choose this option, enter 1. 
It will generate inorder and preorder tree traversal output.
------------------------------------------
Hard coded tree in program is as following:
root node -> 1
left child node of 1 -> 2
right child node of 1 -> 3
left child node of 2 -> 4
right child node of 2 -> 5
left child node of 3 -> 6
right child node of 3 -> 7
------------------------------------------
Output :
Enter a number: 
1 - For quick test 
2 - For manual test 
1

Inorder Traversal
4 2 5 1 6 3 7 
Preorder Traversal
1 2 4 5 3 6 7 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

2. Manual Test
You can build your tree using command line input. To choose this option, enter 2.
Start adding nodes value. It will start from root and will be followed by adding left child 
node and right child node. It will be repeated until you enter 'end' to stop adding nodes to
tree. Enter null to skip adding any left or/and right child node.
After entering end, It will generate inorder and preorder tree traversal output.
For Example : To build binary tree as above mentioned hard coded tree, you need to enter 
following values.
------------------------------------------
Output :
Enter a number: 
 1 - For quick test 
 2 - For manual test 
2
Please enter 'end' to end adding nodes to tree 
Please enter 'null' to make left or right child null
Please enter root element 
1
Please enter value of left child of 1
2
Please enter value of right child of 1
3
Please enter value of left child of 2
4
Please enter value of right child of 2
5
Please enter value of left child of 3
6
Please enter value of right child of 3
7
Please enter value of left child of 4
end

Inorder Traversal
4 2 5 1 6 3 7 
Preorder Traversal
1 2 4 5 3 6 7 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

More Examples:
Example : With null value as left and/or right child node
Enter a number: 
1 - For quick test 
2 - For manual test 
2
Please enter 'end' to end adding nodes to tree
Please enter 'null' to make left or right child null
Please enter root element
1
Please enter value of left child of 1
2
Please enter value of right child of 1
3
Please enter value of left child of 2
4
Please enter value of right child of 2
5
Please enter value of left child of 3
6
Please enter value of right child of 3
7
Please enter value of left child of 4
null
Please enter value of right child of 4
null
Please enter value of left child of 5
8
Please enter value of right child of 5
9
Please enter value of left child of 6
null
Please enter value of right child of 6
null
Please enter value of left child of 7
10
Please enter value of right child of 7
11
Please enter value of left child of 8
end

Inorder Traversal
4 2 8 5 9 1 6 3 10 7 11 
Preorder Traversal
1 2 4 5 8 9 3 6 7 10 11 
------------------------------------------
Example : Wikipedia example https://en.wikipedia.org/wiki/Tree_traversal
Enter a number: 
1 - For quick test 
2 - For manual test 
2
Please enter 'end' to end adding nodes to tree
Please enter 'null' to make left or right child null
Please enter root element
f
Please enter value of left child of f
b
Please enter value of right child of f
g
Please enter value of left child of b
a
Please enter value of right child of b
d
Please enter value of left child of g
null
Please enter value of right child of g
i
Please enter value of left child of a
null
Please enter value of right child of a
null
Please enter value of left child of d
c
Please enter value of right child of d
e
Please enter value of left child of i
h
Please enter value of right child of i
null
Please enter value of left child of c
end

Inorder Traversal
a b c d e f g h i 
Preorder Traversal
f b a d c e g i h 
