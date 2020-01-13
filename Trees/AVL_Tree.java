/* --------AVL TREE-----------
	For every node :
	-1>=balance factor<=1, 
	i.e -1>= (height of left subtree - height of right subtree) <=1

	Imbalance Cases	: Solution Approach
	LL Imbalance	: Right Rotate
	RR Imbalance	: Left Rotate
	LR Imbalance	: Left Rotate, Right Rotate
	RL Imbalance	: Right Rotate, Left Rotate
*/

import java.util.*;
import java.lang.*;

class Node {
	int data;
	Node left,right;
	Node(int data) {
		this.data=data;
	}
}

public class AVL_Tree {
	Node root;
	
	int max(int a,int b) {
		return a>b?a:b;
	}

	int height(Node n) {
		if(n==null)
			return 0;
		else
			return 1+max(height(n.left),height(n.right));
	}

	Node rightRotate(Node n) {
		Node x=n.left;
		Node subtree=x.right;
		x.right=n;
		n.left=subtree;
		return x;
	}


	Node leftRotate(Node n) {
		Node x=n.right;
		Node subtree=x.left;
		x.left=n;
		n.right=subtree;
		return x;
	}

	Node insert(Node node,int key) {
		if(node==null)
			return new Node(key);
		if(key < node.data)
			node.left=insert(node.left,key);
		else if(key > node.data)
			node.right=insert(node.right,key);
		else 
			return node;

		int balance=height(node.left)-height(node.right);
		
		if(balance>1 && key<node.left.data) //LL imbalance
		{
			return rightRotate(node);
		}
		if(balance<-1 && key>node.right.data) //RR imbalance
		{
			return leftRotate(node);
		}
		if(balance>1 && key>node.left.data)	//LR imbalance
		{
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance<-1 && key<node.right.data)	//RL imbalance
		{
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	void inorder(Node n) {
		if(n==null)
			return;
		inorder(n.left);
		System.out.println(n.data);
		inorder(n.right);
	}



	public static void main(String[] args) {
		AVL_Tree obj=new AVL_Tree();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of elements : ");
		int n=sc.nextInt();
		System.out.println("Enter elements : ");
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			obj.root=obj.insert(obj.root,num);
		}
		System.out.println("Height of AVL_Tree is : "+ obj.height(obj.root));
		System.out.println("Inorder traversal of tree : ");
		obj.inorder(obj.root);
	}
}