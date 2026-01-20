package Ejercicio25;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.DynamicTest.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class MapaTest {
	
	Map <String, Integer> mapa;
	
	@BeforeEach
	void setUp() throws Exception {
		mapa = new HashMap<String, Integer>();
	}
	
    @Test
    public void testMapa() {
        mapa.put("Messi", 111);
        mapa.put("Batistuta", 56);
        mapa.put("Aguero", 42);
        
        assertEquals(111, mapa.get("Messi"));
        assertEquals(56, mapa.get("Batistuta"));
        assertEquals(42, mapa.get("Aguero"));
        
        mapa.remove("Aguero");
        assertNull(mapa.get("Aguero"));
        mapa.merge("Messi", 1, Integer:: sum);
        assertEquals (112, mapa.get("Messi"));
        mapa.put("Batistuta", 0);
        assertEquals(0, mapa.get("Batistuta"));
        mapa.put("Batistuta", 56);
        mapa.put("Aguero", 42);
        
        Integer totalGoles = mapa.values().stream().mapToInt(goles -> goles ).sum();
        
        assertEquals (210, totalGoles);
    }
}
