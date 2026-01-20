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
public class Entrenador extends Persona {
    private int campeonatos;

    public Entrenador(int campeonatos, String Nombre, double sueldo, int antiguedad) {
        super(Nombre, sueldo, antiguedad);
        this.campeonatos = campeonatos;
    }

    public double calcularEfectividad () {
        return getCampeonatos() / super.getAntiguedad();
    }
    
    public double calcularSueldoACobrar () {
        double aux = super.sueldoBasico();
        if (getCampeonatos() != 0) {
            if ((getCampeonatos() >= 1) && (getCampeonatos() <5)) {
                aux+= 5000;
            }
            else
                if (getCampeonatos() <= 10) {
                    aux +=30000;
                }
                else
                    aux += 50000;
                   
        }
        return aux;
    }
    
    public String toString () {
        String aux = super.toString();
        aux+= " Soy Entrenador";
        return aux;
    }
    
    
    public int getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(int campeonatos) {
        this.campeonatos = campeonatos;
    }
    
    
}
