/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconcursobaile;

/**
 *
 * @author Nicolas
 */
public class ParcialConcursoBaile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Concurso c = new Concurso (2);
        Participante par1 = new Participante (2,"nico",20);
        Participante par2 = new Participante (5, "bri", 21);
        Participante par3 = new Participante (8, "juancito", 27);
        Participante par4 = new Participante (22,"mongaly", 38);
        
        Pareja pareja1 = new Pareja (par1, par2, "cuarteto");
        Pareja pareja2 = new Pareja (par3,par4, "cuarteto");
        
        c.agregarPareja(pareja1);
        c.agregarPareja (pareja2);
        
        System.out.println("La diferencia de edad mas grande es la de la pareja numero " + (c.mayorDifEdad()+1));
        System.out.println("Los participantes de esta pareja son " + "\n" + c.getVectorParejas()[c.mayorDifEdad()].toString());
        System.out.println("Pero los ganadores del concurso de baile son: " + "\n" +c.getVectorParejas()[0].toString());
        
        
        
    }
    
}
