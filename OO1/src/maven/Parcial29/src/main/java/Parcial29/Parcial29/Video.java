package Parcial29.Parcial29;

import java.time.LocalDate;

public class Video extends Actividad {
	private Double total;
	private Double publi;
	
	
	public Video (LocalDate fi, Integer cipu, Double t, Double p) {
		super (fi, cipu);
		this.duracion = this.calcularDReal();
	}
	
	public double calcularACobrar(LocalDate f1, LocalDate f2) {
		if (this.dentro(f1, f2)) {
			return 10 * this.calcularDReal();
		}
		return -1.0;
	}
	
	private double calcularDReal() {
		return this.total - this.publi;
	}
	
}
