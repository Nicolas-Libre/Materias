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
public abstract class Persona {
    private String Nombre;
    private double sueldo;
    private int antiguedad;

    public Persona(String Nombre, double sueldo, int antiguedad) {
        this.Nombre = Nombre;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    
    public double sueldoBasico(){
     return   (getSueldo() + 0.10 * (getSueldo() * getAntiguedad()));
    }
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar ();
    public String toString(){
        String aux;
        aux = "Nombre: " + getNombre() + ", sueldo a cobrar: " + calcularSueldoACobrar() + ", efectividad: " + calcularEfectividad();
        return aux; 
    }
    
}
