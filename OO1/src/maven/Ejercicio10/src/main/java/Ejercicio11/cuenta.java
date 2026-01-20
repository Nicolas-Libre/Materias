package Ejercicio11;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public abstract class cuenta {
	
	private Double saldo;
	
	public cuenta() {
		this.setSaldo(0.0);
	}

	
	public void depositar (Double monto) {
		this.saldo += monto;
		
	}
	
	protected void extraerSinControlar(double monto) {
		if (monto<0) {
			monto = monto *-1;
		}
		this.saldo -= monto;
	}
	
	protected boolean puedeExtraer (Double monto) {
		if (this.getSaldo() >= monto) return true;
		return false;
	}
	
	public abstract boolean extraer (Double monto);

		
	
	public boolean transferirACuenta (Double monto, cuenta cuentaDestino) {
		if (this.puedeExtraer (monto)){
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
		
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	

}
