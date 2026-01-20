package EmpresaMantenimiento;

public abstract class Servicio {
	protected Double precioXHora;
	protected Integer cantHoras;
	
	public Servicio (Double pxh, Integer ch) {
		this.precioXHora = pxh;
		this.cantHoras = ch;
	}
	
	public abstract Double montoSTot();
	
	public Double calcularAux() {
		return this.precioXHora * this.cantHoras;
	}
	
	
	
}
