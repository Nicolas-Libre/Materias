package practica3Ej9;
import arbolGeneral.GeneralTree;
import java.util.List;
public class ParcialArboles {


	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {

		return evaluar (arbol);
	}
	
	private static boolean evaluar (GeneralTree<Integer> arbol) {
		Integer raiz = arbol.getData();
		boolean aux= true;
		Integer min = 99999;
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for (GeneralTree<Integer> child: children) {
			if (child.getData() < min) {
				min = child.getData();
			}
		}
		if (raiz != min) {
			aux = false;
		}
		for (GeneralTree<Integer> child: children) {
			if (!evaluar(child)){
				aux = false;
			}
		}
		return aux;
	}
	
	
}
