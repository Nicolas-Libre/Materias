package Inversiones;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
public class PlazoFijo extends Inversion {

	private Double valorInicial;
	private LocalDate fecha;
	private Double porcentajeInteres;
	
	public PlazoFijo (Double vi, LocalDate f, Double pi ) {
		this.valorInicial = vi;
		this.fecha = f;
		this.porcentajeInteres = pi;
		
	}
	
	public Double calcularVA() {
		long dias = ChronoUnit.DAYS.between(fecha, LocalDate.now());
		return this.valorInicial + (dias * this.porcentajeInteres);
	}
	
}
