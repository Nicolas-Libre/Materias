package Veterinaria;

import java.time.LocalDate;
import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Veterinaria {

	private List<Medico> medicos = new LinkedList<Medico>();
	private List<Mascota> mascotas = new LinkedList<Mascota>();

	public void agregarMedico (Medico m) {
		this.medicos.add(m);
	}
	
	public void agregarMascota (Mascota mas) {
		this.mascotas.add(mas);
	}
	
	public Double calcularCostoCachorros (LocalDate f) {
		return this.mascotas.stream()
				.filter(m -> m.soyCachorro())
				.mapToDouble(m -> m.calcularCostoMascota(f))
				.sum();	}
	
	
}
