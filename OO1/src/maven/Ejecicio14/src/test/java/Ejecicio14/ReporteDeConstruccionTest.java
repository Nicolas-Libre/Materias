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
public class ReporteDeConstruccionTest {
	private ReporteDeConstruccion reporteConstruccion;
	private Cilindro cili;
	private Esfera esfe;
	private Prisma pris;

	
	@BeforeEach
	void setUp() throws Exception {
		 this.reporteConstruccion = 
				new ReporteDeConstruccion();
		 this.cili = new Cilindro(4.0, 2.0, "Azul", "Hierro");
		 this.esfe = new Esfera(5.0, "Azul", "Hierro");
		 this.pris = new Prisma(4.0, 3.0, 6.0, "Azul", "Hierro");
		 reporteConstruccion.agregarPieza(cili);
		 reporteConstruccion.agregarPieza(pris);
	   	 reporteConstruccion.agregarPieza(esfe);
		
	}
	
    
	@Test
	void testVolumenes() {
		assertEquals (696.12, reporteConstruccion.volumenDeMaterial("Hierro"));
	}
	
	@Test
	void testSuperficies() {
		
		assertEquals(572.93, reporteConstruccion.superficieDeColor("Azul"));
	}		
	
	
	
	
}
