package Ejercicio16;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class DateLapseTest {
	
	DateLapse lapsoFechas;
	LocalDate from;
	LocalDate to;
	LocalDate comparar;
	
	@BeforeEach
	void setUp() throws Exception {
		from= LocalDate.of(2025, 6, 25);
		to = LocalDate.of(2025, 8, 28);
		lapsoFechas = new DateLapse(from, to);
		comparar = LocalDate.of(2025, 8, 1);
	}
	
    @Test
    public void testDateLapse() {
        assertEquals (from, lapsoFechas.getFrom());
        assertEquals (to, lapsoFechas.getTo());
        assertTrue (lapsoFechas.indludesDate(comparar));
        assertEquals (64, lapsoFechas.sizeInDays());
    }
}
