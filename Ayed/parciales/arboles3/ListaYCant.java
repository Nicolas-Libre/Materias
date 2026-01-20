package arboles3;
import java.util.*;
import arbolBinario.BinaryTree;
public class ListaYCant {
	LinkedList<BinaryTree<Integer>> lista;
	int cantPar;
	
	public ListaYCant() {
		lista = new LinkedList<BinaryTree<Integer>>();
		cantPar = 0;
	}
	
	public LinkedList<BinaryTree<Integer>> getLista() {
		return lista;
	}
	public void agregar (BinaryTree<Integer> ab) {
		lista.add(ab);
	}
	public void sumarCant () {
		cantPar +=1;
	}
	public int getCantPar() {
		return cantPar;
	}
	public void setCantPar(int cantPar) {
		this.cantPar = cantPar;
	}
	
	
	
	
}
