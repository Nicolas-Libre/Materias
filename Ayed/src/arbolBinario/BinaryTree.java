package arbolBinario;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas(BinaryTree<T> hijo) {
	   if (this.isEmpty()) {
		   return 0;
	   }
	   else if (this.isLeaf()) {
		   return 1;
	   }
	   return contarHojas (this.getLeftChild()) + contarHojas (this.getRightChild());
	   
	}
		
		
    	 
    public BinaryTree<T> espejo(BinaryTree<T> nodo){
    	BinaryTree<T> aux = nodo;
    	BinaryTree<T> hijoAux = null;
    	if (nodo.isEmpty() == false) {
    		if (aux.hasLeftChild()) {
    			hijoAux = aux.leftChild;
    			if (aux.hasRightChild()){
    				aux.leftChild = aux.rightChild;
    			}
    			else {
    				aux.leftChild = null;
    			}
    			aux.rightChild = hijoAux;
    			return espejo (nodo.leftChild);
    		}
    		else {
    			if (aux.hasRightChild()) {
    				hijoAux = aux.rightChild;
    				aux.rightChild = null;
    				aux.leftChild = hijoAux;
    				return espejo (nodo.rightChild);
    			}
    		}
    	}
    	return aux;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		
   }
	
		
}