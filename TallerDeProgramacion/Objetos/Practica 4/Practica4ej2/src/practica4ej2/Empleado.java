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
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;
    
    
    
    public Empleado (String unNombre, double unSueldo, int unAntiguedad){
        setNombre (unNombre);
        setSueldo (unSueldo);
        setAntiguedad (unAntiguedad);
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }


    public String toString() {
        String aux = "Empleado: " + 
                     "nombre: " + nombre + 
                     ", sueldo: " + sueldo + 
                     ", antiguedad: " + antiguedad +
                     ", tiene una efectividad de: " + this.calcularEfectividad() +
                     ", el sueldo a cobrar por lo que hizo es: " + this.calcularSueldoACobrar();
        return aux;
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
}
