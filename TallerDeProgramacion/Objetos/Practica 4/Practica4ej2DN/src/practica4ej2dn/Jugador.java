/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej2dn;

/**
 *
 * @author Nicolas
 */
public class Jugador extends Persona {
    private int partidos;
    private int goles;

    public Jugador(int partidos, int goles, String Nombre, double sueldo, int antiguedad) {
        super(Nombre, sueldo, antiguedad);
        this.partidos = partidos;
        this.goles = goles;
    }

    public double calcularEfectividad() {
        return getGoles()/getPartidos();
    }
    
    public double calcularSueldoACobrar() {
        double aux =  super.sueldoBasico();
        if (this.calcularEfectividad() > 0.5) {
            aux += super.getSueldo();
        }
        return aux;
    }
    
    public String toString () {
        String aux = super.toString();
        aux+= " Soy Jugador";
        return aux;
    }
    
    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
    
}
