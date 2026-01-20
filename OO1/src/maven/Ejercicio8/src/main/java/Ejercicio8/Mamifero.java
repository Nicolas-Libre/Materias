package Ejercicio8;

import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Mamifero {
	private String identificador;
	private String especie;
	private Date fechaDeNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	private Mamifero abueloMaterno;
	private Mamifero abuelaMaterna;
	private Mamifero abueloPaterno;
	private Mamifero abuelaPaterna;
	
	
	public Mamifero () {
		this.setIdentificador("anonimo");
	}
	
	public Mamifero(String nombre) {
		this.setIdentificador(nombre);
	}
	
	
	public Boolean tieneComoAncestroA (Mamifero unMamifero) {
		if (unMamifero == null || this.equals(unMamifero)) return false;
		
		if ((this.getPadre() != null && this.getPadre().equals(unMamifero)) 
				|| 
				(this.getMadre() != null && this.getMadre().equals(unMamifero))) return true;
		
		if ((this.getMadre() != null) && this.getMadre().tieneComoAncestroA (unMamifero)) return true;
		
		if ((this.getPadre() != null) && this.getPadre().tieneComoAncestroA (unMamifero)) return true;
	
		return false;
	}
		
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			this.abueloMaterno = this.getMadre().getPadre();
		}
		
		return abueloMaterno;
	}
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			this.abuelaMaterna = this.getMadre().getMadre();
		}
		
		return abuelaMaterna;
	}

	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			this.abueloPaterno = this.getPadre().getPadre();
		}
		
		return abueloPaterno;
	}
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			this.abuelaPaterna = this.getPadre().getMadre();
		}
		
		return abuelaPaterna;	
	}

}