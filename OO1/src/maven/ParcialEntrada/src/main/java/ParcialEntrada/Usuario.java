package ParcialEntrada;

import java.time.LocalDate;
import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Usuario {

	private String nombre;
	private LinkedList<Entrada> entradasCompradas = new LinkedList<Entrada>();
	
	public String getNombre() {
		return nombre;
	}
	
	public void comprarEntrada(Evento e, boolean s) {
		Entrada nuevaE = new Entrada(e, s);
		entradasCompradas.add(nuevaE);
			
		
	}
	
	public Double calcularTotalEntradas(LocalDate inicio, LocalDate fin) {
		Double montoTotal = this.getEntradasCompradas().stream()
				.filter(ent -> ent.estaEnRango(inicio, fin)).mapToDouble(en -> en.consultarPAsistencia()).sum();
		return montoTotal;
		
		
	}
	
	public Entrada siguienteEvento() {
		Entrada e = this.getEntradasCompradas().stream()
				.filter(x -> x.getE().getFecha().isAfter(LocalDate.now()))
				.min(Comparator.comparing(f -> f.getE().getFecha())).orElse(null);
		return e;
	}
		 
	public LinkedList<Entrada> getEntradasCompradas() {
		return entradasCompradas;
	}

	public void setEntradasCompradas(LinkedList<Entrada> entradasCompradas) {
		this.entradasCompradas = entradasCompradas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
