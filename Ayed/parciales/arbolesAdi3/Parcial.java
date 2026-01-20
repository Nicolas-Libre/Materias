package arbolesAdi3;
import arbolBinario.BinaryTree;
public class Parcial {

	public BinaryTree<SumYDif> sumAndDif (BinaryTree<Integer> arbol){
		BinaryTree<SumYDif> sumarYrestar = new BinaryTree<SumYDif>();
		if (!arbol.isEmpty()) {
			crear (arbol, sumarYrestar, arbol.getData(), arbol.getData());
		}
		return sumarYrestar;
	}
	
	private void crear (BinaryTree<Integer> arbol, BinaryTree<SumYDif> sumarYrestar, int suma, int resta) {
		SumYDif aux = new SumYDif(suma, resta);
		sumarYrestar.setData(aux);
		if (arbol.hasLeftChild()) {
			sumarYrestar.addLeftChild(new BinaryTree<SumYDif>());
			crear (arbol.getLeftChild(), sumarYrestar.getLeftChild(), suma + arbol.getLeftChild().getData(), arbol.getLeftChild().getData() - resta );
		}
		
		if (arbol.hasRightChild()) {
			sumarYrestar.addRightChild(new BinaryTree<SumYDif>());
			crear (arbol.getRightChild(), sumarYrestar.getRightChild(), suma + arbol.getRightChild().getData(), arbol.getRightChild().getData() - resta);
		}
		
	}
}
