package Ejercicio11;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class cuentaCorrienteTest {
	private cuentaDeAhorro cuentaAhor;
	private cuentaCorriente cuentaDestino;
	private cuentaCorriente cuentaCorriente;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cuentaCorriente = new cuentaCorriente();
		this.cuentaAhor = new cuentaDeAhorro();
		this.cuentaDestino = new cuentaCorriente();
	}
	@Test
	void testConstructor() {
		assertEquals (0.0, cuentaCorriente.getSaldo());
		assertEquals (0.0, cuentaCorriente.getLimiteDescubierto());
	}
	
	
	@Test
	void testEstraerCorriente() {
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		assertTrue(cuentaCorriente.extraer(100.0));
		assertEquals (0.0, cuentaCorriente.getSaldo());
		
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		assertTrue (cuentaCorriente.extraer(300.0));
		assertEquals (-200.0, cuentaCorriente.getSaldo());
		assertEquals (500.0, cuentaCorriente.getLimiteDescubierto());
		
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		assertTrue(cuentaCorriente.extraer(600.0));
		assertFalse (cuentaCorriente.extraer(0.1));
	}
	@Test
	void testDepositar() {
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		cuentaCorriente.depositar(200.0);
		assertEquals (300.0, cuentaCorriente.getSaldo());
		
	}
	
	
	
	@Test
	void testTransferencias() {
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		assertTrue (cuentaCorriente.transferirACuenta(100.0, cuentaDestino));	
		
		cuentaCorriente.setSaldo(100.0);
		cuentaCorriente.setLimiteDescubierto(500.0);
		assertTrue (cuentaCorriente.transferirACuenta(200.0, cuentaDestino));
		assertEquals (-100.0, cuentaCorriente.getSaldo());
		assertEquals (200.0, cuentaDestino.getSaldo());
		
	}
	
	
	
	
	
	
	
	
	
	
}

	
