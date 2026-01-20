package practica1Ej2;

public class Multiplos {

	
	
	public static int[] vector (int n) {
		int [] arreglo = new int [n];
		int i;
		for (i=0; i<n; i++) {
			arreglo[i] = n*(i+1);
		}
		return arreglo;
	}
	
	

}
