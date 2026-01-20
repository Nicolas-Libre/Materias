/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconciertos;

/**
 *
 * @author Nicolas
 */
public class Concierto {
    private String artista;
    private double precioEntrada;
    private int cantVendidas;

    
    public Concierto (String unArtista, double unPrecioEntrada, int unCantVendidas){
        setArtista (unArtista);
        setPrecioEntrada (unPrecioEntrada);
        setCantVendidas (unCantVendidas);
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getCantVendidas() {
        return cantVendidas;
    }

    public void setCantVendidas(int cantVendidas) {
        this.cantVendidas = cantVendidas;
    }

    
    public String toString() {
        String aux;
        aux =   "Artista: " + getArtista() + ", precioEntrada: " + getPrecioEntrada() + 
                ", cantVendidas: " + getCantVendidas();
        return aux;
    }
    
    
    
}
