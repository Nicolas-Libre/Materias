package arboles14;
import arbolGeneral.GeneralTree;
import java.util.*;
public class Parcial {
	
	public Integer resolver (GeneralTree<Integer> arbol) {
		if (!arbol.isEmpty()) {
			CantYNodos obj = new CantYNodos ();
			resuelve (arbol, obj);
			if ((obj.getCantTotal() % 2) == 0){
				return obj.getCantPos();
			} else return obj.getCantNeg();
		} else return 0;
		
	}
	
	private void resuelve (GeneralTree<Integer> arbol, CantYNodos obj) {
		List<GeneralTree<Integer>> lista = arbol.getChildren();
		if (lista.size()>=1) {
			resuelve (lista.get(0), obj);
		}
		obj.sumar(arbol.getData());
		for (int i=1; i <lista.size(); i++ ) {
			resuelve (lista.get(i), obj);
		}
	}
	
	
}
