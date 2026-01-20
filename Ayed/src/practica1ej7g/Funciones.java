package practica1ej7g;

public class Funciones {
	
	public static int Func (int n) {
		int aux;
		if ((n % 2) == 0) {
			aux = n/2;
		}
		else {
			aux = 3*n + 1;
		}
		return aux;
	}
}
