package grafo_de_Nuevo;
import java.util.*;
import tp5.*;
public class Parcial {
	public int resolver (Graph<Recinto> sitios, int tiempo) {
		int visitas = 0;
		if (!sitios.isEmpty()) {
			Iterator<Vertex<Recinto>> it = sitios.getVertices().iterator();
			Vertex<Recinto> origen = null;
			while (it.hasNext() && origen == null) {
				Vertex<Recinto> aux = it.next();
				if (aux.getData().getNombre().equals("Entrada")) {
					origen = aux;
				}
			}
			if (origen != null) {
				visitas ++;
				int peso = origen.getData().getTiempo();
				visitas = dfs (sitios, origen, 1, Integer.MIN_VALUE, tiempo - peso, new boolean [sitios.getSize()] );
			}
		}
		return visitas;
	}
	
	
	private int dfs (Graph<Recinto> sitios, Vertex<Recinto> origen, int visitasMax, int visitasAct, int tiempo, boolean[] marcas) {
		marcas[origen.getPosition()] = true;
		for (Edge<Recinto> adys : sitios.getEdges(origen)) {
			Vertex<Recinto> destino = adys.getTarget();
			int pos = destino.getPosition();
			int peso = adys.getWeight() + destino.getData().getTiempo();
			if (!marcas[pos] && peso <= tiempo) {
				visitasMax = dfs (sitios, destino, visitasMax, visitasAct+1, tiempo - peso, marcas);
			}
		}
		marcas[origen.getPosition()] = false;
		visitasMax = Math.max(visitasAct, visitasMax);
		return visitasMax;
	}
}
