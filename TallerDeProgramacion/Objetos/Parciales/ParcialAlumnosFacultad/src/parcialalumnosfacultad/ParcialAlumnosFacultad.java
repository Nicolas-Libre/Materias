/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalumnosfacultad;

/**
 *
 * @author Nicolas
 */
public class ParcialAlumnosFacultad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AdeGrado AG = new AdeGrado (2,"nico", 3, "lic en sistemas");
        AdeDoctorado AD = new AdeDoctorado (4,"bri", 3, "Bioquimica", "UNLP");
        
        Materia m1 = new Materia ("taller", 8, "este año");
        Materia m2 = new Materia ("cadp", 6, "año pasado");
        Materia m3 = new Materia ("software", 4, "año que viene");
        
        Materia des1 = new Materia ("caca", 2, "burro");
        
        Materia bri1 = new Materia ("micro", 10, "este año");
        Materia bri2 = new Materia ("farmaco", 8, "2024");
        Materia bri3 = new Materia ("bio 1", 7, "2023");
        
        AG.agregarMateria(m1);
        AG.agregarMateria (m2);
        AG.agregarMateria (m3);
        
        AG.agregarMateria (des1);
        System.out.println(AG.toString());
        
        AD.agregarMateria (bri1);
        AD.agregarMateria (bri2);
        AD.agregarMateria (bri3);
        
        System.out.println(AD.toString());
    }
    
}
