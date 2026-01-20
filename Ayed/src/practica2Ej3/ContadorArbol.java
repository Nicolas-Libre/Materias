package practica2Ej3;

import practica2Ej2.BinaryTree;
import java.util.List;
public class ContadorArbol {
	private BinaryTree<Integer> AE;
	
	public List<Integer> numerosPares() {
		List<Integer> lista = null;
		numerosParesRec (lista, AE);
		return lista;
	}
	
	private void numerosParesRec(List<Integer> lista, BinaryTree<Integer> aux) {
		if (aux.isEmpty()) {
			return;
		}
		
		if ((aux.getData() % 2) == 0) {
			lista.add(aux.getData());
		}
		if (aux.hasLeftChild()) {
			 numerosParesRec (lista, aux.getLeftChild());
		}
		if (aux.hasRightChild()){
			numerosParesRec(lista,aux.getRightChild());
		}
	}
	
	public void impInOrden(BinaryTree<Integer> aux) {
		if (aux.getData() != null) {
			if (aux.hasLeftChild()) {
				impInOrden (aux.getLeftChild());
			}
			System.out.println(aux.getData());
			if (aux.hasRightChild()) {
				impInOrden (aux.getRightChild());
			}
		}
	}
	public void impPostOrden (BinaryTree<Integer>aux) {
		if (aux.getData() != null) {
			if (aux.hasLeftChild()) {
				impInOrden (aux.getLeftChild());
			}
			if (aux.hasRightChild()) {
				impInOrden (aux.getRightChild());
			}
			System.out.println(aux.getData());
		}
	}
}
