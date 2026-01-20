package arboles17;
import arbolGeneral.GeneralTree;
import java.util.*;
public class Parcial {
	
	public Integer resolver (GeneralTree<Integer> arbol, Integer min, Integer max){
		if (!arbol.isEmpty()) {
			SumaYCant devolver = new SumaYCant();
			inOrden (arbol, min, max, devolver);
			return devolver.getSuma() / devolver.getCant();
		} else return 0;
	}
	
	
	private void inOrden (GeneralTree<Integer> ag, Integer min, Integer max, SumaYCant devolver) {
		List<GeneralTree<Integer>> listaHijos = ag.getChildren();
		if (listaHijos.size()>=1) {
			inOrden (listaHijos.get(0), min, max, devolver);
		}
		if ((ag.getData() >= min) && (ag.getData()<= max)) {
			devolver.sumarCant();
			devolver.sumarSuma(ag.getData());
		}
		for (int i= 1; i <listaHijos.size(); i++) {
			inOrden (listaHijos.get(i), min, max, devolver);
		}
	}
}
