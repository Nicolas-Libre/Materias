package Ejercicio21;
import java.time.*;



public abstract class Envio {
	private LocalDate fechaDespacho;
	private String origen;
	private String destino;
	private Double pesoG;

	
	public Envio (LocalDate despacho, String o, String d, Double pG) {
		this.setDestino(d);
		this.setFechaDespacho(despacho);
		this.setOrigen(o);
		this.setPesoG(pG);
	}
	
	public abstract Double calcularCosto();


	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}


	public void setFechaDespacho(LocalDate fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Double getPesoG() {
		return pesoG;
	}


	public void setPesoG(Double pesoG) {
		this.pesoG = pesoG;
	}
	
	
}
