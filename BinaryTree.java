/**
 * Binarytree
 * @author Jimena Hernandez/21199
 * @version 08/04/2022
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de Datos
 * HDT7
 * ref: https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/tree/BinaryTree.java
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

	public void addValue(E  value){
		root = addValueRecursive(root, value);
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



	ArrayList<E> back = new ArrayList<E>();
	public ArrayList<E> inOrder(Node node){

		if(node!= null){
			inOrder(node.left);
			
			back.add((E) node.valueOf);

			inOrder(node.right);
		}
		return back;
	}

	public Node getRoot(){
		return root;
	}


}
