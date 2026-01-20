package Ejercicio29;

public class Item {
	private String nombre;
	private Integer cant;
	private Double precioXUni;
	
	
	public Double calcularPrecioFinal() {
		return this.getPrecioXUni() * this.getCant();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCant() {
		return cant;
	}


	public void setCant(Integer cant) {
		this.cant = cant;
	}


	public Double getPrecioXUni() {
		return precioXUni;
	}


	public void setPrecioXUni(Double precioXUni) {
		this.precioXUni = precioXUni;
	}
	
	
}
