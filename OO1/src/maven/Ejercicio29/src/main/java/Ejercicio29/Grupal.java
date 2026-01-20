package Ejercicio29;

import java.time.LocalDate;
import java.util.LinkedList;

public class Grupal extends Plan {

	public Grupal (Integer cmi, LinkedList<Actividad> act) {
		super(cmi,act);
	}
	
	public Double calcularPrecioBase() {
		Double num = 800.0;
		return (num*this.getCantMaxIp());
	}
	public Double montoPenalizacion(int años, LocalDate inicio, LocalDate fin) {
		Double monto = 500.0;
		if (años <= 10) {
			Integer cantIps =  (int) this.getActividades().stream().filter(act -> act.estaEnRango(inicio, fin))
					.map(act -> act.getDirecIp()).distinct().count();
			if (cantIps > this.getCantMaxIp()) return (cantIps-this.getCantMaxIp())*monto;
			return 0.0;
		}
		return 0.0;
	}
}
