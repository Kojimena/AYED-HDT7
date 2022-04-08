/**
 * Binarytree
 * @author Jimena Hernandez/21199
 * @version 08/04/2022
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de Datos
 * HDT7
 * referencias : https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
 *               https://github.com/jnethery/CS2/blob/master/Generic%20Binary%20Search%20Tree/GenericBST.java
 */
import java.lang.*;
import java.util.*;

public class BinaryTree<E extends Comparable<E>>{

	Node root;

	private Node addValueRecursive(Node current, E valueOf){
		if(current == null){
			return new Node(valueOf);
		}

		E  aux = (E)current.valueOf;
		if(valueOf.compareTo(aux)<0){
			current.left = addValueRecursive(current.left, valueOf);
		}else if(valueOf.compareTo(aux)>0){
			current.right = addValueRecursive(current.right, valueOf);
		}else{
			return current;
		}

		return current;
	}

	public void addValue(E  valueOf){
		root = addValueRecursive(root, valueOf);
	}


	private boolean containsRecursive(Node current, E  valueOf){
		if(current == null){
			return false;
		}

		if(valueOf == current.valueOf){
			return true;
		}
		E aux = (E)current.valueOf;
		if(valueOf.compareTo(aux)<0){
			return containsRecursive(current.left, valueOf);
		}
		else{
			return containsRecursive(current.right, valueOf);
		}
	}

	public boolean containsNode(E  valueOf){
		return containsRecursive(root, valueOf);
	}

    public boolean isEmpty() {
        return root == null;
    }

	ArrayList<E> back = new ArrayList<E>();
	public ArrayList<E> inOrder(Node node){

		if(node!= null){
			inOrder(node.left);
			
			back.add((E) node.valueOf);
			//System.out.println(" "+ node.valueOf.toString());
			inOrder(node.right);
		}
		return back;
	}

	public Node getRoot(){
		return root;
	}

    /**
	 * Removes a node from the binary search tree
	 * @param data data of type T that implements the Comparable interface
	 * @return void
	 */
	public void delete(E valueOf)
	{
		root = delete(root, valueOf);
	}

    private Node<E> delete(Node<E> root, E valueOf)
	{
		// if the root node is null, then either there's nothing to delete or no more traversal is necessary
		if (root == null)
		{
			return null;
		}
		// if the value of the data being searched for is less than the value of the current root node, then 
		// traverse to the left node of the current root, setting the current left node to whatever gets returned
		// from the delete method 
		else if (valueOf.compareTo(root.valueOf) < 0 )
		{
			root.left = delete(root.left, valueOf);
		}
		// if the value of the data being searched for is greater than the value of the current root node, then 
		// traverse to the right node of the current root, setting the current right node to whatever gets returned
		// from the delete method
		else if (valueOf.compareTo(root.valueOf) > 0)
		{
			root.right = delete(root.right, valueOf);
		}
		// this else statement means that the data being searched for is equal to the current root, meaning that
		// we've found the node we wish to delete
		else
		{
			// if the node has no children, then return a value of null
			if (root.left == null && root.right == null)
			{
				return null;
			}
			// if the node has a left child, but no right child, then return the left child
			else if (root.right == null)
			{
				return root.left;
			}
			// if the node has a right child, but no left child, then return the right child
			else if (root.left == null)
			{
				return root.right;
			}
			// if the node has two children, then set the node's data to be the largest element
			// in the left sub-tree of the node, and then set the left child's data to be equal to
			// whatever data is returned when deleting the new root data from the left sub-tree
			// (i.e., the data that is currently set in the left child)
			else
			{
				root.valueOf = (E) findMax(root.left);
				root.left = delete(root.left, root.valueOf);
			}
		}

		return root;
	}

    // This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is non-empty.
	private E findMax(Node<E> root)
	{
		// simply continue traversing to the right until you can't go no mo', and then you've found
		// the largest element 
		while (root.right != null)
		{
			root = root.right;
		}

		return root.valueOf;
	}


}