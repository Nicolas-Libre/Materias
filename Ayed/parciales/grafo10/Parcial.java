package grafo10;
import java.util.*;
import tp5.*;


public class Parcial {

	public List<String> resolver (Graph<Ciudad> grafo, String origen, String destino){
		List<String> lis = new LinkedList<String>();
		if (!grafo.isEmpty()) {
			Vertex<Ciudad> ori = null;
			Vertex <Ciudad> des = null;
			Iterator<Vertex<Ciudad>> it = grafo.getVertices().iterator();
			if (it.hasNext() && (ori== null || des== null)) {
				Vertex<Ciudad> aux = it.next();
				if (aux.getData().getNombre() == origen) {
					ori = aux;
				}
				if (aux.getData().getNombre()== destino) {
					des = aux;
				}
			}
			if (ori != null && des != null) {
				dfs (grafo, ori, des, lis, new boolean [grafo.getSize()] );
			}
		}
		
		return lis;
	}
	
	private boolean dfs (Graph<Ciudad> grafo, Vertex<Ciudad> ori, Vertex<Ciudad> des, List<String> lis, boolean[] marcas) {
		marcas[ori.getPosition()] = true;
		boolean encontre = false;
		lis.add(ori.getData().getNombre());
		if (ori == des) {
			return true;
		}
		else {
				Iterator<Edge<Ciudad>> adys = grafo.getEdges(ori).iterator();
				while (adys.hasNext() && !encontre) {
					Vertex<Ciudad> destino = adys.next().getTarget();
					int j = destino.getPosition();
					if (!marcas[j] && destino.getData().getFase() != 1 ) {
						encontre = dfs (grafo, destino, des, lis, marcas);
				}
				}
			}
		}
		if (!encontre) {
			lis.remove(lis.size() -1);
		}
		marcas[ori.getPosition()] = false;
		return encontre;
	}
	
	
	
	
}
