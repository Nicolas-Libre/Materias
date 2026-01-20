package EmpresaMantenimiento;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Cliente {

	private String nombre;
	private String apellido;
	private String direccion;
	private List<Contrato> contrataciones; 
	
	public Cliente (String n, String a, String d) {
		this.nombre = n;
		this.apellido =a;
		this.direccion = d;
		this.contrataciones = new LinkedList<>();
	}

	
	public Double montoAPagar () {
		return this.contrataciones.stream()
				.mapToDouble(c -> c.montoTotal())
				.sum();
	}
	
	public long cantServicionMayorX(Double x) {
		return this.contrataciones.stream()
				.filter(c -> (c.montoTotal() > x))
				.count();
	}
	
	
}
