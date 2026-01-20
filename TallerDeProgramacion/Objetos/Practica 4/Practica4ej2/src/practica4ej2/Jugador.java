/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej2;

/**
 *
 * @author Nicolas
 */
public class Jugador extends Empleado{
    private int partidosJugados;
    private int golesAnotados;


public Jugador (String unNombre, double unPrecio, int unAntiguedad, int cantPJ, int cantGoles) {
    super (unNombre,unPrecio,unAntiguedad);
    setPartidosJugados (cantPJ);
    setGolesAnotados(cantGoles);
    
}

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    public double calcularEfectividad () {
        return ((double) getGolesAnotados() / (double) getPartidosJugados());
    }
    
    public double calcularSueldoACobrar () {
        double aux = super.getSueldo() + (super.getSueldo() * 1.10 * (double) super.getAntiguedad());
        if (this.calcularEfectividad() > 0.5) {
            aux = aux + super.getSueldo();
        }
        return aux;
    }
    public String toString() {
        String aux = super.toString() +
                     " Partidos jugados: " + getPartidosJugados() +
                     ", Goles Anotados: " + getGolesAnotados();
        return aux;
        
        
    }
}
