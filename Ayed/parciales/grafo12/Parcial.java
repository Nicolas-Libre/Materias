package grafo12;
import java.util.*;
import tp5.*;
public class Parcial {
	
	public int resolver (Graph<Ciudad> ciudades, String origen, String destino, int maxControles) {
		int max = 0;
		if (!ciudades.isEmpty()) {
			Vertex<Ciudad> ori = null;
			Vertex<Ciudad> des = null;
			Iterator<Vertex<Ciudad>> it = ciudades.getVertices().iterator();
			while (it.hasNext() && ((ori == null) || (des == null))) {
				Vertex<Ciudad> aux = it.next();
				if (aux.getData().getNombre() == origen) {
					ori = aux;
				}
				if (aux.getData().getNombre() == destino) {
					des = aux;
				}
			}
			if ((ori != null) && (des != null)) {
				max = dfs (ciudades, ori, des, new boolean [ciudades.getSize()], Integer.MIN_VALUE, ori.getData().getDiasTrans(), maxControles);
			}
		}
		return max;	
	}
	
	
	private int dfs (Graph<Ciudad> grafo, Vertex<Ciudad> ori, Vertex<Ciudad> des, boolean [] marcas, int totTiempo, int max, int maxControles) {
		marcas[ori.getPosition()] = true;
		if (ori == des) {
			if (totTiempo > max) {
				max = totTiempo;
			}
		}
		else {
			for (Edge<Ciudad> adys: grafo.getEdges(ori)) {
				Vertex<Ciudad> destino = adys.getTarget();
				int j = destino.getPosition();
				if (!marcas[j] && adys.getWeight() <= maxControles) {
					max = dfs (grafo, destino, des, marcas, totTiempo + destino.getData().getDiasTrans(), max, maxControles);
				}
			}
		}
		marcas[ori.getPosition()] = false;
		return max;
	}
	
}
