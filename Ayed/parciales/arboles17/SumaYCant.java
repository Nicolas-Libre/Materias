package arboles17;

public class SumaYCant {
	private int suma;
	private int cant;
	public int getSuma() {
		return suma;
	}
	
	public int getCant() {
		return cant;
	}
	public void sumarCant () {
		cant += this.getCant() +1;
	}
	
	public void sumarSuma (int num) {
		suma += this.getSuma() + num;
	}
	
	
}
