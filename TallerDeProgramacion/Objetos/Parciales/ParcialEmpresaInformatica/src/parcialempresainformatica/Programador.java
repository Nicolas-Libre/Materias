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
public class Programador {
    private String nombre;
    private int dni;
    private double sueldo;
    private int codPorHora;
    private String lenguaje;
    

    

    public Programador (String unNombre, int unDni, double unSueldo, int unCodPorHora, 
            String unLenguaje) {
        setNombre (unNombre);
        setDni (unDni);
        setSueldo (unSueldo);
        setCodPorHora (unCodPorHora);
        setLenguaje (unLenguaje);
    }
    
    public double calcularSueldoFinal () {
        double aux = getSueldo();
        if (getCodPorHora() > 200) {
            aux += 50000;
        }     
        return aux;
    }
    

    
    public void aumentarSueldo (double M) {
        double aux =(getSueldo() +M);
        setSueldo (aux);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getCodPorHora() {
        return codPorHora;
    }

    public void setCodPorHora(int codPorHora) {
        this.codPorHora = codPorHora;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    
    
    public String toString () {
        String aux;
        aux = " Nombre: " + getNombre() + " DNI: " + getDni() +
                " Lenguaje preferido: " + getLenguaje() + " Sueldo final: " 
                + calcularSueldoFinal();
        return aux;
    }
    

    
    
}
