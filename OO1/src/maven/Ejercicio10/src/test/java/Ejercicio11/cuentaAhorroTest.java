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


public class cuentaAhorroTest {
	private cuentaDeAhorro cuentaAhorro;
	private cuentaDeAhorro cuentaDestino;
	private cuentaCorriente cuentaCorr;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cuentaAhorro = new cuentaDeAhorro();
		this.cuentaDestino = new cuentaDeAhorro();
		this.cuentaCorr = new cuentaCorriente();
	}
	@Test
	void testConstructor() {
		assertEquals (0.0, cuentaAhorro.getSaldo());
	}
	
	
	@Test
	void testDepositarAhorro() {
		cuentaAhorro.setSaldo(400.0);
		cuentaAhorro.depositar(200.0);
		assertEquals (596.0, cuentaAhorro.getSaldo());
	}
	
	@Test
	void testExtraerAhorro() {
		cuentaAhorro.setSaldo(400.0);
		cuentaAhorro.extraer(100.0);
		assertEquals (298.0, cuentaAhorro.getSaldo());
		cuentaAhorro.setSaldo(400.0);
		assertFalse (cuentaAhorro.extraer(400.0));
	}
	
	@Test
	void testTransferirACuentaAhorro() {
		cuentaAhorro.setSaldo(400.0);
		assertTrue(cuentaAhorro.transferirACuenta(200.0, cuentaDestino));
		assertEquals (192.08, cuentaDestino.getSaldo());
	}
	
	@Test
	void testTransferirACuentaCorriente() {
		cuentaAhorro.setSaldo(400.0);
		assertTrue(cuentaAhorro.transferirACuenta(200.0, cuentaCorr));
		assertEquals (196.0, cuentaCorr.getSaldo());
	}
	
	
	
	
	
	
	
}

	
