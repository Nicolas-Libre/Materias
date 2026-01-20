package Ejercicio19;
import java.time.*;
public class Propiedad {

	private String direccion;
	private String nDescriptivo;
	private DateLapse lapsoFecha;
	private Double precioXNoche;
	private boolean disponible;
	
	
	public boolean disponibilidad (LocalDate inicio, LocalDate fin, Propiedad prop) {
		if (prop.getLapsoFecha().equals(null)) return true;
		if (prop.getLapsoFecha().includesDate(inicio)) return false;
		if (prop.getLapsoFecha().includesDate(fin)) return false;
		if (inicio.isBefore(inicio) && fin.isAfter(fin)) return false;
		return true;
		
	}
	
	
	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public void crearReserva (DateLapse periodo) {
		if (this.disponibilidad(periodo.getFrom(), periodo.getTo(), this)) {
			this.setLapsoFecha(periodo);
		}
	}
	
	
	public Integer getCantidadNoches() {
		return cantidadNoches;
	}



	public void setCantidadNoches(Integer cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}



	public DateLapse getLapsoFecha() {
		return lapsoFecha;
	}



	public void setLapsoFecha(DateLapse lapsoFecha) {
		this.lapsoFecha = lapsoFecha;
	}



	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getnDescriptivo() {
		return nDescriptivo;
	}
	public void setnDescriptivo(String nDescriptivo) {
		this.nDescriptivo = nDescriptivo;
	}
	public Double getPrecioXNoche() {
		return precioXNoche;
	}
	public void setPrecioXNoche(Double precio) {
		this.precioXNoche = precio;
	}
	
	
}
