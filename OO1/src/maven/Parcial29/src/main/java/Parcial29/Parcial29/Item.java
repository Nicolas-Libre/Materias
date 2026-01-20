package Parcial29.Parcial29;

public class Item {
	private String nombre;
	private Integer cant;
	private Double precioXUni;
	
	
	public Item (String n, Integer c, Double pxu) {
		this.nombre = n;
		this.cant = c;
		this.precioXUni = pxu;
	}
	
	public double calcularPrecioFinal() {
		return cant * precioXUni;
	}
	
}
