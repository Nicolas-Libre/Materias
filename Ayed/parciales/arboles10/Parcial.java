package arboles10;
import java.util.*;
import arbolGeneral.GeneralTree;
public class Parcial {
	
	public LinkedList<Integer> caminoHojaMasLejana (GeneralTree<Integer> ag){
		LinkedList<Integer> lisMax = new LinkedList<Integer>();
		if (ag != null && !ag.isEmpty()) {
			buscarCamino (ag, lisMax, new LinkedList<Integer>());
		}
		return lisMax;
	}

	
	
	private void buscarCamino (GeneralTree<Integer> ag, LinkedList<Integer> lisMax, LinkedList<Integer> camActual) {
		camActual.add(ag.getData());
		if (ag.isLeaf() && camActual.size()> lisMax.size()) {
			lisMax.clear();
			lisMax.addAll(camActual);
		}
		else {
			for (GeneralTree<Integer> hijo : ag.getChildren()) {
				buscarCamino (hijo, lisMax, camActual);
			}
		}
		camActual.remove(camActual.size() -1);
	}
}
