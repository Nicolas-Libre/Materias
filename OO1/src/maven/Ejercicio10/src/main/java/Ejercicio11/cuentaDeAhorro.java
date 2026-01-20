package Ejercicio11;

public class cuentaDeAhorro extends cuenta {
	
	
	public boolean extraer (Double monto) {
		monto+= monto*0.02;
		if (this.puedeExtraer(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}

	
	public boolean transferirACuenta (Double monto, cuenta cuentaDestino) {
		monto -= (monto*0.02);
		return super.transferirACuenta(monto, cuentaDestino);
	}
	
	public void depositar (Double monto) {
		monto-= monto*0.02;
		super.depositar(monto);
	}
}
