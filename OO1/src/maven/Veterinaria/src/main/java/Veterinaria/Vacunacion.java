package Veterinaria;

public class Vacunacion extends ServicioConDoc {
	private String nombreVac;
	private Double costoVac;

	
	public Double calcularCosto() {
		return this.doc.getPrecioHono() + this.materialDesc + this.extraPorDomingo() + this.costoVac;
	}

}
