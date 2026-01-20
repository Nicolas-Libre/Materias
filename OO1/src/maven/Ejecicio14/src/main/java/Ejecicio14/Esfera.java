package Ejecicio14;

public class Esfera extends Pieza {

	private Double radio;
	
	public Esfera (Double r, String c, String m) {
		this.setRadio(r);
		this.setColor(c);
		this.setMaterial(m);
	}
	
	public Double calcularVolumen() {
		return Math.floor((4.0/3.0 * Math.PI * Math.pow(this.getRadio(), 3)) * 100.0) / 100.0; 
		
	}


	public Double calcularSuperficie() {
		return Math.floor((4 * Math.PI * Math.pow(this.getRadio(), 2))*100.0)/100.0;
	}
	
	public Double getRadio() {
		return radio;
	}


	public void setRadio(Double radio) {
		this.radio = radio;
	}


}
