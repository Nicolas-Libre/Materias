package arboles1;
import arbolBinario.BinaryTree;
public class Parcial {
	private BinaryTree<Integer> ab;
	
	public boolean isTwoTree (int num) {
		boolean cumple = false;
		if (ab != null && !ab.isEmpty()) {
			BinaryTree<Integer> subArbol  = buscar (ab, num);
			if (!subArbol.isEmpty()) {
				int dosIzq = -1;
				int dosDer = -1;
				if (subArbol.hasLeftChild()) {
					dosIzq = contarDosHijos (subArbol.getLeftChild());
				}
				if (subArbol.hasRightChild()) {
					dosDer = contarDosHijos (subArbol.getRightChild());
				}
				if (dosIzq == dosDer) {
					cumple = true;
				}
			}
		}
		return cumple;
		
	}
	
	
	private int contarDosHijos (BinaryTree<Integer> subA) {
		int cant = 0;
		if (subA.hasLeftChild() & subA.hasRightChild()) {
			cant ++;
		}
		if (subA.hasLeftChild()) {
			cant += contarDosHijos (subA.getLeftChild());
		}
		if (subA.hasRightChild()) {
			cant+= contarDosHijos (subA.getRightChild());
		}
		return cant;
		
	}
	
	private BinaryTree<Integer> buscar (BinaryTree<Integer> a, int num) {
		if (a.getData() == num) return a;
		BinaryTree<Integer> subA = new BinaryTree<Integer>();
		if (a.hasLeftChild()) {
			subA = buscar (a.getLeftChild(), num);
		}
		if (a.hasRightChild() && subA.isEmpty()) {
			subA = buscar(a.getRightChild(), num);
		}
		return subA;
	}
	
}
