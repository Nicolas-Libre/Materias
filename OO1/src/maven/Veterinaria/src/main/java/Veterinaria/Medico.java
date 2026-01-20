package Veterinaria;

import java.time.LocalDate;
import java.time.Period;

public class Medico {
	private Double precioHono;
	private String nombre;
	private LocalDate fdi;
	
	
	public int calcularAntiguedad() {
		return Period.between(fdi, LocalDate.now()).getYears();
	}


	public Double getPrecioHono() {
		return precioHono;
	}
	
	
}
