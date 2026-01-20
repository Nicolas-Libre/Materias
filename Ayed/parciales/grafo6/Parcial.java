package grafo6;
import java.util.*;
import tp5.*;
public class Parcial {
	public List<String> caminoConPresupuesto (Graph<String> ciudades, String origen, String destino, int montoMax){
		List<String> lis = new LinkedList<String>();
		if (!ciudades.isEmpty()) {
			Vertex<String> ori = null;
			Vertex<String> des = null;
			Iterator<Vertex<String>> it = ciudades.getVertices().iterator();
			while (it.hasNext() && (ori == null || des == null)) {
				Vertex<String> aux = it.next();
				if (aux.getData().equals(origen)) {
					ori = aux;
				}
				if (aux.getData().equals(destino)) {
					des = aux;
				}
			}
			if ((ori != null) && (des != null)) {
				dfs (ciudades, ori, des, lis, montoMax, new boolean [ciudades.getSize()]);
			}
		}
		return lis;
	}
	private boolean dfs (Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, List<String> lis, int montoMax, boolean [] marcas) {
		lis.add(origen.getData());
		boolean encontre = false;
		marcas[origen.getPosition()] = true;
		if (origen == destino) {
			return true;
		}
		else {
			Iterator<Edge<String>> adys = grafo.getEdges(origen).iterator();
			while (adys.hasNext() && !encontre) {
				Edge<String> adya = adys.next();
				Vertex<String> des = adya.getTarget();
				int peso = adya.getWeight();
				int pos = des.getPosition();
				if (!marcas[pos] && peso<=montoMax) {
					encontre = dfs (grafo, des, destino, lis, montoMax - peso, marcas);
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
