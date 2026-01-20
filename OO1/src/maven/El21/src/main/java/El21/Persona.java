package El21;

import java.time.LocalDate;
import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public abstract class Persona {

	protected String direccion;
	protected List<Envio> envios;
	
	
	
	public void agregarEnvio (Envio e) {
		this.envios.add(e);
	}
	
	
	public Double calcularMontoEnvios(LocalDate fi, LocalDate ff) {
		return this.envios.stream().filter(e ->  ! (e.devolverFecha().isAfter(ff) || e.devolverFecha().isBefore(fi)))
				.mapToDouble(e -> e.calcularCosto())
				.sum();
	}
	
	
}
