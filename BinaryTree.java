import java.lang.*;
import java.util.*;

public class BinaryTree<E extends Comparable<E>>{

	Node root;

	private Node addValueRecursive(Node current, E value){
		if(current == null){
			return new Node(value);
		}

		E  aux = (E)current.valueOf;
		if(value.compareTo(aux)<0){
			current.left = addValueRecursive(current.left, value);
		}else if(value.compareTo(aux)>0){
			current.right = addValueRecursive(current.right, value);
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
