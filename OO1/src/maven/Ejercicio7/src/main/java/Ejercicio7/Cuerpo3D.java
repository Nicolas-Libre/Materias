package Ejercicio7;

public class Cuerpo3D  {
	private Double altura;
	private Figura caraBasal;
	private Double volumen;
	private Double superficieExterior;
	
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Figura gerCaraBasal() {
		return caraBasal;
	}
	public void setCaraBasal(Figura figu) {
		this.caraBasal = figu;
	}
	
	public Double getSuperficieExterior() {
		this.superficieExterior = (2* this.caraBasal.getArea() + caraBasal.getPerimetro() * this.getAltura());
		return superficieExterior;
	}
	
	public Double getVolumen() {
		this.volumen = this.caraBasal.getArea() * this.getAltura();
		return volumen;
	}
	

	
	
	
}
