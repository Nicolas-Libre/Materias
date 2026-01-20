package Ejercicio9;

import java.util.*;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Farola {
	private boolean estado;
	private LinkedList<Farola> vecinas = new LinkedList<Farola>();

	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.setEstado(false);
	}
	/*
	* Crea la relación de vecinos entre las farolas. 
	* La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, 
	* al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		this.agregarVecina(otraFarola);
		otraFarola.agregarVecina(this);
	}

	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		if (vecinas != null) return vecinas;
		return new LinkedList<Farola>();
		
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (this.isOff()) {
			this.setEstado(true);
			if (vecinas != null) {
				for (int i=0; i< vecinas.size(); i++) {
						vecinas.get(i).setEstado(true);
				}
			}
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.isOn()) {
			this.setEstado(false);
			if (vecinas != null) {
				for (int i=0; i< vecinas.size(); i++) {
						vecinas.get(i).setEstado(false);
				
				}
			}
		}
	}

	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		if (estado==true) return true;
		return false;
	}

	/*
	* Retorna true si la farola está apagada.
	*/
	public boolean isOff() {
		if (estado==false) return true;
		return false;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void agregarVecina (Farola faro) {
		this.vecinas.add(faro);
	}
	
}
