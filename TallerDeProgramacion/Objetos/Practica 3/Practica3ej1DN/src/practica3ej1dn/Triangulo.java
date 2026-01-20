/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej1dn;

/**
 *
 * @author Nicolas
 */
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String relleno;
    private String linea;

    
    public Triangulo (double unLado1, double unLado2, 
                        double unLado3, String unRelleno, String unaLinea){
        setLado1 (unLado1);
        setLado2(unLado2);
        setLado3(unLado3);
        setRelleno(unRelleno);
        setLinea(unaLinea);
    }

    
    public double CalcularPerimetro(){
        double aux;
        aux = getLado1() + getLado2() + getLado3(); 
        return aux;
    }
    
    public double CalcularArea () {
        double aux= CalcularPerimetro ()/2;
        aux = aux * (aux - getLado1()) * (aux - getLado2()) * (aux - getLado3());
        aux = Math.sqrt(aux);
        return aux;
        
        
    }
    
    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String getRelleno() {
        return relleno;
    }

    public String getLinea() {
        return linea;
    }
    
    
    
    
    
    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    
    
    
    
    
    
}
