package Ejercicio29;

import java.time.LocalDate;
import java.util.*;

public class SesionJuego extends Actividad {
	private LinkedList<Item> items = new LinkedList<Item>();
	
	public SesionJuego(LocalDate fi, String di, Integer d, LinkedList<Item>ite) {
		super (fi,di,d);
		this.setItems(ite);
	}
	
	public Double calcularMonto(LocalDate inicio, LocalDate fin) {
		Double monto= 0.0;
		if (this.estaEnRango(inicio, fin)){
			if (this.getDuracion() > 360) {
				monto = items.stream().mapToDouble(unItem -> unItem.calcularPrecioFinal()).sum();
			}
		}
		return monto;
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
	

}
