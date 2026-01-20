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
public class Entrenador extends Empleado {
    private int campeonatosGanados;

    
    public Entrenador (String unNombre, double unPrecio, int unAntiguedad, int cantChampG){
        super (unNombre, unPrecio, unAntiguedad);
        setCampeonatosGanados(cantChampG);
        
    }
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

    public double calcularEfectividad (){
         double auxCuenta = (getCampeonatosGanados() / (double) super.getAntiguedad());
        return auxCuenta;
    }
    
    public double calcularSueldoACobrar() {
            double aux= super.getSueldo() + (super.getSueldo() * 1.10 * (double) super.getAntiguedad());
            if (this.campeonatosGanados != 0) {
                if (this.campeonatosGanados < 5) {
                    aux = aux + (super.getSueldo() + 5000);
                    }
                else if (this.campeonatosGanados <=10) {
                    aux = aux + (super.getSueldo() + 30000);
                }
                    else aux = aux + (super.getSueldo() + 50000);
            }
            
            return aux;
    }
    public String toString() {
        String aux = super.toString() +
                     " Campeonatos ganados: " + getCampeonatosGanados();
        return aux;
        
    }
    
    
    
    
}
