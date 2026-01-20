package arboles23;
import arbolBinario.BinaryTree;
public class Parcial {
	private BinaryTree<Integer> ab;
	
	public BinaryTree<Integer> nuevoTree(){
		BinaryTree<Integer> arbolSuma = new BinaryTree<Integer> ();
		if (!ab.isEmpty()) {
			crear (ab, arbolSuma, 0);
		}
		
		return arbolSuma;
	} 
	
	
	private void crear (BinaryTree<Integer> ab, BinaryTree<Integer> arbolSuma, int valor) {
		arbolSuma.setData(ab.getData()+valor);
		
		if (ab.hasLeftChild()) {
			arbolSuma.addLeftChild(new BinaryTree<Integer>());
			crear (ab.getLeftChild(), arbolSuma.getLeftChild(), ab.getData());
		}
		
		if (ab.hasRightChild()) {
			arbolSuma.addRightChild(new BinaryTree<Integer>());
			crear (ab.getRightChild(), arbolSuma.getRightChild(), 0);
		}
		
		
	}
}
