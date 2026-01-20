package grafo14_de_Nuevo;
import java.util.*;
import tp5.*;
import aCola.*;
public class Parcial {
	public List<Objeto> invitacionMasterClass (Graph<String> red, String usuario, int distancia, int limite){
		List<Objeto> lis = new LinkedList<Objeto>();
		if (!red.isEmpty()) {
			Vertex<String> origen = null;
			Iterator<Vertex<String>> it = red.getVertices().iterator();
			while (it.hasNext() && origen == null) {
				Vertex<String> aux = it.next();
				if (aux.getData().equals(usuario)) {
					origen = aux;
				}
			}
			if (origen != null) {
				bfs (red, origen, distancia, limite,lis);
			}
		}
	}
	
	private void bfs (Graph<String> grafo, Vertex<String> origen, int distancia, int limite, List<Objeto> lis) {
		boolean [] marcas = new boolean [grafo.getSize()];
		int cant = 0;
		int dist = 1;
		Objeto obj = new Objeto();
		marcas[origen.getPosition()] = true;
		cola<Vertex<String>> queue = new cola<Vertex<String>>();
		queue.enqueue(origen);
		queue.enqueue(null);
		while (!queue.isEmpty() && cant < limite && dist <= distancia) {
			Vertex<String> aux = queue.dequeue();
			if (aux != null) {
				Iterator<Edge<String>> it = grafo.getEdges(aux).iterator();
				while (it.hasNext() && cant < limite) {
					Edge<String> adys = it.next();
					Vertex<String> destino = adys.getTarget();
					int pos = destino.getPosition();
					if (!marcas[pos])
						marcas[pos] = true;
						queue.enqueue(destino);
						obj.setDist(dist);
						obj.setNombre(destino.getData());
						lis.add(obj);
						cant++;
				}
			}
			else {
				if (!queue.isEmpty()) {
					dist++;
					queue.enqueue(null);
				}
			}
		}
	}
}
