package El21;

public class Local extends Envio {
	private boolean envioRapido;
	
	
	
	public Double calcularCosto() {
		if (envioRapido) {
			return 1500.0;
		}
		return 1000.0;
	}
}
