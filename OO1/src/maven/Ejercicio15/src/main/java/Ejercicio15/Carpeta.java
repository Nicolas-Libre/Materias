package Ejercicio15;
import java.util.*;


public class Carpeta {
	
	private LinkedList<Email> listaMails = new LinkedList<Email>();
	
	public void almacenarMail (Email e) {
		this.listaMails.add(e);
	}
	
	public Email buscarEnListaMail (String texto) {
		for (int i=0; i< this.getListaMails().size(); i++) {
			Email e = this.getListaMails().get(i);
			if (e != null && (e.getTitulo().equals(texto) || e.getCuerpo().equals(texto))) {
				return e;
			}
		}
		return null;
		
		
	}
	
	
	public void mover (Email e, Carpeta carpetaDestino) {
		Email e2 = new Email();
		int i=0;
		while (e2 != null && i < this.getListaMails().size() ) {
			e2 = this.getListaMails().get(i);
			if (e2.equals(e)) {
				carpetaDestino.almacenarMail(e);
				e2 = null;
				this.getListaMails().add(i, null);
			}
			i++;
		}
	}
	

	public Integer calcularTamañoCarpeta() {
		Integer tamañoCarpeta = 0;
		if (this.getListaMails() != null) {
			for (int i=0; i< this.getListaMails().size(); i++) {
				Email e = this.getListaMails().get(i);
				tamañoCarpeta += e.calcularTamañoMail();
			}
		}
		return tamañoCarpeta;
	}
	
	
	public LinkedList<Email> getListaMails() {
		return listaMails;
	}
	
	
}
