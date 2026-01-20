package grafo8;
import java.util.*;
import tp5.*;
public class Parcial {
	public List<String> caminoConPresupuesto (Graph<String> ciudades, String origen, String destino, int montoMinimo){
		List<String> lis = new LinkedList<String>();
		if (!ciudades.isEmpty()) {
			Vertex<String> ori = ciudades.search(origen);
			Vertex<String> des = ciudades.search(destino);
			if ((ori != null) && (des != null)) {
				dfs (ciudades, ori, des, lis, montoMinimo, 0, new boolean [ciudades.getSize()]);
			}
		}
		return lis;
	}
	
	private boolean dfs (Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, List<String> lis, int montoMin, int montoActual, boolean[] marcas) {
		boolean encontre = false;
		lis.add(origen.getData());
		marcas[origen.getPosition()] = true;
		if ((origen == destino) && (montoActual > montoMin)) {
			return true;
		}
		else {
			Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
			while (it.hasNext() && !encontre) {
				Edge<String> adys = it.next();
				Vertex<String> des = adys.getTarget();
				int pos = des.getPosition();
				int peso = adys.getWeight();
				if (!marcas[pos]) {
					encontre = dfs (grafo, des, destino, lis, montoMin, montoActual + peso, marcas);
				}
			}
		}
		if (!encontre) {
			lis.remove(lis.size()-1);
		}
		marcas[origen.getPosition()] = false;
		return encontre;
	}
	
}
