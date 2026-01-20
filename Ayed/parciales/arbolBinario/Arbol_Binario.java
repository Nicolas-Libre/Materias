package arbolBinario;

public class Arbol_Binario {

	public BinaryTree<sumaYDif> sumAndDif (BinaryTree<Integer> arbol) {


		return calcular_y_generar (arbol,0,0);

	}
	
	
	private BinaryTree<sumaYDif> calcular_y_generar (BinaryTree<Integer> arbol, int suma, Integer valorPadre) {
		if (arbol == null) {
			return null;
		}
		BinaryTree<sumaYDif> nuevoArbol = new BinaryTree<sumaYDif>();
		
		suma += arbol.getData();
		int dif = arbol.getData() - valorPadre;
		sumaYDif SD = new sumaYDif();
		SD.setearAmbos(suma, dif);
		nuevoArbol.setData(SD);
		nuevoArbol.addLeftChild(calcular_y_generar (arbol.getLeftChild(), suma, arbol.getData()));
		nuevoArbol.addRightChild(calcular_y_generar (arbol.getRightChild(), suma, arbol.getData())); 
		
		return nuevoArbol;
		
	}
	
	
	
}
