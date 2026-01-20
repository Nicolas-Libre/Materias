package arbolGeneral1;
import arbolGeneral.GeneralTree;
import java.util.List;
import java.util.LinkedList;
public class ParcialArboles {
	private GeneralTree<Integer> arbolGen;
	
	
	public List <Integer> camino (int num) {
		List<Integer> caminoOfi = new LinkedList<Integer>();
		List<Integer> auxCamino = new LinkedList<Integer>();
		hacerCam (arbolGen, num, caminoOfi, auxCamino);
		return caminoOfi;
	}
	
	private void hacerCam (GeneralTree<Integer> arbolGen, int num, List<Integer> caminoOfi, List<Integer> auxCamino) {
		if (arbolGen == null || !caminoOfi.isEmpty()) {
			return;
		}
		auxCamino.add(arbolGen.getData());
		List<GeneralTree<Integer>> children = arbolGen.getChildren();
		if (children.isEmpty()) {
			caminoOfi.addAll(auxCamino);
			return;
		}
		if (children.size() < num) {
			auxCamino.remove(auxCamino.size()-1);
			return;
		}

		for (GeneralTree<Integer> child : children) {
			hacerCam (child, num, caminoOfi, auxCamino);
			if (!caminoOfi.isEmpty()) {
				return;
			}
		}
	}
	
	
}
