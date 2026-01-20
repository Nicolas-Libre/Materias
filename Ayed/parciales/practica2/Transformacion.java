package practica2;
import arbolBinario.BinaryTree;
import java.util.*;
public class Transformacion {
	private BinaryTree<Integer> ab;
	
	
	public BinaryTree<Integer> suma (){
		sumaPrivada (ab);
		return ab;
		
		
		
	}
	
	private int sumaPrivada (BinaryTree<Integer> arbol) {
		int sum = 0;
		if (arbol.isLeaf()) {
			sum = arbol.getData();
			arbol.setData(0);
			return sum;
		}
		if (arbol.hasLeftChild()) {
			sum += sumaPrivada (arbol.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			sum += sumaPrivada (arbol.getRightChild());
		}
		int act = ab.getData();
		ab.setData(sum);
		return sum + act;
		
	}
	
}
