package ParcialEntrada;

import java.time.LocalDate;

public abstract class Evento {
	private String nombre;
	private LocalDate fecha;
	private String tema;
	private Double precioInsc;
	private Double precioRem;
	
	
	public Double calcularRecargo (LocalDate f, Double p) {
		if (f.isEqual(this.fecha)) return (p * 0.20);
		return 0.0;
	}
	public abstract Double  calcularPAsistencia (LocalDate f);
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public Double getPrecioInsc() {
		return precioInsc;
	}
	public void setPrecioInsc(Double precioInsc) {
		this.precioInsc = precioInsc;
	}
	public Double getPrecioRem() {
		return precioRem;
	}
	public void setPrecioRem(Double precioRem) {
		this.precioRem = precioRem;
	}
	
	
	
}
