package Ejercicio29;
import java.time.LocalDate;
import java.util.*;
public abstract class Plan {
	private Integer cantMaxIp;
	private LinkedList<Actividad> actividades = new LinkedList<Actividad>();
	
	public Plan(Integer cmi, LinkedList<Actividad> act) {
		this.setCantMaxIp(cmi);
		this.setActividades(act);
	}
	
	public abstract Double calcularPrecioBase();

	public Double montoTotalACobrar(int años, LocalDate inicio, LocalDate fin) {
		Double montoTotal = this.getActividades().stream().mapToDouble(act -> act.calcularMonto(inicio, fin)).sum();
		montoTotal += this.calcularPrecioBase();
		montoTotal += this.montoPenalizacion(años, inicio, fin);
		return montoTotal;
		
	}
	
	public abstract Double montoPenalizacion(int años, LocalDate inicio, LocalDate fin);
	
	
	

	public Integer getCantMaxIp() {
		return cantMaxIp;
	}

	public void setCantMaxIp(Integer cantIp) {
		this.cantMaxIp = cantIp;
	}



	public LinkedList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(LinkedList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
	
	
}
