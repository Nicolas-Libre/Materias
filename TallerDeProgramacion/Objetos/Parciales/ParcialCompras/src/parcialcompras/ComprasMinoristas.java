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
public class ComprasMinoristas extends Compras {
    private boolean esJubilado;

    public ComprasMinoristas (int unNumero, int cantProductos, boolean Jubi) {
        super (unNumero, cantProductos);
        setEsJubilado (Jubi);
    }
    public boolean isEsJubilado() {
        return esJubilado;
    }

    public void setEsJubilado(boolean esJubilado) {
        this.esJubilado = esJubilado;
    }
    
    private String stringJubilado () {
        String aux;
        if (esJubilado == true) {
            aux = "Es jubilado";
        }
        else {
            aux = "No es jubilado";
        }
        return aux;
    }
    
    public String toString () {
        String aux = "Compra Minorista: ";
        aux +=  super.toString() + "\n" +
                stringJubilado();
    
        return aux;
    } 
    
    
}
