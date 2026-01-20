package ParcialEntrada2.ParcialEntrada2;

import java.util.*;

public class Presencial extends Evento{
	private List<Sede> sedes;
	
	public Double calcularPrecioAsistencia() {
		return this.precioInscripcion +  this.precioRemera + this.sedes.stream().mapToDouble(p -> p.calcularPrecioSede()).sum();	
	}
	
	
}
