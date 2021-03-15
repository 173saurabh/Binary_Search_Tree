
//Inorder predecessor and successor for a given key in BST
import java.util.*;
public class BST4 
{
	static Node suc,pre;
	static class Node
	{
		int data;
		Node left,right;
		Node(int key)
		{
			data=key;
			right=left=null;
		}
	}
	static Node inorder(Node root,int key)
	{
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		if(key<root.data)
			root.left=inorder(root.left,key);
		else if(key>root.data)
			root.right=inorder(root.right,key);
		return root;
	}
	static void findPreSuc(Node root,int key)
	{
		if(root==null)
			return;
		if(root.data==key)
		{
			if(root.left!=null)
			{
				Node temp=root.left;
				while(temp.right!=null)
					temp=temp.right;
				pre=temp;
			}
			if(root.right!=null)
			{
				Node temp=root.right;
				while(temp.left!=null)
					temp=temp.left;
				suc=temp;
			}
			return;
		}
		else if(root.data>key)
		{
			suc=root;
			findPreSuc(root.left,key);
		}
		else
		{
			pre=root;
			findPreSuc(root.right,key);
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		Node root=new Node(50);
		inorder(root,20);
		inorder(root,30);
		inorder(root,40);
		inorder(root,60);
		inorder(root,70);
		inorder(root,80);
		findPreSuc(root,n);
		if (pre != null)
	        System.out.println("Predecessor is " + pre.data);
	    else
	        System.out.println("No Predecessor");
	 
	    if (suc != null)
	        System.out.println("Successor is " + suc.data);
	    else
	        System.out.println("No Successor");
			
	}
}
