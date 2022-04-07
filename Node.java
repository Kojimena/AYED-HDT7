public class Node<E>{
	E valueOf;
	Node left;
	Node right;

	Node(E valueOf){
		this.valueOf = valueOf;
		right = null;
		left = null;
	}
}
