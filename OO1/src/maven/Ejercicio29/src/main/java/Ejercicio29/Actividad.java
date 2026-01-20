package Ejercicio29;

import java.time.LocalDate;

public abstract class Actividad {
	private LocalDate fehcaInicio;
	private String direcIp;
	private Integer duracion;

	public Actividad (LocalDate fi, String di, Integer d) {
		this.setFehcaInicio(fi);
		this.setDirecIp(di);
		this.setDuracion(d);
	}
	
	public abstract Double calcularMonto(LocalDate inicio, LocalDate fin);
	
	protected boolean estaEnRango (LocalDate inicio,LocalDate fin) {
		if (this.getFehcaInicio().isAfter(inicio.minusDays(1)) && this.getFehcaInicio().isBefore(fin.plusDays(1)))return true;
		return false;
	}
	
	public void setFehcaInicio(LocalDate fehcaInicio) {
		this.fehcaInicio = fehcaInicio;
	}

	public void setDirecIp(String direcIp) {
		this.direcIp = direcIp;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFehcaInicio() {
		return fehcaInicio;
	}
	public String getDirecIp() {
		return direcIp;
	}
	public Integer getDuracion() {
		return duracion;
	}
	
	
	
}
