package grafo14;
import java.util.*;
import aCola.*;
import tp5.*;
public class Parcial {
	public List<Objeto> invitacionMasterClass (Graph<String> red, String usuario, int distancia, int limite){
		List<Objeto> lis = new LinkedList<Objeto>();
		if (!red.isEmpty()) {
			Vertex<String> origen = red.search(usuario);
			if (origen != null) {
				bfs (red, origen, distancia, limite, lis);
			}
		}
		return lis;
	}
	
	private void bfs (Graph<String> red, Vertex<String> origen, int distancia, int limite, List<Objeto> lis) {
		int grado = 1;
		int cantUsu = 0;
		boolean [] marcas = new boolean [red.getSize()];
		cola<Vertex<String>> cola = new cola<Vertex<String>>();
		cola.enqueue(origen);
		cola.enqueue(null);
		while (!cola.isEmpty() && grado <= distancia && cantUsu < limite) {
			Vertex<String> aux = cola.dequeue();
			if (aux != null) {
				Iterator<Edge<String>> it = red.getEdges(aux).iterator();
				while (it.hasNext() && cantUsu < limite) {
					Vertex<String> destino = it.next().getTarget();
					int pos = destino.getPosition();
					Objeto obj = new Objeto();
					obj.setDistancia(grado);
					obj.setUsuario(destino.getData());
					if (!marcas[pos]) {
						marcas[pos] = true;
						cola.enqueue(destino);
						lis.add(obj);
						cantUsu++;
					}
				}
			}
			else {
				if (!cola.isEmpty()) {
					cola.enqueue(null);
					grado++;
				}
				
			}
		}
	}
	
}
