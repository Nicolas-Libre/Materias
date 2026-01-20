package Ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class EnvioInterurbanoTest {
	
	Envio e1;
	Envio e2;
	Envio e3;
	
	@BeforeEach
	void setUp() throws Exception {
		e1 = new EnvioInterurbano (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 22.0, 99.0);
		e2 = new EnvioInterurbano (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 22.0, 300.0);
		e3 = new EnvioInterurbano (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 22.0, 1000.0);
	}
	
    @Test
    public void testCalcularCosto() {
        assertEquals (440, e1.calcularCosto());
        assertEquals (550, e2.calcularCosto());
        assertEquals (660, e3.calcularCosto());
    }
}
