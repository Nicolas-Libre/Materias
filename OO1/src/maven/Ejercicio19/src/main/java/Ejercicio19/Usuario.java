package Ejercicio19;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Usuario {

	private String nombre;
	private String direccion;
	private String dni;
	private LinkedList<Propiedad> propiedadesDeseadas = new LinkedList<Propiedad>();
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	public String getNombreCompleto() {
		return this.getDireccion() + ", " + this.getNombre();
	}

}
