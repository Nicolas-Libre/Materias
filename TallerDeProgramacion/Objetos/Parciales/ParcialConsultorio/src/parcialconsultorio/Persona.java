/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconsultorio;

/**
 *
 * @author Nicolas
 */
public abstract class Persona {
    private int dni;
    private String apellido;
    private String nombre;
    private int numTel;

    public Persona (int unDni, String unApellido, String unNombre, int unNumTel) {
        setDni (unDni);
        setApellido (unApellido);
        setNombre (unNombre);
        setNumTel (unNumTel);
        
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
    
    
    public String toString(){
        String aux;
        aux =" Dni: " + getDni()+ " Apellido: " + getApellido() + " Nombre: " + getNombre()
                + " Telefono: " + getNumTel();
        return aux;
    }
}
    
    

