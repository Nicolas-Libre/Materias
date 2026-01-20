package Ejercicio3;
import java.time.LocalDate;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Presupuesto {

	private LocalDate fecha= LocalDate.now();
	private String cliente;
	private LinkedList<Double> precioItems;
	
	public Presupuesto (String cli) {
		this.setCliente(cli);
		precioItems = new LinkedList<Double>();
		
	}
	
	public void agregarItem (Item it) {
		precioItems.add(it.costo());
		
	}
	
	public Double calcularTotal() {
		Double precioTotal=0.0;
		
		if ((precioItems != null)  && (!precioItems.isEmpty())){
			for (int i=0; i< precioItems.size(); i++) {
				precioTotal += precioItems.get(i);
			}
		}
		
		return precioTotal;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	

}
