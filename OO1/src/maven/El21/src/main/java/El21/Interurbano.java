package El21;

public class Interurbano extends Envio {
	private Double km;
	
	public Double calcularCosto() {
		if (km < 100) {
			return this.costoPorPeso(20.0);
		}
		else if (km < 500) {
			return this.costoPorPeso(25.0);
		}
		return this.costoPorPeso(30.0);
	}
	
	
}
