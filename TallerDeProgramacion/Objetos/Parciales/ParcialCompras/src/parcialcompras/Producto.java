/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialcompras;

/**
 *
 * @author Nicolas
 */
public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;

    public Producto (int unCodigo, double unPrecio, String unaDescripcion) {
        setCodigo (unCodigo);
        setPrecio (unPrecio);
        setDescripcion (unaDescripcion);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString () {
        String aux;
        aux = "Codigo: " + getCodigo() + ", Precio: " 
                + getPrecio() + ", Descripcion: " + getDescripcion();
        return aux;
    }
}
