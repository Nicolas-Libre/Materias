package grafo13;
import java.util.*;
import tp5.*;
import aCola.*;
public class Parcial {
	
	public Objeto nivelPopularidad (Graph <String> red, String usuario, int distancia, int umbral) {
		Objeto ret = null;
		if (!red.isEmpty()) {
			Vertex<String> origen = red.search(usuario);
			if (origen != null) {
				ret = new Objeto();
				bfs (red, origen, distancia, ret);
				if (ret.getCantUsuario() >= umbral) {
					ret.setPopular(true);
				}
			}
		}
		return ret;
	}
	
	private void bfs (Graph <String> red, Vertex<String> origen, int distancia, Objeto ret) {
		int cant = 0;
		int dist = 0;
		cola<Vertex<String>> queue = new cola<Vertex<String>>();
		boolean [] marcas = new boolean [red.getSize()];
		marcas[origen.getPosition()] = true;
		queue.enqueue(origen);
		queue.enqueue(null);
		while (!queue.isEmpty() && dist < distancia) {
			Vertex<String> aux = queue.dequeue();
			if (aux != null) {
				for (Edge<String> adys : red.getEdges(aux)) {
					Vertex<String> destino = adys.getTarget();
					int pos = destino.getPosition();
					if (!marcas[pos]) {
						marcas[pos] = true;
						if (dist + 1 == distancia) {
							cant++;
						}
						else {
							queue.enqueue(aux);
						}
					}
				}
			}
			else {
				if (!queue.isEmpty()) {
					dist++;
					queue.enqueue(null);
				}
			}
		}
		ret.setCantUsuario(cant);
		
	}
	
}
