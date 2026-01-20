package El21;

import java.time.LocalDate;

public abstract class Envio {
	protected LocalDate fecha;
	protected String origen;
	protected String destino;
	protected Double peso;

	
	
	public abstract Double calcularCosto();
	
	public LocalDate devolverFecha() {
		return this.fecha;
	}
	
	protected Double costoPorPeso(Double costo) {
		return costo * this.peso;
	}
}
