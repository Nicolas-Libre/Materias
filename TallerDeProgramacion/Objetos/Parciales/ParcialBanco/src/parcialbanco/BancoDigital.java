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
public class BancoDigital extends Banco {
    private String direccionWeb;

    
    
    public BancoDigital (String unNombre, int cantEmpleados, int cantCuentas,
                            String unDireccionWeb){
        super (unNombre, cantEmpleados, cantCuentas);
        setDireccionWeb(unDireccionWeb);
    }
    
    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }
    
    public boolean puedeRecibirTarjeta (int numCBU) {
        Cuenta aux = super.obtenerCuenta (numCBU);
        boolean auxRetornable=false;
        if ((aux!=null) && (aux.getMoneda().equals ("pesos"))){
            if (aux.getMonto() > 100000) {
                auxRetornable =true;
            }
        }
      
        return auxRetornable;
    }
}
