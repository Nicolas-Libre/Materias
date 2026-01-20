package reParcial23;
import arbolBinario.BinaryTree;
public class Parcial {
	private BinaryTree<Integer> ab;
	
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> nuevoArbol = new BinaryTree<Integer>();
		if (ab != null && !ab.isEmpty()) {
			hacerArbol (ab, nuevoArbol, 0);
		}
		return nuevoArbol;
	}
	
	private void hacerArbol (BinaryTree<Integer> ab, BinaryTree<Integer> nuevoArbol, int suma) {
		nuevoArbol.setData(ab.getData() + suma);
		if (ab.hasLeftChild()) {
			nuevoArbol.addLeftChild(new BinaryTree<Integer> ());
			hacerArbol (ab.getLeftChild(), nuevoArbol.getLeftChild(), ab.getData());
		}
		if (ab.hasRightChild()) {
			nuevoArbol.addRightChild(new BinaryTree<Integer>());	
			hacerArbol (ab.getRightChild(), nuevoArbol.getRightChild(), 0);
		}
		
	}
	
}
