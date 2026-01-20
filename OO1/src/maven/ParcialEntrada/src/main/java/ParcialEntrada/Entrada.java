package ParcialEntrada;

import java.time.LocalDate;

public class Entrada {
	private Evento e;
	private boolean seguro;
	private LocalDate fechaCompra;
	
	
	public Entrada (Evento e, boolean s) {
		this.setE(e);
		this.setFechaCompra(LocalDate.now());
		this.setSeguro(s);
	}
	
	public boolean estaEnRango (LocalDate incio, LocalDate fin) {
		DateLapse lapso = new DateLapse (incio, fin);
		return lapso.indludesDate(this.getFechaCompra());
	}
	
	public Double consultarPAsistencia () {
		Double pAsistencia = e.calcularPAsistencia(fechaCompra);
		if (seguro) return pAsistencia + 500;
		return pAsistencia;
		
	}
	
	public Double calcularRecupero() {
		Double montoARecuperar=0.0;
		DateLapse lapso = new DateLapse (fechaCompra, e.getFecha());
		Double pAsistencia = this.consultarPAsistencia();
		if (lapso.sizeInDays() >= 30) {
			montoARecuperar = pAsistencia * 0.5;
		}
		if (seguro) return montoARecuperar + pAsistencia * 0.15;
		return montoARecuperar;
	}

	public Evento getE() {
		return e;
	}

	public void setE(Evento e) {
		this.e = e;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	
	
}
