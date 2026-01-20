package practica1ej7g;
import java.util.List;
import java.util.ArrayList;
public class Recursivo {
	private   List<Integer> lista = new ArrayList<>();
	
	
	public   List <Integer> calcularSucesion (Integer n){
		lista.add(n);
		if (n==1) {
			return lista;
		}
		n = Funciones.Func(n);
		return calcularSucesion (n);
	}

}
