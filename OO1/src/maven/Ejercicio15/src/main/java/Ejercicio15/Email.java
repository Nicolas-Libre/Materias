package Ejercicio15;
import java.util.*;
public class Email {

	private String titulo;
	private String cuerpo;
	private LinkedList<Archivo> listaArchivos = new LinkedList<Archivo>();
	
	public void agregarArchivo (Archivo a) {
		this.getListaArchivos().add(a);
	}
	
	public Integer calcularTamañoMail() {
		Integer tamañoMail = 0;
		if (this.getListaArchivos() != null) {
			for (int i=0; i< this.getListaArchivos().size(); i++) {
				Archivo a = this.getListaArchivos().get(i);
				tamañoMail += a.tamaño();
			}
		}
		tamañoMail+= this.getCuerpo().length();
		tamañoMail+= this.getTitulo().length();
		return tamañoMail;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public LinkedList<Archivo> getListaArchivos() {
		return listaArchivos;
	}
	
	
	
	
	
}
