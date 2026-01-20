package Ejecicio14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import  static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class PiezaTest {
	
	private Cilindro cili;
	private Esfera esfe;
	private Prisma pris;
	
	@BeforeEach
	void setUp() throws Exception {

		 this.cili = new Cilindro(4.0, 2.0, "Amarillo", "Bronce");
		 this.esfe = new Esfera(5.0, "Azul", "Hierro");
		 this.pris = new Prisma(4.0, 3.0, 6.0, "Blanco", "Oro");

	}
	
    
	@Test
	void testVolumenes() {
		assertEquals (100.53, cili.calcularVolumen());
		assertEquals(72.0, pris.calcularVolumen());
		assertEquals( 523.59, esfe.calcularVolumen());
	}
	
	@Test
	void testSuperficies() {
		assertEquals (150.79, cili.calcularSuperficie());
		assertEquals(314.15, esfe.calcularSuperficie());
		assertEquals(108.00, pris.calcularSuperficie());
	}
}
