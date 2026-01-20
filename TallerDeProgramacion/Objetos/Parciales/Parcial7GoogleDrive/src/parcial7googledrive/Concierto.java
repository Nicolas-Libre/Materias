/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7googledrive;

/**
 *
 * @author Nicolas
 */
public class Concierto {
    private String artista;
    private double entrada;
    private int cantVendidas;

    public Concierto(String artista, double entrada, int cantVendidas) {
        setArtista(artista);
        setEntrada(entrada);
        setCantVendidas(cantVendidas);
    }

    
    public String toString (){
        String aux = "Artista: " + getArtista() + ", precio de la entrada: " + getEntrada() + ", cantidad de entradas vendidas: "  + getCantVendidas();
        return aux;
    }
    
    public double calcularPrecioFinal (){
        double aux;
        aux = (double) getCantVendidas() * getEntrada();
        return aux;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public int getCantVendidas() {
        return cantVendidas;
    }

    public void setCantVendidas(int cantVendidas) {
        this.cantVendidas = cantVendidas;
    }
    
    
    
    
}
