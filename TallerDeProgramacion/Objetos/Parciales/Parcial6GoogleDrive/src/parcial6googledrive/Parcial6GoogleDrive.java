/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial6GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Compra com = new Compra (2,5,8,2024,10);
        PorMayor PM = new PorMayor (22, "nico", 15, 4,6,2022,10);
        
        
        Producto prod1 = new Producto (4,"caca",5,22);
        Producto prod2 = new Producto (8,"bien",14,8);
        Producto prod3 = new Producto (2,"mal",1,18);
        Producto prod4 = new Producto (1,"maso",60,2);
        Producto prod5 = new Producto (3,"excelente",2,8);
        
        
        com.agregarProducto(prod3);
        com.agregarProducto(prod4);
        com.agregarProducto(prod5);
        
        
        System.out.println(com.toString());
        PM.agregarProducto(prod1);
        PM.agregarProducto(prod2);
        
        System.out.println("-------------------------");
        System.out.println(PM.toString());
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        System.out.println("La compra nomral es abonable en cuotas? " + com.abonableEnCuotas());
        System.out.println("La compra por mayor es abonable en cuotas? " + PM.abonableEnCuotas());
        
        
        
    }
    
}
