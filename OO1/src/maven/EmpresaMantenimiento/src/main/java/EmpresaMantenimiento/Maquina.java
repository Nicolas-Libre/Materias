package EmpresaMantenimiento;

public class Maquina {
	private Double precioMan;
	
	
	public Maquina (Double precioMan) {
		this.precioMan = precioMan;
	}
	
	public Double calcularPrecio() {
		//actualmente funciona como get, si se quiere calcular el precio de otra manera, se puede
		return this.precioMan;
	}
}
