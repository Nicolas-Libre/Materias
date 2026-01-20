package practica1Ej3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiante  [] alumnos = new Estudiante [2];
		Profesor [] profesores = new Profesor [3];
		
		Estudiante e1 = new Estudiante ();
		Estudiante e2 = new Estudiante ();
		
		Profesor p1 = new Profesor ();
		Profesor p2 = new Profesor ();
		Profesor p3 = new Profesor ();
		
		e1.setApellido("gordo");
		e1.setNombre("a");
		e1.setEmail("aslaks@gmail");
		e1.setComision(5);
		e1.setDireccion("en la loma del orto");
		
		e2.setApellido("flaco");
		e2.setNombre("b");
		e2.setEmail("klasjaodskjokr@gmail");
		e2.setComision(6);
		e2.setDireccion("re cerca mal");
		alumnos[0] = e1;
		alumnos[1] = e2;
		int i;
		System.out.println("Alumnos:");
		for (i=0; i < 2; i++) {
			System.out.println(alumnos[i].tusDatos());

		}
		
		p1.setApellido("mediano");
		p1.setNombre("c");
		p1.setEmail("lllllll@gmail");
		p1.setCatedra("la mas chota");
		p1.setFacultad("la mejor");
		
		
		
		p2.setApellido("gordito");
		p2.setNombre("d");
		p2.setEmail("ooooooo@gmail");
		p2.setCatedra("la mejor");
		p2.setFacultad("la maso maso");
		
		p3.setApellido("flakito");
		p3.setNombre("e");
		p3.setEmail("iiiiiii@gmail");
		p3.setCatedra("la mmmmmmmmmm");
		p3.setFacultad("la AAAAAAAAAA");
		
		profesores[0] = p1;
		profesores[1] = p2;
		profesores [2] =p3;
		System.out.println("Profesores:");
		for (i=0; i < 3; i++) {
			
			System.out.println(profesores[i].tusDatos());
		}
	}

}
