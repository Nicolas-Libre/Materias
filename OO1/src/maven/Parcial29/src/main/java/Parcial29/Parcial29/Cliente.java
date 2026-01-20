package Parcial29.Parcial29;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Cliente {
	private String nombre;
	private LocalDate fechaAlta;
	private boolean pena;
	private Plan p;
	private List<Actividad> actividades;
	
	public Cliente (String n, LocalDate fa, boolean p, Plan pl) {
		this.nombre = n;
		this.fechaAlta = fa;
		this.pena = p;
		this.p = pl;
		this.actividades = new LinkedList<>();
	}
	
	public void agregarActividad(Actividad a) {
		this.actividades.add(a);
	}
	
	public boolean dentro (LocalDate f1, LocalDate f2) {
		return !fechaAlta.isBefore(f1) && !fechaAlta.isAfter(f2);
	}

	
	public Double montoTotalACobrar(LocalDate f1, LocalDate f2) {
		if (this.dentro(f1, f2)) {
			long diasHastaFin = ChronoUnit.DAYS.between(fechaAlta, f1);
			return diasHastaFin *(this.p.calcularPBase() + this.montoPena(f1, f2) + this.actividades.stream()
																			.mapToDouble(a-> a.calcularACobrar(f1, f2))
																			.sum());
		}
		return -1.0;
		
		
	}
	
	public Double montoPena (LocalDate f1, LocalDate f2) {
		if (Period.between(fechaAlta, f2).getYears()<=10) {
			Double cantIpActi = this.actividades.stream().mapToDouble(a-> a.getCantIpUso()).sum();
			Integer cantidadIpDelPlan = this.p.getCantLimiteIp();
			if (cantIpActi > cantidadIpDelPlan) {
				return this.p.calcularPena(f1, f2, (cantIpActi - cantidadIpDelPlan));
			}
		}
		return 0.0;
	}
	
	
	
	
	
}
