package Ejercicio29;

import java.time.LocalDate;
import java.util.LinkedList;

public class Individual extends Plan {
	private String DirecIp;
	private Integer cantMin;
	
	public Individual (Integer cmi, LinkedList<Actividad> act, String di, Integer cm) {
		super(cmi, act);
		this.setDirecIp(di);
		this.setCantMin(cm);
	}
	
	public Double calcularPrecioBase() {
		Double num = 20.0;
		return num*cantMin;
	}

	public void setDirecIp(String direcIp) {
		DirecIp = direcIp;
	}

	public void setCantMin(Integer cantMin) {
		this.cantMin = cantMin;
	}

	public Double montoPenalizacion(int años, LocalDate inicio, LocalDate fin) {
		Integer cantIps = 0;
		Double penalizacion = 0.0;
		Double montoP = 300.0;
		cantIps = (int) this.getActividades().stream().filter(act -> act.estaEnRango(inicio, fin))
				.filter(ip -> !ip.getDirecIp().equals(this.getDirecIp())).distinct().count();
		if (cantIps > 0) {
			penalizacion = (cantIps * montoP);
		}
		return penalizacion;
	}

	public String getDirecIp() {
		return DirecIp;
	}

	public Integer getCantMin() {
		return cantMin;
	}
	
	
}
