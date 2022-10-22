package com.ds.linkedlist;



//Java program for reversing the linked list

class test {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	int getDecimal(Node head) {
		int temp = 0;
		while(head != null) {
			temp=(temp<<1)+ head.data;
			head= head.next;
		}
		return temp;
	}

	/* Function to reverse the linked list */
	Node reverse(Node node)
	{
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	// prints content of double linked list
	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		test list = new test();
		list.head = new Node(1);
		list.head.next = new Node(1);
		list.head.next.next = new Node(0);
		list.head.next.next.next = new Node(1);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
		
		int decimal = list.getDecimal(head);
		System.out.println(decimal);
	}
}
