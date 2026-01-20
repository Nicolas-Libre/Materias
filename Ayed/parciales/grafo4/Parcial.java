package grafo4;
import java.util.*;
import tp5.*;
public class Parcial {
	
	
	public List<Camino> resolver (Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor){
		List<Camino> lis = new LinkedList<Camino>();
		if (!sitios.isEmpty()) {
			Iterator<Vertex<String>> it = sitios.getVertices().iterator() ;
			Vertex<String> ori = null;
			Vertex<String> des = null;
			while (it.hasNext() && (ori == null || des ==null)) {
				Vertex<String> aux = it.next();
				if (aux.getData().equals(origen)) {
					ori = aux;
				}
				if (aux.getData().equals(destino)) {
					des = aux;
				}
			}
			if (ori != null && des != null) {
				boolean [] marcas = new boolean[sitios.getSize()];
				marcarEvitar (sitios, evitarPasarPor, marcas);
				dfs (sitios, ori, des, marcas, new LinkedList<String>(), lis, 0);
			}
		}
		return lis;
		
	}
	
	private void marcarEvitar (Graph<String> grafo, List<String> evitar, boolean[] marcas) {
		for (String e : evitar) {
			Vertex<String> aux = grafo.search(e);
			if (aux!= null) {
				marcas[aux.getPosition()] = true;
			}
		}
	}
	
	private void dfs (Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean [] marcas, List<String> lisActual, List<Camino> lis, int cuadras) {
		marcas[origen.getPosition()] = true;
		lisActual.add(origen.getData());
		if (origen == destino) {
			Camino cam = new Camino();
			cam.setLis(lisActual);
			cam.setCuadras(cuadras);
			lis.add(cam);
		}
		else {
			for (Edge<String> adys : grafo.getEdges(origen)) {
				Vertex<String> des = adys.getTarget();
				int pos = des.getPosition();
				if (!marcas[pos]) {
					marcas[pos] = true;
					dfs (grafo, des, destino, marcas, lisActual, lis, cuadras+adys.getWeight());
				}
				
			}
		}
		marcas[origen.getPosition()] = false;
		lisActual.remove(lisActual.size()-1);
	}
}
