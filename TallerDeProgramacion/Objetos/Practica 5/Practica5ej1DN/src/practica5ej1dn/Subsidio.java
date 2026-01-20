/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1dn;

/**
 *
 * @author Nicolas
 */
public class Subsidio {
    private double monto;
    private String motivo;
    private boolean otorgado = false;

    public Subsidio(double monto, String motivo) {
        setMonto(monto);
        setMotivo(motivo);
    }

    
    
    
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
    
}
