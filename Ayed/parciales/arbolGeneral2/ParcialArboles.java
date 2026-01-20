package arbolGeneral2;
import arbolGeneral.GeneralTree;
import java.util.List;
import java.util.LinkedList;
import aCola.Queue;
public class ParcialArboles {
	private GeneralTree<Integer> arbolGen;
	
	public List<Integer> nivel (int num) {
		return calcularEnNivel (arbolGen, num);
	}
	
	private List<Integer> calcularEnNivel (GeneralTree<Integer>arbolGen, int num) {
		List<Integer> camino = new LinkedList<Integer>();
		if (arbolGen == null) {
			return camino;
		}
		GeneralTree<Integer> auxArbol;
		
		List<Integer> caminoActual = new LinkedList<Integer>();
		
		Queue <GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(arbolGen);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			auxArbol = queue.dequeue();
			if (auxArbol == null) {
				if (caminoActual.isEmpty()){
					break;
				}
				boolean cumplen = true;
				for (GeneralTree<Integer> auxiliar : caminoActual) {
					if (auxiliar.hasChildren())
						if (auxiliar.getChildren().size() < num) {
							return new LinkedList<Integer>();;
						}
				}
				if (cumplen ==true) {
					for (GeneralTree<Integer> aux : caminoActual) {
						camino.add(aux.getData());
					}
					return camino;
				}
				if (!queue.isEmpty()) {
					queue.enqueue(null);
				}
			}
			else {
				caminoActual.add(auxArbol.getData());
				List<GeneralTree<Integer>> children = auxArbol.getChildren();
				for (GeneralTree<Integer> child : children) {

					queue.enqueue(child);
				}
				caminoActual.clear();
			}	
		}
		return camino;
	}
	
	
}
