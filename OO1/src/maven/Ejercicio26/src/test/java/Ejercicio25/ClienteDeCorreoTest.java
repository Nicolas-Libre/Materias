package Ejercicio25;
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
	Email e, e2, e3, e4;
	Archivo a, a2, a3, a4, a5;
	
	@BeforeEach
	void setUp() throws Exception {
		nico = new ClienteDeCorreo();
		bri = new ClienteDeCorreo();
		e = new Email();
		e2 = new Email();
		e3 = new Email();
		e4 = new Email();
		a= new Archivo("Flama");
		a2= new Archivo("ksdhfbadskjfbakelfbsdkljfbsdlkjgbsdf"
				+ "lkjgvndsflkjgsdlkjgn sdlgkj sflgkjn sflgkjnsflkjgnsfñlkjgnsfñkjgnsfñkjbgnsñfkjgnsfñkjgkn");
		a3 = new Archivo("Lorem ipsum dolor sit amet"
				+ " consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqu"
				+ "a Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo co"
				+ "nsequat Duis aute irurkjdbhfkjdsbfkljdbfkdjfbldkjfne d"
				+ "kdshbfkdshbfkjdsbfkdjfbdfksjdgfvkusydg"
				+ "lllllfolor in relprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariat");
		a4 = new Archivo("ksduhvbdwkjfhbsdkjlfbsdlkfbsdlkfkbbslgiuiubslgbsdlfjbsdlfkjbsdlksdbglkhsdbflk"
				+ "ldknfbdslkjfbsdlkjfbsdlkjfbsdlkfjbsdlfkjbsdfñkjsdbflkjasdsbfladkjfblakjdjfbaslkjfbaslkfj"
				+ "kjashfbkasjfbadlkefhjbgdljdchbskjbskjdbskdjbskdbsdljbsdjkufhlskudhsfdsd"
				+ "ksjdbksjdbksjdbsklhdbsldskjfbadsfkjbdsvkhdsbfkielikdsbhfkjsdbfkjdsbfkjsdbfkbhfsdkjb"
				+ "kduhbfdskjfbsdkufbsdkghbdskjghfhbsdkjhbsdfikhbsfkhsebfkjhsdbfkjsdbfkjdsbfksdjhjgbsdkjfbsdkjfbsdf"
				+ "kjdhfbseieufbeiufbwekuyfbwefyubweisfgdsgdsgdsgdjfhbsjdkfhbkdjsbfhdskjlfnufbefibdsfkhsdbfkjdsjbf"
				+ "jhbdfkhsdbfkhsdbfdfsefsdfdsfsdgsdgksjhfbsdkjhgbgskjhfbsdkjfhjbdskfhbdskfjhbsdfkhsdbfskdhbfdskjf"
				+ "kjsjdbfkjdsbfsdkjffbsdkjfbsdskjbwgfowriybgvfwoiubvsldiufndslfhsdlfiubdssflkjdshg"
				+ "lskdjfbskdjfbsdkjfhvskfhbsdkfbdskfjbdsfkhdsbvkjdsbdskjfbsdkjfhbdsfkjhbsdkfjbdssdbj");
		a5 = new Archivo("Lorem ipsum dolor sit amet"
				+ " consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqu"
				+ "a Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo co"
				+ "nsequat Duis aute irurkjdbhfkjdsbfkljdbfkdjfbldkjfne d"
				+ "kdshbfkdshbfkjdsbfkdjfbdfksjdgfvkusydg"
				+ "lllllfolor in relprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariat");
		
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
    
    	e2.agregarArchivo(a2);
    	e3.agregarArchivo(a3);
    	e3.agregarArchivo(a4);
    	e4.agregarArchivo(a5);
    	
    	nico.recibirEmail(e);
    	nico.recibirEmail(e2);
    	nico.recibirEmail(e3);
    	nico.recibirEmail(e4);
    	
    	assertEquals(4, nico.getInbox().cantMails());
    	assertEquals (2, nico.getInbox().cantMailPequeños());
    	assertEquals (1, nico.getInbox().cantMailMedianos());
    	assertEquals(1, nico.getInbox().cantMailGrandes());
    
    }
    
    
    
}
