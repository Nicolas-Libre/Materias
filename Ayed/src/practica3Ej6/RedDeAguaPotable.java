package practica3Ej6;
import arbolGeneral.GeneralTree;
import java.util.List;
import java.util.List;
import java.util.Queue;
public class RedDeAguaPotable {
	GeneralTree<Character> red = new GeneralTree<Character>();
	
	
	public double minimoCaudal (double caudal) {
		double minCau = 9999;
		recorrer (minCau, red, caudal);
	}
	
	private void recorrer (double minCau, GeneralTree<Character> red, double caudal) {
		if (red.isLeaf()) {
			minCau = caudal;
		}
		else {
			int nodos = red.getChildren().size();
			caudal = caudal / nodos;
			List<GeneralTree<Character>>children = red.getChildren();
			for (GeneralTree<Character> child : children) {
				recorrer (minCau,child,caudal);
			
			}
			
			
		}
	}
		
}
	
	
	

