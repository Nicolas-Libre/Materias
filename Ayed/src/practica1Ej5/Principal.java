package practica1Ej5;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arreglo = new int [5];
		arreglo [0] = 5;
		arreglo[1] = 8;
		arreglo[2] =22;
		arreglo[3] = 12;
		arreglo[4] = 3;
		Tres_Datos imp = Max_Min_Prom.datos_Retornar (arreglo, 5);
		
		System.out.println(imp.imprimir());
		
		Tres_Datos R2 = new Tres_Datos();
		Max_Min_Prom.retornar2(arreglo, 5, R2);
		System.out.println(R2.imprimir());
	}

}
