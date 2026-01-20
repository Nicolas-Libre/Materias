package arboles16;
import arbolGeneral.GeneralTree;
import aCola.cola;
public class Parcial {
	
	public int resolver (GeneralTree<Integer>arbol) {
		if (!arbol.isEmpty()) {
			int producto;
			producto = recorrerHojas (arbol);
			return producto;
		} else return 0;
	}
	
	private int recorrerHojas (GeneralTree<Integer> ag) {
		cola<GeneralTree<Integer>> queue = new cola<GeneralTree<Integer>>();
		GeneralTree<Integer> aux = new GeneralTree<Integer>();
		queue.enqueue(ag);
		queue.enqueue(null);
		int producto = 1;
		while (!queue.isEmpty()) {
			aux = queue.dequeue();
			if (aux != null) {
				if (aux.isLeaf()) {
					producto *= aux.getData();
				}
				for (GeneralTree<Integer> hijo : aux.getChildren()) {
					queue.enqueue(hijo);
				}
			}
			else {
				if (!queue.isEmpty()) {
					queue.enqueue(null);
					producto = 1;
				}
			}
		}
		return producto;
		
		
	}
	
}
