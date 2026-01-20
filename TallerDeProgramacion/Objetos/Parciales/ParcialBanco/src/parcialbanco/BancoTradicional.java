/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialbanco;

/**
 *
 * @author Nicolas
 */
public class BancoTradicional extends Banco {
    private String direccion;
    private String localidad;
    private int cantDuentasAbiertas=0;

    
    public BancoTradicional (String unNombre, int cantEmpleados, 
                                String unDireccion, String unLocalidad) {
        
        super (unNombre, cantEmpleados, 100);
        setDireccion (unDireccion);
        setLocalidad (unLocalidad);
        
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantDuentasAbiertas() {
        return cantDuentasAbiertas;
    }

    public void setCantDuentasAbiertas(int cantDuentasAbiertas) {
        this.cantDuentasAbiertas = cantDuentasAbiertas;
    }
    
    public boolean puedeRecibirTarjeta (int numCBU){
        Cuenta aux = super.obtenerCuenta (numCBU);
        boolean auxRetornable=false;
        if ((aux !=null) && (aux.getMoneda().equals ("dolares"))) {
            if (aux.getMonto() > 500) {
                auxRetornable =true;
            }
        }
        else if ((aux !=null) && (aux.getMoneda().equals ("pesos"))) {
            if (aux.getMonto() > 70000) {
                auxRetornable = true;
            }
        }
        return auxRetornable;
    }
}
