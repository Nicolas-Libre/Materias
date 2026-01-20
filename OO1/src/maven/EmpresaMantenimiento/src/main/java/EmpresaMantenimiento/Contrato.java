package EmpresaMantenimiento;

import java.time.LocalDate;

public abstract class Contrato {
	protected LocalDate fecha;
	protected Servicio s;
	
	public Contrato (LocalDate f, Servicio s) {
		this.fecha = f;
		this.s = s;
	}
	
	public Double montoTotal() {
		Double total =  this.s.montoSTot();
		if (this.condicion()) {
			total += this.bonificacionORecargo (total);
		}
		
		return total;
	}
	
	public abstract boolean condicion();
	public abstract Double bonificacionORecargo(Double t);
}
