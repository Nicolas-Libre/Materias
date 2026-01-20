package Ejercicio21;

import java.time.LocalDate;

public class EnvioLocal extends Envio {

	private boolean EnvioRapido;
	
	
	public EnvioLocal (LocalDate despacho, String o, String d, Double pG, boolean er) {
		super (despacho, o, d, pG);
		this.setEnvioRapido(er);
	}
	
	public Double calcularCosto() {
		Double montoExtra = 500.0;
		Double montoEstandar = 1000.0;
		if (this.EnvioRapido) return (montoExtra + montoEstandar);
		return montoEstandar;
	}
	
	public void setEnvioRapido(boolean er) {
		this.EnvioRapido = er;
	}
	
}
