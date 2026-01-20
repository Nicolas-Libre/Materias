package EmpresaMantenimiento;

public class Limpieza extends Servicio {
	private Double tarifaMin;
	
	public Limpieza (Double pxh, Integer ch, Double tm) {
		super (pxh, ch);
		this.tarifaMin = tm;
	}
	
	public Double montoSTot() {
		Double costo = this.calcularAux();
		if (costo < this.tarifaMin) {
			return this.tarifaMin;
		}
		return costo;
	}
	
}
