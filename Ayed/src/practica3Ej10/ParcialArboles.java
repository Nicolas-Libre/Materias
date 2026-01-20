package practica3Ej10;
import arbolGeneral.GeneralTree;
import java.util.List;
import java.util.LinkedList;

public class ParcialArboles {

	
	
	public static List<Integer>resolver(GeneralTree<Integer>arbol){
		List<Integer> caminoActual = new LinkedList<Integer>();
		List<Integer> caminoMayor = new LinkedList<Integer>();
		int sumaMayor = 0;
		int sumaActual = 0;
		int nivel = 0;
		calcularCaminoFiltrado (caminoActual,caminoMayor, sumaMayor, sumaActual, nivel, arbol);
		return caminoMayor;
	}
	
	
	private static void calcularCaminoFiltrado (List<Integer> caminoActual,List<Integer> caminoMayor ,int sumaMayor, 
			int sumaActual, int nivel, GeneralTree<Integer>arbol){
		
		sumaActual += (arbol.getData() * nivel);
		if (arbol.getData()==1) {
			caminoActual.add(arbol.getData());
		}
		
		if (arbol.isLeaf()) {
			if (sumaActual > sumaMayor) {
				sumaMayor = sumaActual;
				caminoMayor = caminoActual;
			}
		}
		else { 
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child: children) {
				calcularCaminoFiltrado (caminoActual, caminoMayor, sumaMayor, sumaActual, nivel+1, child);
			}
		}
		if (arbol.getData()==1) {
			caminoActual.remove(caminoActual.size() - 1);
		}
			
	}
}
