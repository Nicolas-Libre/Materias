package Practica1.Ejercicio2;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Producto {

	private String descripcion;
	private Double peso;
	private Double precioPorKilo;
	
	
	public Producto (String desc, Double pes, Double xkilo) {
		this.setDescripcion(desc);
		this.setPeso(pes);
		this.setPrecioPorKilo(xkilo);
	}
	
	public Double getPrecio () {
		Double precio = 0.0;
		if ((peso != 0) && (precioPorKilo !=0)) {
			 precio = (peso * precioPorKilo);
		}
		return precio;
		
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion (String descipcion) {
		this.descripcion = descipcion;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPrecioPorKilo() {
		return precioPorKilo;
	}

	public void setPrecioPorKilo(Double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}


	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	public String toString() {
		return "Descripcion del producto= " + this.getDescripcion() + ", Peso del producto= " + this.getPeso() 
			+ ", Precio del producto= " + this.getPrecio() + " (Precio por kilo = " + this.getPrecioPorKilo() + ")" ;
	}

}
