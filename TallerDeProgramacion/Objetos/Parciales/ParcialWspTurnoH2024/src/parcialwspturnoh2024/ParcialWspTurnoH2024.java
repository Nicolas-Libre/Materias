/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialwspturnoh2024;

/**
 *
 * @author Nicolas
 */
public class ParcialWspTurnoH2024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Supermercado chino = new Supermercado ("El mejor", "la plata", 2,3);
       
        Producto p1 = new Producto (22,"nico", "nike", 5,5);
        Producto p2 = new Producto (2,"pedro", "nike", 4,8);
        Producto p3 = new Producto (12,"brisa", "zara", 8,2);
        Producto p4 = new Producto (56,"anita", "gucci", 9,6);
        Producto p5 = new Producto (89,"wancho", "gabanna", 15,1);
        Producto p6 = new Producto (34,"palme", "tomy", 5,4);
        
        
        chino.agregarProducto(p1);
        chino.agregarProducto(p2);
        chino.agregarProducto(p3);
        chino.agregarProducto(p4);
        chino.agregarProducto(p5);
        chino.agregarProducto(p6);
        
        
        System.out.println(chino.listarProductoM("nike", 1));
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println("Gondola con mayor productos exhibidos= " + chino.mayorGondola());
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("");
        System.out.println(chino.toString());
    }
    
}
