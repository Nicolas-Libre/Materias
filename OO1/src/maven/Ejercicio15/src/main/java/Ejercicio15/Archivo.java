package Ejercicio15;

public class Archivo {

	private String nombre;
	
	public Archivo (String n) {
		this.setNombre(n);
	}
	
	public Integer tamaño() {
		return this.getNombre().length();
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
