package EmpresaMantenimiento;

import java.time.LocalDate;

public class UnaVez extends Contrato {
	
	
	
	public UnaVez(LocalDate f, Servicio s) {
		super (f,s);
	}
	
	
	
	public boolean condicion() {
		// supongamos que hoy es fin de semana
		return this.fecha.equals(LocalDate.now());
	}
	
	public Double aplicarCondicion(Double t) {
		return t*1.15;
	}
	
}
