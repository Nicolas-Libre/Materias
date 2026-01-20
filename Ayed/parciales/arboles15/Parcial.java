package arboles15;
import arbolGeneral.GeneralTree;
import java.util.*;
public class Parcial {
	
	public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol){
		LinkedList<GeneralTree<Integer>> listaArboles = new LinkedList<GeneralTree<Integer>>();
		if (!arbol.isEmpty() && !arbol.isLeaf()) {
			resuelve (arbol, listaArboles);
		}
		return listaArboles;
	}
	
	private void resuelve (GeneralTree<Integer> arbol, LinkedList<GeneralTree<Integer>> listAr) {
		List<GeneralTree<Integer>> hijos = arbol.getChildren();
		if (hijos.size()>=1) {
			resuelve (hijos.get(0), listAr);
		}
		if (!arbol.isLeaf() && ((arbol.getChildren().size() % 2) == 0)){
			listAr.add(arbol);
		}
		for (int i=1; i < hijos.size(); i++) {
			if (!hijos.get(i).isLeaf()) {
				resuelve (hijos.get(i), listAr);
			}
		}
		
		
	}
	
}
