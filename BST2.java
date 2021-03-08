// Binary Search Tree (Delete)
import java.util.*;
public class BST2 
{
	Node root;
	class Node
	{
		int data;
		Node right,left;
		Node(int key)
		{
			data=key;
			right=left=null;
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
		if(key>root.data)
			root.right=insertNode(root.right,key);
		else if(key<root.data)
			root.left=insertNode(root.left,key);	
		return root;
	}
	void inorder(Node root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	void deleteKey(int key)
	{
		root=deleteNode(root,key);
	}
	Node deleteNode(Node root,int key)
	{
		if(root==null)
			return root;
		if(key<root.data)
			root.left=deleteNode(root.left,key);
		else if(key>root.data)
			root.right=deleteNode(root.right,key);
		else
		{
			if (root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
			
			root.data=minValue(root.right);
			root.right=deleteNode(root.right,root.data);
		}
		return root;
	}
	int minValue(Node root)
	{
		int minv=root.data;
		while(root.left!=null)
		{
			minv=root.left.data;
			root=root.left;
		}
		return minv;
	}
	public static void main(String[] args) 			
	{				
		BST2 tree=new BST2();
		tree.insert(50);
		tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        System.out.println("The inorder traversal of the tree:");
        tree.inorder(tree.root);
        System.out.println("\nDelete key: 20 ");
        tree.deleteKey(20);
        System.out.println("Modified tree: ");
        tree.inorder(tree.root);
        System.out.println("\nDelete key: 30");
        tree.deleteKey(30);
        System.out.println("Modified tree: ");
        tree.inorder(tree.root);
        System.out.println("\nDelete key: 50");
        tree.deleteKey(50);
        System.out.println("Modified tree: ");
        tree.inorder(tree.root);
        
	}
}
