package Ejercicio11;

public class cuentaCorriente extends cuenta {

	private Double limiteDescubierto;
	
	
	
	public cuentaCorriente () {
		this.setLimiteDescubierto(0.0);
	}
	
	public boolean extraer (Double monto) {
		if (this.getSaldo() >=monto) {
			this.extraerSinControlar(monto);
			return true;
		}
		else if (limiteDescubierto >= (monto - this.getSaldo())) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	public boolean transferirACuenta (Double monto, cuenta cuentaDestino) {
		

	}
	
	
	public void depositar (Double monto) {
		super.depositar(monto);
	}

	public Double getLimiteDescubierto() {
		return limiteDescubierto;
	}



	public void setLimiteDescubierto(Double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}
	
	
}
