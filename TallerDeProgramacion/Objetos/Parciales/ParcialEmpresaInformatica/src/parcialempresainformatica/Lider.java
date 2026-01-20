/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialempresainformatica;

/**
 *
 * @author Nicolas
 */
public class Lider extends Programador {
    private int antiguedad;
    private int cantProyectosDirigidos; 
    
    
    
    
    public Lider (String unNombre, int unDni, double unSueldo, int unCodPorHora, 
            String unLenguaje, int unAntiguedad, int unCantProyectosDirigidos){
        super (unNombre,unDni, unSueldo, unCodPorHora, unLenguaje);
        setAntiguedad (unAntiguedad);
        setCantProyectosDirigidos (unCantProyectosDirigidos);
}

    
    public double sueldoFinalLider () {
        double aux = calcularSueldoFinal();
        aux += (10000 * getAntiguedad());
        aux += (20000 * getCantProyectosDirigidos());
        return aux;
    }
    
    
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getCantProyectosDirigidos() {
        return cantProyectosDirigidos;
    }

    public void setCantProyectosDirigidos(int cantProyectosDirigidos) {
        this.cantProyectosDirigidos = cantProyectosDirigidos;
    }
    
    public String toStringLider () {
        String aux; 
        aux = "Nombre: " + getNombre() + " DNI: " + getDni() +
                " Lenguaje preferido: " + getLenguaje() + " Sueldo final: "
                + sueldoFinalLider();
        return aux;
    }
    
    
}
