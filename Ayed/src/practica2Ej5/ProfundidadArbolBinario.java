package practica2Ej5;

import practica2Ej2.BinaryTree;

public class ProfundidadArbolBinario {
	private BinaryTree<Integer> AE;
	
	
	public int sumaElementosProfundidad (int profundidad) {
		Integer sum = 0;
		sumElemProRec (AE, 0, profundidad, sum);
		return sum;
	}
	
	private void sumElemProRec (BinaryTree <Integer> aux, int NivelActual, int pro, Integer sum) {
		if (aux.getData() == null) {
			return;
		}
		if (NivelActual == pro) {
			sum = sum + aux.getData();
		}
		if (aux.hasLeftChild()) {
			sumElemProRec (aux.getLeftChild(), NivelActual+1, pro, sum);
		}
		if (aux.hasRightChild()) {
			sumElemProRec (aux.getRightChild(), NivelActual+1, pro, sum);
		}
	}
	
	
	
}
