package arboles20;
import arbolGeneral.GeneralTree;
import java.util.*;
public class Parcial {
	private GeneralTree<Integer> ag;
	
	
	public LinkedList<Integer> resolver (){
		LinkedList<Integer> frontera = new LinkedList<Integer>();
		if (ag != null && !ag.isEmpty()) {
			hacerFrontera (ag, frontera);
		}
		
		return frontera;
	}
	
	private void hacerFrontera (GeneralTree<Integer> ag, LinkedList<Integer> frontera) {
		if (ag.isLeaf()) {
			if (ag.getData() % 2 == 0) {
				frontera.add(ag.getData());
			}
		}
		else {
			for (GeneralTree<Integer> hijo : ag.getChildren()) {
				hacerFrontera (hijo, frontera);
			}
		}
		
	}
}
