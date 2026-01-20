package grafo11;
import java.util.*;
import tp5.*;
public class Parcial {

	public List<String> resolver (Graph<calle> grafo){
		List<String> camino = new LinkedList<String>();
		if (!grafo.isEmpty()) {
			Vertex<calle> casa = null;
			Vertex<calle> muni = null;
			Iterator<Vertex<calle>> it = grafo.getVertices().iterator();
			if (it.hasNext() && ((casa == null) || (muni == null))) {
				Vertex<calle> aux = it.next();
				if (aux.getData().getNombre()== "Casa del Intendente") {
					casa = aux;
				}
				else {
					if (aux.getData().getNombre()== "Municipalidad") {
						muni = aux;
					}
				}
			}
			if ((casa != null) && (muni != null)) {
				dfs (grafo, casa, muni, camino, new boolean[grafo.getSize()]);
			}
		}
		return camino;
		

	}
	private boolean dfs (Graph<calle> grafo, Vertex<calle> casa, Vertex<calle> muni, List<String> camino, boolean[] marcas) {
		marcas[casa.getPosition()] = true;
		camino.add(casa.getData().getNombre());
		boolean encontre = false;
		if (casa == muni) {
			return true;
		}
		else {
			Iterator<Edge<calle>> adys = grafo.getEdges(casa).iterator();
			while (adys.hasNext() && !encontre) {
				Vertex<calle> destino = adys.next().getTarget();
				int mafia = adys.next().getWeight();
				if (!marcas[destino.getPosition()] && mafia != 1 && !destino.getData().isMafiosa()){
					encontre = dfs (grafo, destino, muni, camino, marcas);
				}
			}
		}
		if (!encontre) {
			camino.remove(camino.size()-1);
		}
		marcas[casa.getPosition()] = false;
		return encontre;
	}
	
	
	
	
}
