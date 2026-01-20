package practica1Ej5;

public class Max_Min_Prom {
	public static Tres_Datos datos_Retornar (int []arreglo, int dimL) {
		int i;
		int max =0;
		int min= 99999;
		double prom = 0;
		int tot =0;
		Tres_Datos aux = new Tres_Datos();
		for (i=0; i<dimL; i++) {
			if (arreglo[i] > max){
				max = arreglo[i];
			}
			if (arreglo[i] < min){
				min = arreglo[i];
			}
			tot += arreglo[i];
		}
		aux.setMax(max);
		aux.setMin(min);
		prom = tot /dimL;
		aux.setProm(prom);
		return aux;	
	}
	public static void retornar2 (int []arreglo, int dimL, Tres_Datos TD) {
		int i;
		int max =0;
		int min= 99999;
		double prom = 0;
		int tot =0;
		for (i=0; i<dimL; i++) {
			if (arreglo[i] > max){
				max = arreglo[i];
			}
			if (arreglo[i] < min){
				min = arreglo[i];
			}
			tot += arreglo[i];
		}
		TD.setMax(max);
		TD.setMin(min);
		prom = tot /dimL;
		TD.setProm(prom);
		
	}
	
	
}
