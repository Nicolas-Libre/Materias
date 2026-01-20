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
public class Practica5ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Proyecto pro = new Proyecto ("cacona", 2222, "Nico");
        
        Investigador i1 = new Investigador ("juan", 5, "baske");
        
        Subsidio s1 = new Subsidio (22.0, "porque si");
        
        Subsidio s2 = new Subsidio (23, "porque no");
        
        s1.setFueOtorgado (true);
        
        i1.agregarSubsidio (s1);
        
        Investigador i2 = new Investigador ("brisa", 4, "voley");
        
        Subsidio s3 = new Subsidio (25.0, "porque caca");
        
        Subsidio s4 = new Subsidio (23, "porque quiero");
        
        s4.setFueOtorgado (true);
        
        i2.agregarSubsidio(s4);
        
        Investigador i3 = new Investigador ("mama", 2, "mamuna");
        
        Subsidio s5 = new Subsidio (22.0, "porque si");
        
        Subsidio s6 = new Subsidio (29, "porque a veces");
        
        s6.setFueOtorgado (true);
        
        i3.agregarSubsidio(s6);
        
        pro.agregarInvestigaor (i1);
        pro.agregarInvestigaor (i2);
        pro.agregarInvestigaor (i3);
        
        System.out.println(pro.getDimL());
        System.out.println(pro.toString());
        pro.imprimirVector();
        
    }
    
}
