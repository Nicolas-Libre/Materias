package Veterinaria;

public class ConsultaMedica extends ServicioConDoc {
	
	
	public Double calcularCosto() {
		Double precioXAño = 100.0 * this.doc.calcularAntiguedad();
		return this.materialDesc + this.doc.getPrecioHono() + precioXAño + this.extraPorDomingo();
		
	}
	
	
	
}
