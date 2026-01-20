package arbolGeneral3;
import arbolGeneral.GeneralTree;
import java.util.List;
import java.util.LinkedList;
public class Parcial {
	
	public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol) {
		List<GeneralTree<Integer>> retornar = new LinkedList<GeneralTree<Integer>>();
		resolverHelp (arbol, retornar);
		return retornar;
	}
	
	public void resolverHelp (GeneralTree<Integer>arbol, List<GeneralTree<Integer>> retornar) {
		if (arbol== null | arbol.isEmpty()) {
			return;
		}
		List<GeneralTree<Integer>> children = arbol.getChildren();
		resolverHelp (children.get(0), retornar);
		if (!arbol.isLeaf() && (arbol.getChildren().size()% 2 == 0)) {
			retornar.add(arbol);
		}

		
		for (int i= 1; i< children.size(); i++) {
			resolverHelp (children.get(i), retornar);
		}
	}
	
	
	
	
}
