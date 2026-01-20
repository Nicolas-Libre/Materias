package grafo1;

import tp5.*;
import java.util.*;

public class simParcial {

	
	public List<String> resolver (Graph <ciudad> mapa, int cantDiasVacas, String Ciudad){
		List<String> lis = new LinkedList<String>();
		if (!mapa.isEmpty()) {
			Vertex<ciudad> origen = null;
			Iterator<Vertex<ciudad>> it = mapa.getVertices().iterator(); 
			while (it.hasNext() && origen == null) {
				Vertex<ciudad> aux = it.next();
				if (aux.getData().getNombre() == Ciudad) {
					origen = aux;
				}
			}
			if (origen != null) {
				int dias = origen.getData().getCantVacas();
				if (dias <= cantDiasVacas) {
					dfs (mapa, origen, lis, cantDiasVacas - dias, new LinkedList<String>(), new boolean [mapa.getSize()]);
				}
			}
		}
		
		return lis;
	}
	
	private void dfs (Graph <ciudad> mapa, Vertex<ciudad> origen, LinkedList<String> rLis, int cantDiasVacas, LinkedList<String> actLis, boolean [] marcas) {
		marcas[origen.getPosition()] = true;
		actLis.add(origen.getData().getNombre());
		if (cantDiasVacas == 0) {
			if (rLis.size() < actLis.size()) {
				rLis.clear();
				rLis.addAll(actLis);
			}
		}
		else {
			for (Edge<ciudad> adys : mapa.getEdges(origen)) {
				Vertex<ciudad> destino = adys.getTarget();
				int j = destino.getPosition();
				int dias = destino.getData().getCantVacas();
				if (!marcas[j] && dias <= cantDiasVacas) {
					dfs(mapa, destino, rLis, cantDiasVacas-dias, actLis,marcas);
				}
			}
		}
		actLis.remove(actLis.size()-1);
		marcas[origen.getPosition()]= false;
	}
	
}
