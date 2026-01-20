package ParcialEntrada;
import java.time.*;
public class Virtual extends Evento {

	private Double montoEnvio;
	
	public Double calcularPAsistencia(LocalDate f) {
		Double pAsistencia = this.getPrecioInsc() + this.getPrecioRem() + this.getMontoEnvio();
		Double rec = this.calcularRecargo(f, pAsistencia);
		return pAsistencia + rec;
	}

	public Double getMontoEnvio() {
		return montoEnvio;
	}
	
}
