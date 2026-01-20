package Ejercicio21;

public class ClienteCorporativo extends Cliente {
	private Integer CUIT;
	
	public ClienteCorporativo (String n, String d, Integer CUIT) {
		super (n,d);
		this.setCUIT(CUIT);
	}

	public Integer getCUIT() {
		return CUIT;
	}

	public void setCUIT(Integer cUIT) {
		CUIT = cUIT;
	}
	
	
}
