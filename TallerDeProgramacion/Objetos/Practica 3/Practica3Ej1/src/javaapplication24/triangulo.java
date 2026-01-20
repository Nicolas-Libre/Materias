/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;

/**
 *
 * @author Nicolas
 */
public class triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    private double perimetro;
    private double area;   
    
    public triangulo ( double unLado1, double unLado2, double unLado3, String unColorRelleno, String unColorLinea ){
        lado1 = unLado1;
        lado2 = unLado2;
        lado3 = unLado3;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;

    }
    public triangulo () {
        
    }
    
    public double getLado1() {
        return lado1;
    }
    
    public double getLado2() {
        return lado2;
    }
    
    public double getLado3 () {
        return lado3;
    }
    
    
    public String getColorRelleno () {
        return colorRelleno;
    }
    
    public String getColorLinea() {
        return colorLinea;
    }
    
    public void setLado1(double unLado1) {
        lado1 = unLado1;      
    }
   
    public void setLado2(double unLado2) {
        lado2 = unLado2;      
    } 
    
    public void setLado3(double unLado3) {
        lado3 = unLado3;      
    }
    
    public void setColorRelleno (String unColorRelleno) {
        colorRelleno = unColorRelleno;      
    }
    
    public void setColorLinea (String unColorLinea) {
        colorLinea = unColorLinea;
        
    }
   
    public double calcularPerimetro () {
        perimetro = (lado1 + lado2 + lado3);
        return perimetro;
    } 
    
    public double calcularArea () {
        double auxA = (perimetro * ((perimetro - lado1) * (perimetro - lado2) * (perimetro - lado3) ));
        double i;
        double raiz=1;
        for (i=1; i <= auxA; i++){
            if (i*i == auxA) {
                raiz = i; 
                i = auxA+1;
            }
        }
        area = raiz;
        return area;
    }
@Override
    public String toString(){
        String aux;
        aux = "Lado 1 vale " + lado1 + ", Lado 2 vale " +  lado2 + " y el Lado 3 vale  " + lado3  ;
        aux +=   "El color del relleno es " + colorRelleno + " y el de las lineas es " + colorLinea + ". " + " El perimetro es  " + calcularPerimetro() + " y el area es " + calcularArea();
        return (aux);
    }

}
