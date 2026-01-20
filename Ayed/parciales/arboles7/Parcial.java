package arboles7;
import java.util.*;
import arbolGeneral.GeneralTree;
public class Parcial {
	
	public LinkedList<LinkedList<Character>> caminosPares (GeneralTree<Character> arbol){
		LinkedList<LinkedList<Character>> lista = new LinkedList<LinkedList<Character>>();
		if (arbol != null && !arbol.isEmpty()) {
			encontrarCaminos (arbol, lista, new LinkedList<Character>());
		}
		return lista;
	}

	
	private void encontrarCaminos (GeneralTree<Character> arbol, LinkedList<LinkedList<Character>> list, LinkedList<Character> act) {
		act.add(arbol.getData());
		if (arbol.isLeaf()) {
			if (act.size() % 2 == 0) {
				list.add(new LinkedList<Character> (act));
			}
		}
		else {
			for (GeneralTree<Character> hijo : arbol.getChildren()) {
				encontrarCaminos (hijo, list, act);
			}
		}
		act.remove(act.size()-1);
	}
}
