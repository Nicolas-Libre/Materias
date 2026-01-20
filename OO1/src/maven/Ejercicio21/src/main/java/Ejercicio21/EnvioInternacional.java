package Ejercicio21;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {
	private boolean EnvioRapido;
	
	
	public EnvioInternacional (LocalDate despacho, String o, String d, Double pG, boolean er) {
		super (despacho, o, d, pG);
		this.setEnvioRapido(er);
		
	}
	
	public Double calcularCosto() {
		Double costoXDestino = 5000.0;
		Double hasta1kg = 10.0;
		Double mas1kg = 12.0;
		Double montoExtra = 800.0;
		if (this.getPesoG() <= 1000.0) {
			 if (this.getEnvioRapido()) return (costoXDestino + montoExtra+ (hasta1kg * this.getPesoG()));
			 return (costoXDestino + (hasta1kg * this.getPesoG()));
		}
		if (this.getEnvioRapido()) return (costoXDestino + montoExtra +  (mas1kg * this.getPesoG()));
		return (costoXDestino + (mas1kg * this.getPesoG()));
	}
	
	
	public boolean getEnvioRapido() {
		return this.EnvioRapido;
	}
	
	public void setEnvioRapido (boolean er) {
		this.EnvioRapido = er;
	}
	
}
