package Ejercicio29;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class ClienteTest {
	
	Cliente nico, juanfran;
	Plan p1,p2;
	SesionJuego s1;
	ReproVideo r1;
	Item i1, i2, i3;
	@BeforeEach
	void setUp() throws Exception {
		LinkedList<Actividad> act = new LinkedList<Actividad>();
		LinkedList<Actividad> act2 = new LinkedList<Actividad>();
		LinkedList<Item> listaItems = new LinkedList<Item>();
		listaItems.add(i1);
		s1 = new SesionJuego (LocalDate.of(2016, 8, 1), "NicoIP", 250, listaItems);
		r1 = new ReproVideo (LocalDate.of(2014, 8, 1), "JuanfranIP", 400, 150);
		act.add(s1);
		p1 = new Individual(5, act, "NicoIP",40);
		act2.add(r1);
		act2.add(s1);
		p2 = new Grupal(1, act2 );
		nico = new Cliente ("nico", LocalDate.of(2013, 8, 1), p1);
		juanfran = new Cliente ("juanfran", LocalDate.of(2018, 8, 1), p2);
	}
	
    @Test
    public void TESTODOOOO() {
    		assertEquals (12, nico.calcularAntiguedad());
    		assertEquals (7, juanfran.calcularAntiguedad());
    		assertTrue(nico.estaEnRango(LocalDate.of(2010, 8, 1), LocalDate.now()));
    		assertFalse(juanfran.estaEnRango(LocalDate.now(), LocalDate.now()));
    		assertEquals(800, nico.getP().calcularPrecioBase());
    		assertEquals(800, juanfran.getP().calcularPrecioBase());
    		assertEquals(0, nico.getP().montoPenalizacion(nico.calcularAntiguedad(), LocalDate.of(2005, 8, 1), LocalDate.now()));
    		assertEquals (500, juanfran.getP().montoPenalizacion(juanfran.calcularAntiguedad(), LocalDate.of(2003, 8, 1), LocalDate.now()));
    		assertEquals (800, nico.getP().montoTotalACobrar(nico.calcularAntiguedad(), LocalDate.of(2000, 8, 1), LocalDate.now()));
    		assertEquals (3300, juanfran.getP().montoTotalACobrar(nico.calcularAntiguedad(), LocalDate.of(2000, 8, 1), LocalDate.now()));
    
    
    }
}
