package practica1Ej2;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int [] arreglo = Multiplos.vector(n);
		int i=0;
		for (i=0; i<n; i++) {
			System.out.println(arreglo[i]);
		}
		
		
		Scanner s = new Scanner (System.in);
		int a = s.nextInt();
		int [] nuevoAr=null;
		
		while (a != 0) {
			nuevoAr = Multiplos.vector(a);
			int j=0;
			System.out.println("Los numeros son ");
			for (j=0; j<a; j++) {
				System.out.println(nuevoAr[j]);
			
		}
			a = s.nextInt();
		}
		s.close();
		System.out.println("Se termino el programa");
	}
}
