package practica1Ej1;

public class UnNada {


	public static void conNada (int a, int b) {
		
		if (a > b) {
			return;
		}
		System.out.println(a);
		conNada(a+1,b);
	}

}
