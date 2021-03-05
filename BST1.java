
//Binary Search Tree (Search & Insertion)
import java.util.*;
public class BST1 
{
	Node root;
	class Node
	{
		int key;
		Node left,right;
		public Node(int item)
		{
			key=item;
			left=right=null;
		}
	}
	void insert(int key)
	{
		root=insertNode(root,key);
	}
	Node insertNode(Node root,int key)
	{
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		if(key>root.key)
			root.right=insertNode(root.right,key);
		else if(key<root.key)
			root.left=insertNode(root.left,key);
		return root;
	}
	void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.key+" ");
		inorder(root.right);
	}
	public static void main(String[] args) 
	{
		BST1 tree=new BST1();
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        System.out.println("The inorder traversal of BST is:");
        tree.inorder(tree.root);
	}
}
