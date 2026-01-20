package Ejercicio15;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class ClienteDeCorreoTest {
	
	ClienteDeCorreo nico, bri;
	Email e;
	Archivo a;
	
	@BeforeEach
	void setUp() throws Exception {
		nico = new ClienteDeCorreo();
		bri = new ClienteDeCorreo();
		e = new Email();
		a= new Archivo("Flama");
	}
	
    @Test
    public void test() {
    	e.setCuerpo("Hola como estas?, te adjunto archivo flama");
    	e.setTitulo("Adjuntando archivo flama");
    	e.agregarArchivo(a);
    	nico.recibirEmail(e);
    	assertEquals (e, nico.getInbox().getListaMails().get(0));
    	assertEquals (new LinkedList<Email>(), bri.getInbox().getListaMails());
    	nico.getInbox().mover(e, bri.getInbox());
    	assertEquals (e, bri.getInbox().getListaMails().get(0));
    	assertEquals (null, nico.getInbox().getListaMails().get(0));
    	assertEquals ("Hola como estas?, te adjunto archivo flama", bri.getInbox().getListaMails().get(0).getCuerpo());
    	assertEquals ("Adjuntando archivo flama", bri.getInbox().getListaMails().get(0).getTitulo()); 
    	assertEquals("Flama", bri.getInbox().getListaMails().get(0).getListaArchivos().get(0).getNombre());
    	assertEquals (e, bri.buscar("Adjuntando archivo flama"));
    
    }
}
