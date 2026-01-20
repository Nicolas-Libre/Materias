package Ejercicio21;
import java.util.*;

import java.time.*;
public abstract class Cliente {
	private String nombre;
	private String direccion;
	private LinkedList<Envio> listaEnvios;
	
	
	public Cliente (String n, String d) {
		this.setDireccion(d);
		this.setNombre(n);
		this.setListaEnvios();
	}
	
	
	public void addEnvio(Envio e) {
		this.getListaEnvios().add(e);
	}
 
	
	public Double calcularMontoPeriodo (LocalDate inicio, LocalDate fin) {
		Double montoTotal = 0.0;
		if (((listaEnvios != null) && (!this.getListaEnvios().isEmpty()))) {
			for (int i=0; i< this.getListaEnvios().size(); i++) {
				LocalDate despacho = this.getListaEnvios().get(i).getFechaDespacho();
				if ((despacho.isAfter(inicio) && despacho.isBefore(fin)) || ((despacho.equals(inicio)) || despacho.equals(fin))) {
					montoTotal += this.getListaEnvios().get(i).calcularCosto();
				}	
			}
		}
		return montoTotal;
	}


	public LinkedList<Envio> getListaEnvios() {
		return listaEnvios;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setListaEnvios() {
		this.listaEnvios = new LinkedList<Envio>();
	}

	
	
	
}
