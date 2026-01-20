package Ejercicio25;
import java.util.*;
/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class ClienteDeCorreo {
	
	public Carpeta inbox = new Carpeta();
	public LinkedList<Carpeta> listaCarpetas = new LinkedList<Carpeta>();
	
	public void recibirEmail (Email e) {
		this.inbox.almacenarMail(e);
	}
	
	public int cantMails() {
		Integer cantidadMail = this.getInbox().cantMails();
		for (Carpeta c: this.getListaCarpetas()) {
			cantidadMail += c.cantMails();
		}
		return cantidadMail;
	}
	
	public Email buscar (String texto) {
		Email e = this.getInbox().buscarEnListaMail(texto);
		if (e != null) {
			return e;
		}
		for (int j=0; j< listaCarpetas.size(); j++) {
			Carpeta c = listaCarpetas.get(j);
			Email e2 = c.buscarEnListaMail(texto);
			if (e2 != null) {
				return e2;
			}
		}
		return null;
	}
	
	public Integer espacioOcupado() {
		Integer tamañoTotal=0;
		tamañoTotal += inbox.calcularTamañoCarpeta();
		if (this.getListaCarpetas() != null) {
			for (int i =0; i< listaCarpetas.size(); i++) {
				Carpeta c = listaCarpetas.get(i);
				tamañoTotal += c.calcularTamañoCarpeta();
			}
		}
		return tamañoTotal;
	}

	public Carpeta getInbox() {
		return inbox;
	}

	public LinkedList<Carpeta> getListaCarpetas() {
		return listaCarpetas;
	}

}
