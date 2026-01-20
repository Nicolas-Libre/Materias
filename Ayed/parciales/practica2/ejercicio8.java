package practica2;
import arbolBinario.BinaryTree;
public class ejercicio8 {

	
	public boolean esPrefijo (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)	{
		if (arbol1.isEmpty()) {
			return arbol2.isEmpty();
		}
		if (arbol2.isEmpty()) {
			return arbol1.isEmpty();
		}
		boolean ok = verificar (arbol1, arbol2);
		return ok;
	}
	
	
	public boolean verificar (BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		boolean ok = true;
		if (a1.getData() != a2.getData()) {
			ok = false;
		}
		else { 
			if (a1.hasLeftChild() ) {
				if (!a2.hasLeftChild()) return false;
				ok = verificar (a1.getLeftChild(), a2.getLeftChild());
			}
			if (a1.hasRightChild()) {
				if (!a2.hasRightChild()) return false;
				ok = verificar (a1.getRightChild(), a2.getRightChild());
			}
		}
		return ok;
		
	}
	
}
