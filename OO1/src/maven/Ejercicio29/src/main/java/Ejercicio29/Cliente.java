package Ejercicio29;

import java.time.LocalDate;
import java.time.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Cliente {

	private String nombre;
	private LocalDate fechaAlta;
	private Plan p;
	
	
	public Cliente (String n, LocalDate f, Plan pl) {
		this.setNombre(n);
		this.setFechaAlta(f);
		this.setPlan(pl);
	}
	
	public Plan getP() {
		return this.p;
	}
	public void setPlan(Plan p) {
		this.p=p;
	}
	public Integer calcularAntiguedad() {
		return Period.between(fechaAlta, LocalDate.now()).getYears();
	}
	
	public boolean estaEnRango(LocalDate inicio, LocalDate fin) {
		if (this.getFechaAlta().isAfter(inicio.minusDays(1)) && this.getFechaAlta().isBefore(fin.plusDays(1))) return true;
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
