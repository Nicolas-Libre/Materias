package Parcial29.Parcial29;

import java.time.LocalDate;
import java.util.*;

public class Juego extends Actividad {
	
	private List<Item> items;
	
	public Juego (LocalDate fi, Integer cipu, Double m) {
		super (fi, cipu);
		this.duracion = m;
		this.items = new LinkedList<>();
	}
	
	public double calcularACobrar(LocalDate f1, LocalDate f2) {
		if (this.dentro(f1, f2)) {
			if (this.duracion>360.0) {
				return this.items.stream()
						.mapToDouble(i -> i.calcularPrecioFinal())
						.sum();
			}
			else return 0.0;
		}
		return -1.0;
		
	}
	
	
	
}
