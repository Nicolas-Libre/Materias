package arboles3;
import arbolBinario.BinaryTree;

public class Parcial {
	
	BinaryTree<Integer> ab;
	
	public ListaYCant procesar () {
		ListaYCant obj = new ListaYCant();
		if (ab != null && !ab.isEmpty()) {
			evaluar (ab, obj);
		}
		return obj;
	}
	
	private void evaluar (BinaryTree<Integer> ab, ListaYCant obj) {
		int dato = ab.getData();
		if (dato % 2 == 0) {
			obj.sumarCant();
			if (ab.hasLeftChild() && ab.hasRightChild()) {
				obj.agregar(ab);
			}
		}
		if (ab.hasLeftChild()) {
			evaluar (ab.getLeftChild(), obj);
		}
		if (ab.hasRightChild()) {
			evaluar (ab.getRightChild(), obj);
		}
		
		
	}
	
	
	
}
