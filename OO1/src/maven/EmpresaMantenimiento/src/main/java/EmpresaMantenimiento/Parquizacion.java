package EmpresaMantenimiento;

import java.util.*;

public class Parquizacion extends Servicio {
	private List<Maquina> maquinas;

	
	public Parquizacion (Double pxh, Integer ch) {
		super(pxh, ch);
		this.maquinas = new LinkedList<>();
	}
	
	public void agregarMaquina (Maquina m) {
		maquinas.add(m);
	}
	
	public Integer cantidadMaquinas() {
		return this.maquinas.size();
	}
	
	public Double calcularMontoMaq() {
		return this.maquinas.stream()
				.mapToDouble(m -> m.calcularPrecio())
				.sum();
	}
	
	public Double montoSTot() {
		return this.calcularAux() + this.calcularMontoMaq();
	}
	
	
	
}
