package practica3Ej4;
import java.util.List;
import java.util.Queue;

import arbolGeneral.GeneralTree;

public class MayorPromedio {
	
	
	public double mayorProm (GeneralTree<Integer> a) {
		double maxProm = 0;
		NivelesPrivado (a, maxProm);
		return maxProm;
		
	}
	
	private void NivelesPrivado (GeneralTree <Integer>a, double maxProm) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux_tree = new GeneralTree<Integer>(); 
		double nivelProm = a.getData();
		maxProm = nivelProm;
		int cantNodos = 0;
		Integer suma = 0;
		queue.enqueue(a);
		while (!queue.isEmpty()) {
			aux_tree = queue.dequeue;
			List<GeneralTree<Integer>> children = aux_tree.getChildren();
			for (GeneralTree<Integer> child : children) {
				queue.enqueue (child);
				cantNodos++;
				suma+= child.getData();
			}	
			nivelProm = suma / cantNodos;
			if (nivelProm > maxProm) {
				maxProm = nivelProm;
			}
			nivelProm =0;
			suma =0;
		}
	}
}
