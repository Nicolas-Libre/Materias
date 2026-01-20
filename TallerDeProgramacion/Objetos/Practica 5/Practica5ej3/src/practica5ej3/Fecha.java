/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;

/**
 *
 * @author Nicolas
 */
public class Fecha {
    private String ciudad;
    private int dia;

    
    
    public Fecha (String unaCiudad, int unDia){
        setCiudad (unaCiudad);
        setDia (unDia);
    }
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }



}
