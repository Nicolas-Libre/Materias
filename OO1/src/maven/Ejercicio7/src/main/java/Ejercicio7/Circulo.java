package Ejercicio7;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Circulo extends Figura {

	private Double Diametro=0.0;
	private Double Radio=0.0;
	
	public Double getDiametro() {
		return Diametro;
	}
	public void setDiametro(Double diametro) {
		Diametro = diametro;
		Radio = diametro/2;
		super.setPerimetro(Math.PI * (diametro*2));
		super.setArea(Math.PI*(diametro*diametro));
		
	}
	public Double getRadio() {
		return Radio;
	}
	public void setRadio(Double radio) {
		Radio = radio;
		Diametro = radio*2;
		super.setPerimetro(Math.PI * (radio*2));
		super.setArea(Math.PI*(radio*radio));
	}
	
	
	

}
