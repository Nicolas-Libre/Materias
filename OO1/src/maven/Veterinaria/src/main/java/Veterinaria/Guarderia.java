package Veterinaria;

public class Guarderia extends Servicio {
	private Double costoDiario = 500.0;
	private Double cantDias;
	
	public Double calcularCosto() {
		Double total = this.costoDiario * this.cantDias;
		if (this.mas.cantidadServicios() >= 5) {
			return total - (total * 0.10);
		}
		return total;
	}

}
