package Ejercicio25;
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
	
	
	public Integer cantMailPequeños() {
		Integer cantMailP = listaMails.stream()
				.filter(mail -> mail != null && mail.calcularTamañoMail() <= 300)
				.mapToInt(mail -> 1)
				.sum();
		return cantMailP;
	}
	
	public Integer cantMailMedianos () {
		Integer cantMailM = listaMails.stream()
				.filter(mail -> (mail != null) && (mail.calcularTamañoMail() > 300 && mail.calcularTamañoMail() <=500))
				.mapToInt(mail -> 1)
				.sum();
		return cantMailM;
	}
	
	public Integer cantMailGrandes () {
		Integer cantMailG = listaMails.stream()
				.filter(mail -> mail != null && mail.calcularTamañoMail() > 500)
				.mapToInt(mail -> 1)
				.sum();
		return cantMailG;
		
	}
	public Integer cantMails() {
		Integer cantidadMails = listaMails.stream().filter(mail -> mail!= null).mapToInt(mail -> 1).sum();
		return cantidadMails;
	}
	
	
	public void mover (Email e, Carpeta carpetaDestino) {
		Email e2 = new Email();
		int i=0;
		while (e2 != null && i < this.getListaMails().size() ) {
			e2 = this.getListaMails().get(i);
			if (e2.equals(e)) {
				carpetaDestino.almacenarMail(e);
				this.getListaMails().remove(i);
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
