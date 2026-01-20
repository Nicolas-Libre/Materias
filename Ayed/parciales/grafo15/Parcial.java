package grafo15;
import java.util.*;
import tp5.*;

public class Parcial {
	public List<Objeto> menosTransbordos (Graph<String> maps, String origen){
		List<Objeto> lis = new LinkedList<Objeto>();
		if (!maps.isEmpty()) {
			Vertex<String> ori = maps.search(origen);
			if (ori != null) {
				dfs (maps, ori, lis, new boolean [maps.getSize()], 0, ori.getData());
			}
		}
		return lis;
		
		
		
	}
	private void dfs (Graph<String> maps, Vertex<String> origen, List<Objeto> lis, boolean [] marcas, int cant, String nomIni) {
		marcas[origen.getPosition()] = true;
		String nomActual = origen.getData();
		List<Edge<String>> adys = maps.getEdges(origen);
		int tamaño = adys.size();
		if (tamaño == 1 && !nomActual.equals(nomIni)) {
			Iterator <Objeto> it = lis.iterator();
			boolean encontre = false;
			while (it.hasNext() && !encontre) {
				Objeto obj = it.next();
				if (obj.getNombre().equals(nomActual)){
					encontre = true;
					if (obj.getMinTrans() > cant) {
						obj.setMinTrans(cant);
					}
				}
			}
			if (!encontre) {
				lis.add(new Objeto (nomActual, cant));
			}
			else {
				for (Edge<String> adya : adys) {
					Vertex<String> destino = adya.getTarget();
					int pos = destino.getPosition();
					if (!marcas[pos]) {
						if (tamaño > 2) {
							dfs (maps, destino, lis, marcas, cant+1, nomIni);
						}
						else {
							dfs (maps, destino, lis, marcas, cant, nomIni);
						}
					}
					
				}
			}
			marcas [origen.getPosition()] = false;
		}
	}
}
