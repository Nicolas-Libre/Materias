package practica3Ej7;
import arbolGeneral.GeneralTree;
import java.util.LinkedList;
import java.util.List;
public class Caminos {
	GeneralTree<Integer> insta = new GeneralTree<Integer>();
	
	public List<Integer> caminoAHojaMasLejana(){
		return buscarCamino (insta);
	}
	
	private List<Integer> buscarCamino (GeneralTree<Integer> insta) {
		List<Integer> caminoMasLargo = new LinkedList<Integer>();
		if (insta.isLeaf()) {
			caminoMasLargo.add(insta.getData());
			return caminoMasLargo;
		}
		List<GeneralTree<Integer>> children = insta.getChildren();
		for (GeneralTree<Integer> child: children) {
			List<Integer> caminoHijo = buscarCamino (child);
			if (caminoHijo.size() > caminoMasLargo.size()){
				caminoMasLargo = caminoHijo;
			}
		}
		caminoMasLargo.add(insta.getData());
		return caminoMasLargo;
	}
		
}
