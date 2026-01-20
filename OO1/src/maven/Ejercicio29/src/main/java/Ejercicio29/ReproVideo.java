package Ejercicio29;

import java.time.LocalDate;
public class ReproVideo extends Actividad {
	private Integer duracionReal;
	private Integer duracionPublicidad;
	
	
	public ReproVideo (LocalDate fi, String di, Integer d, Integer dp) {
		super (fi, di, d);
		this.setDuracionReal(dp);
		this.setDuracionReal(d - dp);
		
	}
	
	public Double calcularMonto(LocalDate inicio, LocalDate fin){
		Double video = 10.0;
		Double montoVideo= 0.0;
		if (this.estaEnRango(inicio, fin)) {
			montoVideo = video * this.getDuracionReal();
		}
		return montoVideo;
		
		
	}
	
	public Integer getDuracionReal() {
		return this.duracionReal;
	}


	public Integer getDuracionPublicidad() {
		return duracionPublicidad;
	}


	public void setDuracionPublicidad(Integer duracionPublicidad) {
		this.duracionPublicidad = duracionPublicidad;
	}


	private void setDuracionReal(Integer duracionReal) {
		this.duracionReal = duracionReal;
	}
	

	
}
