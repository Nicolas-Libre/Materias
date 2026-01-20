package Parcial29.Parcial29;

import java.time.LocalDate;

public class Individual extends Plan {
	private Integer minutos;
	
	
	public Individual (Integer clip, Double pb, Integer m) {
		super (clip, pb);
		this.minutos = m;
	
	}
	
	public double calcularPBase() {
		return this.precioBase * this.minutos;
	}
	
	public double calcularPena(LocalDate f1, LocalDate f2, Double exceso) {
		return 300 * exceso;
	}
}
