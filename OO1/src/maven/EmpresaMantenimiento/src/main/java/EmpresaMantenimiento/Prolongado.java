package EmpresaMantenimiento;

import java.time.LocalDate;

public class Prolongado extends Contrato {
	private Integer cantDias;
	
	public Prolongado (LocalDate f, Servicio s, Integer cDias) {
		super (f,s);
		this.cantDias = cDias;
	}
	
	
	public boolean condicion() {
		return cantDias > 5;
	}
	
	
	public Double aplicarCondicion(Double t) {
		return -(t * 0.90);
		
	}
	
	
}
