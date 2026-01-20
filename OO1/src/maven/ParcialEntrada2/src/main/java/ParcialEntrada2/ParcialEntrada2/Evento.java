package ParcialEntrada2.ParcialEntrada2;

import java.time.LocalDate;

public abstract class Evento {
	protected String nombreEvento;
	protected LocalDate fecha;
	protected String temaPrincipal;
	protected Double precioInscripcion;
	protected Double precioRemera;
	
	public abstract Double calcularPrecioAsistencia();
	
	
	
}
