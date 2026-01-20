package practica2Ej7;

import practica2Ej2.BinaryTree;

public class ParcialArboles {
	BinaryTree<Integer> numeroUni;

	public boolean isLeftTree (int num) {
		int izq =0;
		int der =0;
		boolean retorno =devolverValor (num, numeroUni, izq, der);
		return retorno;
	}

	private boolean devolverValor (int num, BinaryTree<Integer> arbol, int izq, int der) {
		if (arbol.getData() == null) {
			return false;
		}
		if (arbol.getData() == num) {
			contarTodo (arbol, izq, der);
		}
		else {
			if (arbol.hasLeftChild()== true) {
				 devolverValor (num, arbol.getLeftChild(), izq, der);
			}
			if (arbol.hasRightChild() == true) {
				devolverValor (num, arbol.getRightChild(),izq, der);
			}
		}
		if (izq > der) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void contarTodo (BinaryTree<Integer> arbol, int izq, int der) {
		if (arbol.hasLeftChild() == true) {
			if ((arbol.getLeftChild().hasLeftChild()) && (arbol.getLeftChild().hasRightChild() == false)) {
				izq = izq +1;
			}
			if ((arbol.getLeftChild().hasRightChild()) && (arbol.getLeftChild().hasLeftChild() == false)) {
				izq = izq+1;
			}
			contarTodo (arbol.getLeftChild(), izq, der);
		}
		if (arbol.hasRightChild() == true) {
			if (arbol.getRightChild().hasLeftChild()&& arbol.getRightChild().hasRightChild()== false) {
				der = der +1;
			}
			if (arbol.getRightChild().hasRightChild()&& arbol.getRightChild().hasLeftChild()== false) {
				der = der +1;
			}
			contarTodo (arbol.getRightChild(), izq, der);
		}
	}

}
