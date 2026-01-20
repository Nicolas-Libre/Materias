package Veterinaria;

import java.time.LocalDate;

public abstract class Servicio {
	protected LocalDate fechaAtencion;
	protected Mascota mas;
	
	public abstract Double calcularCosto();
	
	
	public boolean esIgual (LocalDate f) {
		return f.equals(fechaAtencion);
	}
	
	
}
