package Veterinaria;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Mascota {
	private String nombre;
	private LocalDate fecha;
	private String especie;
	private List<Servicio> servicios = new LinkedList<Servicio>();
	
	
	
	public void registrarServicio (Servicio s) {
		this.servicios.add(s);
	}
	
	
	public boolean soyCachorro () {
		return Period.between(fecha, LocalDate.now()).getYears() < 2;
	}
	
	public Double calcularCostoMascota (LocalDate f) {
		return this.servicios.stream()
				.filter(s -> s.esIgual(f))
				.mapToDouble(s -> s.calcularCosto())
				.sum();
	}
	
	
	public int cantidadServicios() {
		return this.servicios.size();
	}
	
}
