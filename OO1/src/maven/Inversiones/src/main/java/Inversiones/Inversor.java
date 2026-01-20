package Inversiones;

import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Inversor {
	private Double ValorActual;
	private  List<Inversion> inversiones;
	
	public Inversor () {
		this.ValorActual = this.calcularValorActual();
		this.inversiones = new LinkedList<>();
	}
	
	public Double calcularValorActual() {
		return this.inversiones.stream()
				.mapToDouble(i -> i.calcularVA())
				.sum();
	}


}
