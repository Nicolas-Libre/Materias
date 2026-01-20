package grafo3;
import java.util.*;
import tp5.*;
public class Parcial {
	
	public String resolver (Graph <Recinto> sitios, int tiempo) {
		boolean ok = false;
		if (!sitios.isEmpty()) {
			Vertex <Recinto> origen = null;
			Iterator <Vertex<Recinto>> it = sitios.getVertices().iterator();
			while (it.hasNext() && origen == null) {
				Vertex<Recinto> aux = it.next();
				if (aux.getData().getNombre()== "Entrada") {
					origen = aux;
				}
			}
			if (origen != null) {
				int tOri = origen.getData().getTiempo();
				if (tOri <= tiempo)
					ok = dfs (sitios, origen, tiempo - tOri, sitios.getSize(), 1, new boolean[sitios.getSize()]);
			}
		}
		if (ok) {
			return "Alcanzable";
		}
		else {
			return "No Alcanzable";
		}
	}
	
	private boolean dfs (Graph<Recinto> grafo, Vertex<Recinto> origen, int tiempoEnviado, int todos, int cActual, boolean[] marcas) {
		marcas[origen.getPosition()] = true;
		boolean encontre = false;
		if (cActual == todos) {
			return true;
		}
		else {
			Iterator<Edge<Recinto>> it = grafo.getEdges(origen).iterator();
			while (it.hasNext() && !encontre) {
				Edge<Recinto> adys = it.next();
				Vertex<Recinto> destino = adys.getTarget();
				int tiempo = destino.getData().getTiempo() + adys.getWeight();
				int pos = destino.getPosition();
				if (!marcas[pos] && tiempo < tiempoEnviado) {
					encontre = dfs (grafo, destino, tiempoEnviado - tiempo, todos, cActual+1, marcas);
				}
			}
		}
		marcas[origen.getPosition()] = false;
		return encontre;
	}
	
	
}

