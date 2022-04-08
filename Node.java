/**
 * Node
 * @author Jimena Hernandez/21199
 * @version 08/04/2022
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de Datos
 * HDT7
 */
import java.lang.*;

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
