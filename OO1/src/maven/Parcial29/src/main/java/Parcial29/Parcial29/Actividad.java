package Parcial29.Parcial29;

import java.time.LocalDate;

public abstract class Actividad {
	protected LocalDate fechaInicio;
	protected Integer cantIpUso;
	protected Double duracion;
	
	public Actividad (LocalDate fi, Integer cipu) {
		this.fechaInicio=fi;
		this.cantIpUso = cipu;
	}
	
	
	public abstract double calcularACobrar(LocalDate f1, LocalDate f2);
	
	protected boolean dentro(LocalDate f1, LocalDate f2) {
		 return !fechaInicio.isBefore(f1) && !fechaInicio.isAfter(f2);
	}


	public Integer getCantIpUso() {
		return cantIpUso;
	}
	
	
	
	

}
