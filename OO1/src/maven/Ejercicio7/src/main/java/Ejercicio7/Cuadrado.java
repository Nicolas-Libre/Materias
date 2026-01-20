package Ejercicio7;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Cuadrado extends Figura {
	
	private Double lado=0.0;
	


	public Double getLado() {
		return lado;
	}


	public void setLado(Double ladoEnviado) {
		this.lado = ladoEnviado;
		super.setPerimetro(ladoEnviado*4.0);
		super.setArea(ladoEnviado*ladoEnviado);
	}
	
	

}
