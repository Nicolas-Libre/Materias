package arboles11;
import arbolBinario.BinaryTree;
import java.util.*;

public class Parcial {

	public LinkedList<Integer> resolver (BinaryTree<Integer> arbol){
		LinkedList <Integer> lista = new LinkedList<Integer>();
		if (!arbol.isEmpty()) {
			buscarNodos (arbol, lista);
		}
		return lista;
	}
	
	private void buscarNodos (BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
		if ((arbol.isLeaf()) || (arbol.hasLeftChild() && arbol.hasRightChild())) {
			lista.add(arbol.getData());
		}
		if (arbol.hasRightChild()) {
			buscarNodos (arbol.getRightChild(), lista);	
		}
		if (arbol.hasLeftChild()) {
			buscarNodos (arbol.getLeftChild(), lista);
		}
	}
	
	
}
