package grafo15;

public class Objeto {
	private int minTrans;
	private String nombre;
	public Objeto (String usu, int cant) {
		this.minTrans = cant;
		this.nombre = usu;
	}
	public int getMinTrans() {
		return minTrans;
	}
	public void setMinTrans(int minTrans) {
		this.minTrans = minTrans;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
