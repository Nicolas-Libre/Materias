/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6googledrive;

/**
 *
 * @author Nicolas
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantUnidades;

    public Producto(int codigo, String descripcion, double precioUnitario, int cantUnidades) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecioUnitario(precioUnitario);
        setCantUnidades(cantUnidades);
    }

    public double precioFinal () {
        return this.precioUnitario * this.cantUnidades;
    }
    
    
    public String toString (){
        String aux = "codigo= " + getCodigo() + ", descripcion = " + getDescripcion();
        return aux;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantUnidades() {
        return cantUnidades;
    }

    public void setCantUnidades(int cantUnidades) {
        this.cantUnidades = cantUnidades;
    }
    
    
    
    
    
}
