package practica1Ej7;
import java.util.ArrayList;
public class TestArrayList {
	private  static ArrayList<Integer>lista = new ArrayList<>();
	private  static ArrayList<Estudiante>listaE1 = new ArrayList<>();
	public  static void agregar(int j) {
		lista.add(j);
	}
	public  static void imprimir() {
		for (int i=0; i< lista.size() - 1; i++) {
			System.out.println("Numero = " + lista.get(i));
		}
	}
	public static void listaEstudiantes (Estudiante e1, Estudiante e2, Estudiante e3) {
		ArrayList<Estudiante>listaE = new ArrayList<>();
		listaE.add(e1);
		listaE.add(e2);
		listaE.add(e3);
		
		ArrayList<Estudiante>listaCopia = new ArrayList<>();
		listaCopia = listaE;
		System.out.println("Original: "); 
		System.out.println(" ");
		for (int i=0; i< listaE.size(); i++) {
			System.out.println(listaE.get(i).toString());
		}
		System.out.println ("----------------------------------");
		System.out.println("Copia: ");
		for (int i=0; i< listaCopia.size(); i++) {
			System.out.println(listaCopia.get(i).toString());
		}
		System.out.println ("--------------------------------------------");
		listaE.get(1).setNombre("Kakita");
		
		for (int i=0; i< listaE.size(); i++) {
			System.out.println(listaE.get(i).toString());
		}
		System.out.println ("----------------------------------");
		System.out.println("Copia: ");
		for (int i=0; i< listaCopia.size(); i++) {
			System.out.println(listaCopia.get(i).toString());
		}
		listaE1 = listaE;
	}
	
	public static void agregarSiNoEsta (Estudiante e4) {
		boolean existe = false;
		for (int i=0; i< listaE1.size(); i++) {
			if (e4.getDni() == listaE1.get(i).getDni()) {
				System.out.println("Ya existe el estudiante");
				existe = true;
				break;
			}
		}
		if (existe == false) {
			listaE1.add(e4);
		
			for (int i=0; i< listaE1.size(); i++) {
				System.out.println(listaE1.get(i).toString());
			}
		}
	}
	
}
