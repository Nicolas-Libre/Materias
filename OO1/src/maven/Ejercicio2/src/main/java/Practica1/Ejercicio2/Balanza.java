package Practica1.Ejercicio2;
import java.time.LocalDate;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Balanza {

	private Integer cantidadDeProductos =0;
	private Double precioTotal=0.0;
	private Double pesoTotal=0.0;
	
	
	public void agregarProducto (Producto p) {
		cantidadDeProductos += 1;
		precioTotal += p.getPrecio();
		pesoTotal += p.getPeso();
		
	}
	
	public Ticket emitirTicket () {
		Ticket t = new Ticket ();
		t.setFecha(LocalDate.now());
		t.setCantidadDeProductos(this.getCantidadDeProductos());
		t.setPesoTotal(this.getPesoTotal());
		t.setPrecioTotal(this.getPrecioTotal());
		return t;
	}
	
	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}



	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}



	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}



	public void ponerEnCero() {
		cantidadDeProductos =0;
		precioTotal = 0.0;
		pesoTotal =0.0;
		
	}
	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}


	public Double getPrecioTotal() {
		return precioTotal;
	}


	public Double getPesoTotal() {
		return pesoTotal;
	}


	


	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	public String toString() {
		return "Cantidad de Productos= " + this.getCantidadDeProductos() + ", Precio Total= " 
				+ this.getPrecioTotal() + ", Peso Total= " + this.getPesoTotal();
	}

}
