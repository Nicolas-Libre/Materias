package practica2Ej6;
import practica2Ej2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> AE;

	
	public BinaryTree<Integer> suma (){
		BinaryTree<Integer> aux = AE;
		int suma =0;
		sumaRec (aux, AE, suma);
		return aux;
	}
	
	private void sumaRec (BinaryTree<Integer> aux, BinaryTree<Integer> AE2, int suma) {
		if (AE2 == null) {
			return;
		}
		if ((AE2.hasLeftChild()==false) && (AE2.hasRightChild() == false)) {
			aux.setData(0);
		}
		else {
			if (AE2.hasLeftChild()) {
				suma+= AE2.getLeftChild().getData();
				sumaRec (aux, AE2.getLeftChild(), suma);
			}
			if (AE2.hasRightChild()) {
				suma+= AE2.getRightChild().getData();
				sumaRec (aux, AE2.getRightChild(), suma);
			}
			aux.setData(suma);
		}
		if (aux.hasLeftChild()) {
			sumaRec(aux.getLeftChild(), AE2, suma);
		}
		if (aux.hasRightChild()) {
			sumaRec (aux.getRightChild(),AE2,suma);
		}
	}

}
