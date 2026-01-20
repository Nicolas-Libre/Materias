package Ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class ClienteCorporativoTest {
	
	Cliente c1, c2;
	Envio e;
	Envio e2;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new ClienteCorporativo ("nicolas", "54 la plata", 2046017636);
		e = new EnvioInternacional (LocalDate.of(2015, 8,1), "Argentina", "Brasil", 50.0, true);
		e2 = new EnvioInterurbano (LocalDate.of(2014, 8,1), "Argentina", "Brasil", 50.0, 22.0);
	}
	
	@Test
	public void testAgregarEnvio(){
		c1.addEnvio(e);
		assertEquals (50.0, c1.getListaEnvios().get(0).getPesoG());
	}
	// e1 = 6300
	// e2 = 1000
    @Test
    public void testCalcularMontoPeriodo() {
    	c1.addEnvio(e);
    	c1.addEnvio(e2);
    	assertEquals (7300.0, c1.calcularMontoPeriodo(LocalDate.of(2013, 8, 1), LocalDate.of(2015, 8, 1)));
    }
}
