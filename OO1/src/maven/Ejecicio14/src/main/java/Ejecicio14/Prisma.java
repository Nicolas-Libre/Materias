package Ejecicio14;

public class Prisma extends Pieza {
	
	private Double ladoMayor;
	private Double ladoMenor;
	private Double altura;
	
	
	public Prisma ( Double lmax, Double lmin, Double a, String c, String m ) {
		this.setAltura(a);
		this.setLadoMayor(lmax);
		this.setLadoMenor(lmin);
		this.setColor(c);
		this.setMaterial(m);
		
		
		
	}
	
	
	public Double calcularVolumen() {
		return Math.floor((this.getLadoMayor() * this.getLadoMenor() * this.getAltura()) * 100.0)/100.0;
		
	}

	public Double calcularSuperficie() {
		return Math.floor((2 * ((this.getLadoMayor() * this.getLadoMenor()) + (this.getLadoMayor() * this.getAltura()) + (this.getLadoMenor() * this.getAltura())))*100.0)/100.0;
	}
	
	public Double getLadoMayor() {
		return ladoMayor;
	}

	public void setLadoMayor(Double ladoMayor) {
		this.ladoMayor = ladoMayor;
	}

	public Double getLadoMenor() {
		return ladoMenor;
	}

	public void setLadoMenor(Double ladoMenor) {
		this.ladoMenor = ladoMenor;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}


	
}
