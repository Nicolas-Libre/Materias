package Ejecicio14;
import java.util.*;

public class Cilindro extends Pieza {

	private Double radio;
	private Double h;
	
	
	
	public Cilindro (Double r, Double altura, String c, String m) {
		this.setH(altura);
		this.setRadio(r);
		this.setColor(c);
		this.setMaterial(m);
	}
	
	public Double calcularVolumen() {
		return Math.floor((Math.PI * Math.pow(this.getRadio(), 2) * this.getH()) * 100.0)/100.0; 
		
	}


	public Double calcularSuperficie() {
		return Math.floor((2* Math.PI * this.getRadio() * this.getH() + (2 * Math.PI * Math.pow(this.getRadio(), 2))) * 100.0)/100.0  ;
	}
	
	public Double getRadio() {
		return radio;
	}


	public void setRadio(Double radio) {
		this.radio = radio;
	}


	public Double getH() {
		return h;
	}


	public void setH(Double h) {
		this.h = h;
	}
	
	
	
	
}
