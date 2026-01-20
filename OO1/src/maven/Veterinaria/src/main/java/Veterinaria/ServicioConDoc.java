package Veterinaria;

import java.time.DayOfWeek;

public abstract class ServicioConDoc extends Servicio{
	protected Double materialDesc;
	protected Medico doc;
	
	public abstract Double calcularCosto();
	
	public Double extraPorDomingo() {
		if (this.fechaAtencion.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			return 200.0;
		}
		return 0.0;
	}
	
	

}
