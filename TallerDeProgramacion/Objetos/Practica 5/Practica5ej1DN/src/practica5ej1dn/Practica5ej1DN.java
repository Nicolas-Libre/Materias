/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1dn;

/**
 *
 * @author Nicolas
 */
public class Practica5ej1DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Investigador in1 = new Investigador ("Bri", 1, "bioquimica" );
        Investigador in2 = new Investigador ("Pedro", 2, "Contador" );
        Investigador in3 = new Investigador ("Anita", 5, "Contadora" );
        
        Subsidio sub1 = new Subsidio (2,"mal paga");
        Subsidio sub2 = new Subsidio (7, "quiro plata");
        Subsidio sub3 = new Subsidio (3, "porque si");
        
        in1.agregarSubsidio(sub1);
        in1.agregarSubsidio(sub3);
        
        in2.agregarSubsidio(sub2);
        in2.agregarSubsidio(sub3);
        
        in3.agregarSubsidio(sub1);
        in3.agregarSubsidio(sub2);
        
        Proyecto pro = new Proyecto ("Familia", 22, "Nico");
        pro.agregarInvestigador(in1);
        pro.agregarInvestigador(in2);
        pro.agregarInvestigador(in3);
        
        pro.otorgarTodos("Bri");
        pro.otorgarTodos("Pedro");
        pro.otorgarTodos("Anita");
        
        System.out.println(pro.toString());
        
    }
    
}
