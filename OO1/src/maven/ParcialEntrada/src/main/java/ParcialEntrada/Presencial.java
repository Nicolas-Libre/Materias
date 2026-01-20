package ParcialEntrada;

import java.time.LocalDate;
import java.util.*;

public class Presencial extends Evento {
	
	private LinkedList<Sede> sedes = new LinkedList<Sede>();
	
	public Double calcularPAsistencia(LocalDate f){
		Double pAsistencia = this.getPrecioInsc() + this.getPrecioRem() + this.calcularPrecioTodasSede();
		Double rec = this.calcularRecargo(f, pAsistencia);
		return pAsistencia + rec;
	}
	
	public Double calcularPrecioTodasSede() {
		return this.getSedes().stream().mapToDouble(sed -> sed.calcularPTotal()).sum();
	}

	public LinkedList<Sede> getSedes() {
		return sedes;
	}
	
	
	
	
}
