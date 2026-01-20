/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialwspturnoh2024;

/**
 *
 * @author Nicolas
 */
public class Producto {
    private int codigo;
    private String nombre;
    private String marca;
    private int cantUni;
    private double precioUni;

    public Producto(int codigo, String nombre, String marca, int cantUni, double precioUni) {
        setCodigo(codigo);
        setNombre(nombre);
        setMarca(marca);
        setCantUni(cantUni);
        setPrecioUni(precioUni);
    }

    @Override
    public String toString() {
        return"codigo= " + getCodigo() + ", nombre= " + getNombre() + ", marca= " + getMarca() + ", cantUni= " + getCantUni() + ", precioUni= " + getPrecioUni();
        
    }

    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantUni() {
        return cantUni;
    }

    public void setCantUni(int cantUni) {
        this.cantUni = cantUni;
    }

    public double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }
    
    
    
    
    
}
