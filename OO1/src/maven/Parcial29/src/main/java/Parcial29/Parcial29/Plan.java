package Parcial29.Parcial29;

import java.time.LocalDate;

public abstract class Plan {
	protected Integer cantLimiteIp;
	protected Double precioBase;
	
	
	public Plan (Integer clip, Double pb) {
		this.cantLimiteIp = clip;
		this.precioBase = pb;
	}
	
	
	
	public abstract double calcularPBase();
	public abstract double calcularPena (LocalDate f1, LocalDate f2, Double exceso);



	public Integer getCantLimiteIp() {
		return cantLimiteIp;
	}



	
	
	
	
	
}
