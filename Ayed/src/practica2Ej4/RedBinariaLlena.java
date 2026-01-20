package practica2Ej4;

import practica2Ej2.BinaryTree;

public class RedBinariaLlena {

	public int retardoReenvio (BinaryTree<Integer> red) {
		Integer seg =0;
		retardoReenvioRec (red, seg);
		return seg;
	}
	
	private void retardoReenvioRec (BinaryTree<Integer>red, Integer seg) {
		if (red.getData() == null) {
			return;
		}
		if ((red.hasLeftChild()) && (red.hasRightChild())) {
			if ((red.getLeftChild().getData()) > (red.getRightChild().getData())){
				retardoReenvioRec (red.getLeftChild(), (seg + red.getLeftChild().getData()));
			}
			else {
				retardoReenvioRec (red.getLeftChild(), (seg + red.getRightChild().getData()));
			}
		}
	}
	
}
