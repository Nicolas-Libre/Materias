/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;

/**
 *
 * @author Nicolas
 */
public class Gira extends Recital{
    private String nombre;
    private Fecha [] vectorFechas;
    private int dimF;
    private int actual=0;
    
    public Gira (String banda, int temas, String unNombre, int cantFechas) {
        super (banda, temas);
        setNombre (unNombre);
        generarVector (cantFechas);
        setDimF (cantFechas);
    }
    
    public double calcularCosto () {
        double aux=0;
        aux = (getDimF() * 30000);
        return aux;
    }
    
    private void setDimF (int x) {
        this.dimF=x;
    }

    public int getDimF() {
        return dimF;
    }
    
    public String actuar () {
        String aux = "Buenas noches " + this.vectorFechas[actual].getCiudad() + "\n" +
                     super.actuar();
        actual = actual +1;
        return aux;
    }
    
    public void agregarFecha (Fecha f){
        int i=0;
        while (i < getDimF()) {
            if (this.vectorFechas [i] == null) {
                setVectorFechas (f,i);
                
                i=getDimF();
            }
            i++;
        }
    }
           
    private void generarVector (int nFechas){
        vectorFechas = new Fecha [nFechas];
    }           
    public Fecha[] getVectorFechas() {
        return vectorFechas;
    }

    public void setVectorFechas(Fecha y, int x) {
        this.vectorFechas[x] = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }






}
