package grafo;
import tp5.*;
import java.util.*;
public class Parcial {

	public int resolver (Graph<Recinto> grafo, int tiempo) {
		int cant = 0;
		if (!grafo.isEmpty()) {
			Vertex<Recinto> entrada = null;
			Iterator<Vertex<Recinto>> it = grafo.getVertices().iterator();
			while (it.hasNext() && entrada ==null) {
				Vertex<Recinto> aux = it.next();
				if (aux.getData().getNombre().equals( "Entrada")) {
					entrada = aux;
				}
			}
			if (entrada != null) {
				int tiempoOri = entrada.getData().getTiempo();
				cant = dfs (grafo, tiempo - tiempoOri, entrada, 1, Integer.MIN_VALUE, new boolean[grafo.getSize()]);
			}
		}
		return cant;
		
	}
	
	private int dfs (Graph<Recinto> grafo, int tiempo, Vertex<Recinto> entrada, int cant, int max, boolean [] marcas ) {
		marcas[entrada.getPosition()] = true;
		for (Edge<Recinto> adys: grafo.getEdges(entrada) ) {
			int tCamino = adys.getWeight();
			Vertex<Recinto> destino = adys.getTarget();
			int j = destino.getPosition();
			int tTotal = tCamino + destino.getData().getTiempo();
			if (!marcas[j] && tTotal<= tiempo) {
				max = dfs (grafo, tiempo - tTotal, destino, cant+1, max, marcas);
			}
		}
		marcas[entrada.getPosition()] = false;
		max = Math.max(cant, max);
		return max;
	}
	
}
