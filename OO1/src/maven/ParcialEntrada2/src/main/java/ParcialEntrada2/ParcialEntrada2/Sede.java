package ParcialEntrada2.ParcialEntrada2;

public class Sede {
	private String nombreSede;
	private Double precioXDia;
	private Integer cantDias;
	
	
	public Double calcularPrecioSede() {
		return this.precioXDia * this.cantDias;
	}
	

}
