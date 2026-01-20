package arboles14;

public class CantYNodos {
	private int cantTotal;
	private int cantPos;
	private int cantNeg;
	public int getCantTotal() {
		return cantTotal;
	}
	public int getCantPos() {
		return cantPos;
	}
	
	public int getCantNeg() {
		return cantNeg;
	}
	
	public void sumar (Integer num) {
		if (num > 0) {
			cantPos += 1;
		}
		else cantNeg += 1;
		cantTotal += 1;
	}
	
	
	
}
