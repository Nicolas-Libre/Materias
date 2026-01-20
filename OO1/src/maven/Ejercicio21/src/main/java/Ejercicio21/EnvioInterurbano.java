package Ejercicio21;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio {
private Double distancia;



public EnvioInterurbano (LocalDate despacho, String o, String d, Double pG, Double dist) {
	super(despacho, o, d, pG);
	this.setDistancia(dist);
}

public Double calcularCosto() {
	Double menos100 = 20.0;
	Double entre100y500 = 25.0;
	Double mas500 = 30.0;
	
	if (this.getDistancia() < 100.0) return (menos100 * this.getPesoG());
	if (this.getDistancia()>= 100 && this.getDistancia() <= 500) return (entre100y500 * this.getPesoG());
	return (mas500*this.getPesoG());
}

public Double getDistancia() {
	return distancia;
}
	
public void setDistancia (Double d) {
	this.distancia = d;
}

}
