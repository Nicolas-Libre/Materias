package Ejercicio19;

public class Reserva {

	private Propiedad prop;
	private DateLapse lapsoFecha;
	
	
	
	
	
	public Double calcularPrecioTotal() {
		if (prop != null) {
			prop.getPrecioXNoche() * lapsoFecha.sizeInDays();
		}
	}
	
	public Propiedad getProp() {
		return prop;
	}
	public void setProp(Propiedad prop) {
		this.prop = prop;
	}
	public DateLapse getLapsoFecha() {
		return lapsoFecha;
	}
	public void setLapsoFecha(DateLapse lapsoFecha) {
		this.lapsoFecha = lapsoFecha;
	}
	public Double getPrecioXNoche() {
		return precioXNoche;
	}
	public void setPrecioXNoche(Double precioXNoche) {
		this.precioXNoche = precioXNoche;
	}
	
	
	
	
	
}
