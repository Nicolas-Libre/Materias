package reParcialAdi3;
import arbolBinario.BinaryTree;
public class Parcial {

	
	public BinaryTree<SumYDif> sumAndDif (BinaryTree<Integer> ab){
		BinaryTree<SumYDif> nuevoArbol = new BinaryTree<SumYDif>();
		if (ab != null && !ab.isEmpty()) {
			hacerArbol (ab, nuevoArbol, ab.getData(), ab.getData());
		}
		return nuevoArbol;
	}
	
	private void hacerArbol (BinaryTree<Integer> ab, BinaryTree<SumYDif> nuevoArbol, int suma, int resta) {
		int dato = ab.getData();
		SumYDif info = new SumYDif(suma, resta);
		nuevoArbol.setData(info);
		if (ab.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<SumYDif>());
			int datoHijoIzq = ab.getLeftChild().getData();
			hacerArbol (ab.getLeftChild(), nuevoArbol.getLeftChild(), datoHijoIzq + suma, datoHijoIzq - dato);
		}
		
		if (ab.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<SumYDif>());
			int datoHijoDer = ab.getRightChild().getData();
			hacerArbol (ab.getRightChild(), nuevoArbol.getRightChild(), datoHijoDer + suma, datoHijoDer - dato);
		}
		
		
	}
	
	
}
