package arboles12;
import arbolGeneral.GeneralTree;
public class Parcial {
	
	public int mayor (GeneralTree<Integer> ag) {
		int mayor = 0;
		if (!ag.isEmpty()) {
			mayor = buscarMayor (ag, Integer.MIN_VALUE);
		}
		return mayor;
	}
	
	
	private int buscarMayor (GeneralTree<Integer> ag, int num) {
		for (GeneralTree<Integer> hijo : ag.getChildren()) {
			num = buscarMayor (hijo, num);
		}
		if (num < ag.getData()) {
			num = ag.getData();
		}
		return num;
	}
	
}
