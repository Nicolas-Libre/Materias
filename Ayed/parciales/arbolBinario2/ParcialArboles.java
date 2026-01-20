package arbolBinario2;
import arbolBinario.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	
	public Boolean isTwoTree (int num) {
		BinaryTree<Integer> auxArbol = buscar (arbol, num);
		if (auxArbol ==null || auxArbol.isEmpty()) {
			return false;
		}
		int cantHI = 0;
		int cantHD = 0;
		if (auxArbol.hasLeftChild()) {
			 cantHI = contar (auxArbol.getLeftChild());
		}
		else {
			cantHI = -1;
		}
		if (auxArbol.hasRightChild()) {
			cantHD = contar (auxArbol.getRightChild());
		}
		else {
			cantHD = -1;
		}
	}
	
	
	private BinaryTree<Integer> buscar (BinaryTree<Integer> arbol, int num) {
		if (arbol == null | arbol.isEmpty()) {
			return null;
		}
		if (arbol.getData() == num) {
			return arbol;
		}
		BinaryTree<Integer> nuevo = null;;
		if (arbol.hasLeftChild()) {
			nuevo = buscar (arbol.getLeftChild(), num);
			return nuevo;
		}
		if (arbol.hasRightChild()) {
			nuevo = buscar(arbol.getRightChild(), num);
			return nuevo;
		}
		return nuevo;
	}
	
	private int contar (BinaryTree<Integer> auxArbol) {
		int cuenta =0;
		if (auxArbol.hasLeftChild() && auxArbol.hasRightChild()) {
			cuenta = 1;
		}
		if (auxArbol.hasLeftChild()) {
			cuenta += contar (auxArbol.getLeftChild());
		}
		if (auxArbol.hasRightChild()) {
			cuenta += contar (auxArbol.getRightChild());
		}
		return cuenta;
	}
		
}

