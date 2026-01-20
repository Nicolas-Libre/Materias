package grafo7;
import java.util.*;
import tp5.*;
public class Parcial {
	public List<String> recorrido (Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
		List<String> lis = new LinkedList<String>();
		if (!grafo.isEmpty()) {
			Vertex<String> origen = grafo.search("Menodza");
			if (origen !=null) {
				boolean[] marcas = new boolean[grafo.getSize()];
				marcarEvitar (grafo, marcas, localidadesExceptuadas);
				dfs (grafo, origen, marcas, cantNafta, cantLocalidades, 1, lis);
			}
		}
		return lis;
	}
	
	private void marcarEvitar (Graph<String> grafo, boolean[] marcas, List<String> localidadesExceptuadas) {
		for (String e : localidadesExceptuadas) {
			Vertex<String> aux = grafo.search(e);
			if (aux != null) {
				marcas[aux.getPosition()] = true;
			}
		}
	}
	
	
	private boolean dfs (Graph<String> grafo, Vertex<String> origen, boolean[] marcas, int cantNafta, int cantLocalidades, int cantLActual, List<String> lis) {
		boolean encontre = false;
		marcas[origen.getPosition()] = true;
		lis.add(origen.getData());
		if (cantLActual == cantLocalidades) {
			return true;
		}
		else {
			Iterator<Edge<String>> it = grafo.getEdges(origen).iterator();
			while (it.hasNext() && !encontre) {
				Edge<String> adys = it.next();
				Vertex<String> destino = adys.getTarget();
				int pos = destino.getPosition();
				int naf = adys.getWeight();
				if (!marcas[pos] && naf <= cantNafta) {
					marcas[pos] = true;
					encontre = dfs (grafo, destino, marcas, cantNafta - naf, cantLocalidades, cantLActual +1, lis);
				}
			}
		}
		if (!encontre) {
			lis.remove(lis.size() -1);
		}
		marcas[origen.getPosition()] = false;
		return encontre;
	}
}
