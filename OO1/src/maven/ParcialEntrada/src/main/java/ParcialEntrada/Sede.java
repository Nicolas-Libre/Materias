package ParcialEntrada;

public class Sede {
	private String nombreS;
	private Double precioXDia;
	private Integer cantDias;
	
	public Double calcularPTotal() {
		return precioXDia * cantDias;
	}
	
}
