/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4googledrive;

/**
 *
 * @author Nicolas
 */
public class Digital extends Banco {
    private String paginaWeb;

    public Digital(String paginaWeb, String nombre, int cantEmpleados, int N) {
        super(nombre, cantEmpleados, N);
        setPaginaWeb(paginaWeb);
    }

    public boolean puedeRecibirTarjeta(int CBU) {
        Cuenta aux = super.obtenerCuenta(CBU);
        boolean auxB;
        if ((aux.getMoneda().equals("pesos")) && (aux.getMonto() > 100000)) {
            auxB= true;
        }
        else
            auxB= false;
        return auxB;
    }
    
    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
    
    
}
