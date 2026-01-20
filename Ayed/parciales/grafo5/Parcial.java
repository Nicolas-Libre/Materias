package grafo5;
import java.util.*;
import tp5.*;
public class Parcial {
	
	public List<String> estadios (Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKM){
		List<String> lis = new LinkedList<String>();
		if (!mapaEstadios.isEmpty()) {
			Vertex<Estadio> origen = null;
			Iterator<Vertex<Estadio>> it = mapaEstadios.getVertices().iterator();
			while (it.hasNext() && origen== null) {
				Vertex<Estadio> aux = it.next();
				if (aux.getData().getNombre().equals(estadioOrigen)) {
					origen = aux;
				}
			}
			if (origen != null) {
				dfs (mapaEstadios, origen, cantKM, lis, new LinkedList<String>(), new boolean[mapaEstadios.getSize()] );
			}
		}
		return lis;
	}
	
	private void dfs (Graph<Estadio> mapaEstadios, Vertex<Estadio> origen, int cantKM, List<String> lisMax, List<String> lisActual, boolean[] marcas) {
		marcas[origen.getPosition()] = true;
		lisActual.add(origen.getData().getNombre());
		if (lisActual.size() > lisMax.size()) {
			lisMax.clear();
			lisMax.addAll(lisActual);
		}
		for (Edge<Estadio> adys : mapaEstadios.getEdges(origen)) {
			Vertex<Estadio> destino = adys.getTarget();
			int pos = destino.getPosition();
			int peso = adys.getWeight();
			if (!marcas[pos] && peso < cantKM) {
				dfs (mapaEstadios, destino, cantKM - peso, lisMax, lisActual, marcas);
			}
		}
		marcas[origen.getPosition()] = false;
		lisActual.remove(lisActual.size()-1);
	}
	
	
}
