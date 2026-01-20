package arbolBinario3;
import arbolBinario.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> arbolBinario;
	
	public BinaryTree <Integer> nuevoTree (){
		return hacerArbol (arbolBinario, 0);
	}
	
	private BinaryTree<Integer> hacerArbol (BinaryTree<Integer> arbolBinario, Integer aSumar) {
		BinaryTree<Integer> nuevo = new BinaryTree<Integer>();
		if (arbolBinario == null) {
			return null;
		}
		nuevo.setData((arbolBinario.getData() + aSumar));
		if (arbolBinario.hasLeftChild()) {
			nuevo.addLeftChild(hacerArbol (arbolBinario.getLeftChild(), arbolBinario.getData()));
		}
		if (arbolBinario.hasRightChild()) {
			nuevo.addRightChild(hacerArbol (arbolBinario.getRightChild(), 0));
		}
		return nuevo;
	}

	public BinaryTree<Integer> getArbolBinario() {
		return arbolBinario;
	}

	public void setArbolBinario(BinaryTree<Integer> arbolBinario) {
		this.arbolBinario = arbolBinario;
	}




}
