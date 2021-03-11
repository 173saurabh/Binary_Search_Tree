//Find the node with minimum value in a Binary Search Tree
import java.util.*;
public class BST3 
{
	static class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			data=d;
			left=right=null;
		}
	}
	Node insert(Node root,int key)
	{
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		if(key>root.data)
			root.right=insert(root.right,key);
		else if(key<root.data)
			root.left=insert(root.left,key);
		return root;
	}
	int minValue(Node root)
	{
		Node current=root;
		while(current.left!=null)
		{
			current=current.left;
		}
		return current.data;
	}
	public static void main(String[] args) 
	{
		BST3 tree=new BST3();
		Node root=null;
		root = tree.insert(root, 4); 
        tree.insert(root, 2); 
        tree.insert(root, 1); 
        tree.insert(root, 3); 
        tree.insert(root, 6); 
        tree.insert(root, 5); 
        
        System.out.println("The minValue of the BST is "+tree.minValue(root));
	}
}
