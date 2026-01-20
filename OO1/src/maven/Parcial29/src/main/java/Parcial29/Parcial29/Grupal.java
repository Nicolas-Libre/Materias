package Parcial29.Parcial29;

import java.time.LocalDate;

public class Grupal extends Plan {

	
	public Grupal (Integer clip, Double pb) {
		super(clip, pb);
	}
	
	
	public double calcularPBase() {
		return this.precioBase * this.cantLimiteIp;
	}
	
	public double calcularPena(LocalDate f1, LocalDate f2, Double exceso) {
		return 500 * exceso;
		
	}
	
}
