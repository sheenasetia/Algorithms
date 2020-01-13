/* --------RBT(Red Black Tree)-----------
	Root is always black
	No two adjacent nodes can be red
	To every path from node to leaf , number of black nodes are same

  Approach :
  + color new node to be inserted as red always
  + if parent of a node is red,check parent's sibling
  	if that is also red then ,
  	1) change colors of parent and sibling to black
  	2) grandparent as red
  	3) repeat same step for grandparent
  	
  	else if that is black then ,
  	1) rotation
  + if both childs of a node are red
  	recolor all three nodes
  + Always turn root as black

*/

import java.util.*;
class Node {
	int data;
	Node left,right,parent;
	boolean color;	//red:true black:false
	Node(int data) {
		this.data=data;
		this.color=true;
	}
}

public class RBT {
	Node root=null;
	Node rotateRight(Node n) {
		Node x=n.left;
		Node np=n.parent;
		Node subtree=x.right;
		x.right=n;
		n.left=subtree;
		n.parent=x;
		x.parent=np;
		return x;
	}


	Node rotateLeft(Node n) {
		Node x=n.right;
		Node np=n.parent;
		Node subtree=x.left;
		x.left=n;
		n.right=subtree;
		n.parent=x;
		x.parent=np;
		return x;
	}

	Node checkForRules(Node n,Node newnode)
	{
		Node parent= null,grandparent=null;
		while((newnode!=n) && (newnode.color!=false) //not root , not black, parent is red
			&& (newnode.parent.color==true))
		{
			parent=newnode.parent;
			grandparent=newnode.parent.parent;
			if(parent == grandparent.left)
			{
				Node uncle=grandparent.right;
				if(uncle!=null && uncle.color==true) //uncle is red
				{
					grandparent.color=true;
					parent.color=uncle.color=false;
					newnode=grandparent;
				}
				else
				{		//uncle is black
					if(newnode==parent.right)
					{
						grandparent.left=rotateLeft(parent);
						newnode=parent;
						parent=newnode.parent;
					}
					if(grandparent.parent!=null)
						grandparent.parent.left=rotateRight(grandparent);
					else
						n=rotateRight(grandparent);
					parent.color=(!parent.color);
					grandparent.color=(!grandparent.color);
					//swap(parent.color,grandparent.color);
					newnode=parent;
				}
			}
			else
			{
				Node uncle=grandparent.left;
				if(uncle!=null && uncle.color==true){
					grandparent.color=true;
					parent.color=uncle.color=false;
					newnode=grandparent;
				}
				else
				{
					if(newnode==parent.left)
					{
						grandparent.right=rotateRight(parent);
						newnode=parent;
						parent=newnode.parent;
					}
					if(grandparent.parent!=null)
						grandparent.parent.right=rotateLeft(grandparent);
					else
						n=rotateLeft(grandparent);
					//swap(parent.color,grandparent.color);
					parent.color=(!parent.color);
					grandparent.color=(!grandparent.color);
					newnode=parent;
				}
			}
		}
		n.color=false;
		return n;

	}

	void inorder(Node n) {
		if(n==null)
			return;
		inorder(n.left);
		System.out.println(n.data+" "+n.color);
		inorder(n.right);
	}


	Node insert(Node n,Node newnode)
	{

		if(n==null)
			return newnode;
		
		if(newnode.data < n.data)
		{
			n.left=insert(n.left,newnode);
			n.left.parent=n;
		}
		else if(newnode.data > n.data)
		{
			n.right=insert(n.right,newnode);
			n.right.parent=n;
		}
		else
			return n;
		return n;
	}

	int max(int a,int b)
	{
		return a>b?a:b;
	}

	int heightOfRBT(Node n)
	{
		if(n==null)
			return 0;
		return 1+max(heightOfRBT(n.left),heightOfRBT(n.right));
	}

	public static void main(String args[])
	{
		RBT obj=new RBT();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of elements : ");
		int n=sc.nextInt();
		System.out.println("Enter elements : ");
		for(int i=0;i<n;i++) {
			Node p=new Node(sc.nextInt());
			obj.root=obj.insert(obj.root,p);
			obj.root=obj.checkForRules(obj.root,p);
		}
		System.out.println("Height of RBT is : "+obj.heightOfRBT(obj.root));
		System.out.println("Inorder traversal of tree : ");
		obj.inorder(obj.root);
	}
}