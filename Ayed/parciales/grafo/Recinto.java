package grafo;

public class Recinto {
	private int Tiempo;
	private String nombre;
	
	public Recinto (int t, String nom) {
		this.setNombre(nom);
		this.setTiempo(t);
	}

	public int getTiempo() {
		return Tiempo;
	}

	public void setTiempo(int tiempo) {
		Tiempo = tiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
