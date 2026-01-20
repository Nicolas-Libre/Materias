package arboles21;
import arbolGeneral.GeneralTree;
import java.util.*;
import aCola.cola;
public class Parcial {

	private GeneralTree<Integer> ag;
	
	
	public List<Integer> nivel (int num){
		List<Integer> primerCamino = new LinkedList<Integer>();
		if (ag != null && !ag.isEmpty()) {
			recorrerNiveles (ag, num, primerCamino);
		}
		return primerCamino;
		
		
	}
	
	private void recorrerNiveles (GeneralTree<Integer> ag, int num, List<Integer> primerCamino) {
		cola<GeneralTree<Integer>> queue = new cola<GeneralTree<Integer>>();
		GeneralTree<Integer> aux = new GeneralTree<Integer>();
		boolean encontre = false;
		boolean cumpleHijos = false;
		queue.enqueue(ag);
		queue.enqueue(null);
		
		while (!queue.isEmpty() && !encontre) {
			 aux = queue.dequeue();
			if (aux != null) {
				primerCamino.add(aux.getData());
				List<GeneralTree<Integer>> hijos = aux.getChildren();
				if (hijos.size() == num) cumpleHijos = true;
				for (GeneralTree<Integer> hijo : aux.getChildren()) {
					queue.enqueue(hijo);
				}
			}
			else {
				if (!queue.isEmpty()) {
					queue.enqueue(null);
				}
				if (cumpleHijos) {
					encontre = true;
				}
				else {
					primerCamino.clear();
					cumpleHijos = false;
				}
			
			}
			
		}
		
		
		
	}
	
}
