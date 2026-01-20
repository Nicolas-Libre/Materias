package practica1ej7g;
import java.util.List;
public class Prin {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		Recursivo rec = new Recursivo();
		List<Integer> lista = rec.calcularSucesion(n);
		
		for (int i =0; i< lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

}
