package arboles18;
import arbolGeneral.GeneralTree;
import java.util.*;

public class Parcial {
	
	public LinkedList<String> resolver (int valor, GeneralTree<Integer> arbol){
		LinkedList<String> listaValida = new LinkedList<String>();
		if (!arbol.isEmpty()) {		
			int nivel = 0;
			recorrerInOrden (arbol, valor, listaValida, nivel);
		}
		return listaValida;
	}
	
	private void recorrerInOrden (GeneralTree<Integer> arbol, int valor, LinkedList<String> listaValida, int nivel) {
		List<GeneralTree<Integer>> listaHijos = arbol.getChildren();
		if (listaHijos.size() >=1) recorrerInOrden (listaHijos.get(0), valor, listaValida, nivel +1);
		if (arbol.getData()> valor) {
			listaValida.add("Valor " + arbol.getData() + "nivel " + nivel);
		}
		for (int i=1; i<listaHijos.size(); i++) {
			recorrerInOrden (listaHijos.get(i), valor, listaValida, nivel+1);
		}
			
	}
	
}
