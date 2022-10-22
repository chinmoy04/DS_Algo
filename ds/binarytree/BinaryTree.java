package com.ds.binarytree;

import java.util.Stack;

class Node{
	int data;
	Node left, right;
	
	Node(int x){
		data = x;
		left = right = null;
	}
}

public class BinaryTree {
	
	Node root;
	
	void inorder() {
		
		if(root == null) {
			return;
		}
		
		Node current = root;
		
		Stack<Node> st = new Stack<Node>();
		
		while(current != null || !st.empty()) {
			
			while(current != null) {
				st.push(current);
				current = current.left;
			}
			
			Node temp = st.pop();
			
			System.out.println(temp.data);
			
			current = temp.right;
		}
			
	}
	
	
	public static void main(String args[])
    {
 
        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }

}
