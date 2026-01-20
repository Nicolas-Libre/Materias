package ParcialEntrada2.ParcialEntrada2;

public class Virtual extends Evento {
	private Double montoEnvio;
	
	public Double calcularPrecioAsistencia() {
		return this.precioInscripcion + this.precioRemera + this.montoEnvio;
	}
	
}
