package Ejercicio3;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Item {

	private String detalle;
	private Integer cantidad=0;
	private Double costoUnitario=0.0;
	
	
	public Item (String det, Integer cant, Double costoUni) {
		this.setCantidad(cant);
		this.setCostoUnitario(costoUni);
		this.setDetalle(det);
	}
	
	public Double costo () {
		return (this.getCostoUnitario() * this.getCantidad());
	}
	
	public String getDetalle() {
		return detalle;
	}



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Double getCostoUnitario() {
		return costoUnitario;
	}



	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}



	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	

}
