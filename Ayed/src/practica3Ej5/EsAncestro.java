package practica3Ej5;
import arbolGeneral.GeneralTree;
import java.util.List;
public class EsAncestro {

	
	
	
	
	public boolean esAncestro (Integer a, Integer b, GeneralTree<Integer> arbol) {
		boolean encontre1 = false;
		boolean encontre2=false;
		int verdad = 0;
		verificar (a,b,encontre1,encontre2, verdad, arbol);
		if (verdad== -1 || verdad== 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	private void verificar (Integer a, Integer b, boolean encontre1, boolean encontre2, int verdad, GeneralTree<Integer> arbol) {
		if (!arbol.isEmpty()) {
			if  (arbol.getData() == a) {
				encontre1=true;
			}
			else {
				if (arbol.getData()== b) {
					encontre2 = true;
				}
			}
			if (encontre1== false && encontre2== true) {
				verdad = -1;
			}
			if (encontre1 = true && encontre2 == true) {
				verdad =1;
			}
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child : children) {
				verificar (a,b,encontre1,encontre2,verdad,child);
				if ((verdad ==1) || (verdad==-1)){
					break;
				}
			}
		}
		
		
		
	}
}
