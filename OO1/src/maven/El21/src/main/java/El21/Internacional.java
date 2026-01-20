package El21;

public class Internacional extends Envio {
	private boolean envioRapido;
	
	public Double calcularCosto() {
		Double precioDesti = 5000.0;
		Double total = precioDesti;
		if ( this.peso <= 1000.0) {
			total += (this.costoPorPeso(10.0));
		}
		else total += (this.costoPorPeso(12.0));
		
		if (envioRapido) total += 800;
		return total;
	}
}
