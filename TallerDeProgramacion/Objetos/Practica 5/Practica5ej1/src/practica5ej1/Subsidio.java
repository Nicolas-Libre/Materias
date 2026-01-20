/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1;

/**
 *
 * @author Nicolas
 */
public class Subsidio {
    private double montoPedido;
    private String motivo;
    private boolean fueOtorgado = false;

    public Subsidio (double montoPedido, String motivo) {
        setMontoPedido (montoPedido);
        setMotivo (motivo);

    }
    
    
    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isFueOtorgado() {
        return fueOtorgado;
    }

    public void setFueOtorgado(boolean fueOtorgado) {
        this.fueOtorgado = fueOtorgado;
    }
    
    
}
