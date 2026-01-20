package practica1Ej7;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int dni;
	
	
	
	
	
	public Estudiante(String unNombre, String unApellido, int unDni) {
		super();
		setApellido(unApellido);
		setNombre(unNombre);
		setDni(unDni);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String toString() {
		String aux;
		aux = ("Nombre: " + getNombre() + " Apellido: " + getApellido() + " Dni: " + getDni());
		return aux;
	}
	
	
	
}
