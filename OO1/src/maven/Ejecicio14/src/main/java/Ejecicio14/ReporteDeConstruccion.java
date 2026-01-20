package Ejecicio14;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class ReporteDeConstruccion {

	private LinkedList<Pieza> listaPiezas ;
	
	
	public ReporteDeConstruccion() {
		listaPiezas = new LinkedList<Pieza>();
	}
	
	public LinkedList<Pieza> getListaPiezas() {
		return listaPiezas;
	}

	public void agregarPieza (Pieza p) {
		this.getListaPiezas().add(p);
	}
	
	public Double volumenDeMaterial (String material) {
		Double sumaVolumenes = 0.0;
		for (int i=0; i< listaPiezas.size(); i++) {
			if (listaPiezas.get(i).getMaterial().equals(material)) {
				sumaVolumenes += listaPiezas.get(i).calcularVolumen();
			}
		}
		return Math.floor((sumaVolumenes) * 100.0)/100.0;
	}
	
	public Double superficieDeColor(String color) {
		Double sumaSuperficies = 0.0;
		for (int i=0; i<listaPiezas.size(); i++) {
			if (listaPiezas.get(i).getColor().equals(color)) {
				sumaSuperficies += Math.floor((listaPiezas.get(i).calcularSuperficie()) * 100.0)/100.0;
			}
		}
		return sumaSuperficies;
	}

}
