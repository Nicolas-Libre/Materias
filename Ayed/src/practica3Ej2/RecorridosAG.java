package practica3Ej2;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import arbolGeneral.GeneralTree;


public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		PreOrdenPrivado (a,n,lista);
		return lista;
		
		
	}
	private void  PreOrdenPrivado (GeneralTree <Integer> a, Integer n, List<Integer> lista) {
		if (a.isEmpty() == false) {
			if ((a.getData() % 2) != 0 && (a.getData()> n)) {
				lista.add(a.getData());
			}	
		}
		List<GeneralTree <Integer>> children= a.getChildren();
		for (GeneralTree<Integer> child : children){
			this.PreOrdenPrivado(child, n, lista);
			
		}
	}
		
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		InOrdenPrivado (a,n,lista);
		return lista;
	}
	
	
	private void  InOrdenPrivado (GeneralTree <Integer> a, Integer n, List<Integer> lista) {
		if (a.isEmpty() == false) {
			if ((a.getData() % 2) != 0 && (a.getData()> n)) {
				lista.add(a.getData());
			}
		}
		List<GeneralTree <Integer>> children= a.getChildren();
		for (GeneralTree<Integer> child : children){
			this.PreOrdenPrivado(child, n, lista);
		}
	}
	
	public List<Integer> numerosImayoresMayoresPorNiveles (GeneralTree<Integer> a, Integer n){
		List <Integer> lista = new LinkedList<Integer>();
		NivelesPrivado (a,n,lista);
		return lista;
		
	}
	
	private void NivelesPrivado (GeneralTree <Integer> a, Integer n, List <Integer> lista) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> aux_tree = new GeneralTree<Integer>(); 
		queue.add(a);
		while (!queue.isEmpty()) {
			aux_tree = queue.dequeue;
			if ((aux_tree.getData() % 2) != 0)  && (a.getData()>n){
				lista.add(a.getData());
			}
			List<GeneralTree<Integer>> childre = aux_tree.getChildren();
			for (GeneralTree<Integer> child : children) {
				queue.enqueue (child);
			}	
		}
	}
	
}
