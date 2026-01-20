package Ejercicio21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class EnvioInternacionalTest {
	
	Envio e1;
	Envio e2;
	Envio e3;
	Envio e4;
	@BeforeEach
	void setUp() throws Exception {
		e1 = new EnvioInternacional (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 22.0, false);
		e2 = new EnvioInternacional (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 1500.0, true);
		e3 = new EnvioInternacional (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 22.0, true);
		e4 = new EnvioInternacional (LocalDate.of(2014, 8, 1), "Brasil", "argentina", 1500.0, false);
	}
	
    @Test
    public void testCalcularCosto() {
        assertEquals (5220.0, e1.calcularCosto());
        assertEquals (23800.0, e2.calcularCosto());
        assertEquals (6020.0, e3.calcularCosto());
        assertEquals (23000.0, e4.calcularCosto());
    }
}
