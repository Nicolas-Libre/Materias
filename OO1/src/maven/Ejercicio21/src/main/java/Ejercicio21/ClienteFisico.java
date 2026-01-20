package Ejercicio21;

import java.time.LocalDate;


public class ClienteFisico extends Cliente {
	private Integer DNI;
	
	public ClienteFisico (String n, String d, Integer DNI) {
		super (n,d);
		this.setDNI(DNI);
	}
	
	public Double calcularMontoPeriodo (LocalDate inicio, LocalDate fin){
		return (super.calcularMontoPeriodo(inicio, fin) * 0.90);
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}
	
	
	
	
}
