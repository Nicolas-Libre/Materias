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
public class ParcialCompras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ComprasMayoristas CM = new ComprasMayoristas (22, 3, 56);
        
        Producto ProdCM1 = new Producto (15,26,"caca");
        Producto ProdCM2 = new Producto (4,8,"colitis");
        Producto ProdCM3 = new Producto (87,1,"diarrea");
        
        CM.agregarProducto (ProdCM1);
        CM.agregarProducto (ProdCM2);
        CM.agregarProducto (ProdCM3);
        
        ComprasMinoristas CMino = new ComprasMinoristas (19,3, true);
        
        Producto ProdCMino1 = new Producto (2,23,"caca");
        Producto ProdCMino2 = new Producto (1,58,"colitis");
        Producto ProdCMino3 = new Producto (512,46,"diarrea");
        
        CMino.agregarProducto (ProdCMino1);
        CMino.agregarProducto (ProdCMino2);
        CMino.agregarProducto (ProdCMino3);
        
        System.out.println(CM.toString());
        System.out.println("--------------------------------------------");
        System.out.println(CMino.toString());
    }
    
}
