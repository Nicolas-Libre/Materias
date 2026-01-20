package grafo9;
import java.util.*;
import tp5.*;
public class Parcial {
	public List<String> resolver (Graph<Objeto> ciudades, String origen, String destino, List<String> pasandoPor){
		List<String> lis = new LinkedList<String>();
		if (!ciudades.isEmpty()) {
			Vertex<Objeto> ori = null;
			Vertex<Objeto> des = null;
			Iterator<Vertex<Objeto>> it = ciudades.getVertices().iterator();
			while (it.hasNext() && ((ori == null) || (des == null))) {
				Vertex<Objeto> aux = it.next();
				if (aux.getData().getNombre().equals(origen)) {
					ori = aux;
				}
				if (aux.getData().getNombre().equals(destino)) {
					des = aux;
				}
			}
			if ((ori != null) && (des != null)) {
				dfs (ciudades, ori, des, lis, pasandoPor, new boolean [ciudades.getSize()]);
			}
		}
	}
	
	private boolean dfs (Graph<Objeto> ciudades, Vertex<Objeto> origen, Vertex<Objeto> destino, List<String> lis, List<String> pasandoPor, boolean [] marcas ) {
		boolean encontre = false;
		marcas[origen.getPosition()] = true;
		lis.add(origen.getData().getNombre());
		if (origen == destino && lis.containsAll(pasandoPor)) {
			return true;
		}
		else {
			Iterator<Edge<Objeto>> it = ciudades.getEdges(origen).iterator();
			while (it.hasNext() && !encontre) {
				Edge<Objeto> adys = it.next();
				Vertex<Objeto> des = adys.getTarget();
				int pos = des.getPosition();
				if (!marcas[pos]) {
					marcas[pos] = true;
					encontre = dfs(ciudades, des, destino, lis, pasandoPor, marcas);
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
