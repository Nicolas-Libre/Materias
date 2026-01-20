package practica1Ej7;
import java.util.Random;

public class testeando {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		for (int i=0; i<5; i++) {
			int j =  random.nextInt(100) +1;
			TestArrayList.agregar(j);
		}
		TestArrayList.imprimir();
		System.out.println("---------------------------------------------------");
		Estudiante e1 = new Estudiante ("marcelo", "Rodriguez", 45);
		Estudiante e2 = new Estudiante ("juan", "Roldan", 12);
		Estudiante e3 = new Estudiante ("Rayo", "Perez", 22);
		
		TestArrayList.listaEstudiantes(e1, e2, e3);
		
		Estudiante e4 = new Estudiante ("roberto", "nuñez", 15);
		System.out.println("-----------------------");
		TestArrayList.agregarSiNoEsta(e4);
		
		
	}	
	
}
