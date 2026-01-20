package Inversiones;

import java.util.*;

public class EnAcciones extends Inversion {
	
	private String nombre;
	private List<Accion> acciones;
	
	public Double calcularVA() {
		return this.acciones.stream()
				.mapToDouble(a -> a.gerValorUni())
				.sum();
	}
	
	public Integer contarAcciones() {
		return this.acciones.size();
	}
	
	public void agregarAccion(Accion a) {
		this.acciones.add(a);
	}
	
	public void sacarAccion (Accion a) {
		this.acciones.remove(a);
	}
	

}
