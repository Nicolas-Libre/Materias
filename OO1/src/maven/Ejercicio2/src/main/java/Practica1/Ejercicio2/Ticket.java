package Practica1.Ejercicio2;

import java.time.LocalDate;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Ticket {

	private LocalDate fecha;
	private Integer cantidadDeProductos=0;
	private Double pesoTotal=0.0;
	private Double precioTotal=0.0;
	
	
	public Double impuesto () {
		return precioTotal * 0.21;
	}

	public LocalDate getFecha() {
		return fecha;
	}




	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}




	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}




	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}




	public Double getPesoTotal() {
		return pesoTotal;
	}




	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}




	public Double getPrecioTotal() {
		return precioTotal;
	}




	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}




	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	public String toString() {
		return "Fecha = " + this.getFecha() + ", Cantidad de productos =  " + this.getCantidadDeProductos() 
			+ ", Precio Total" + this.getPrecioTotal() + " (Peso total " + this.getPesoTotal() + ")" ;
	}

}
