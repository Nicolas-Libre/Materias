/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial1googleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DeGrado AdeG= new DeGrado ("Lic en sistema", 22, "Nico", 18);
        DeDoctorado AdeD = new DeDoctorado ("Contadora", "UNLP", 956, "Anita", 40);
        
        Materia mat1 = new Materia ("Taller", 8, "2024");
        Materia mat2 = new Materia ("CADP", 6, "2024");
        Materia mat3 = new Materia ("AC", 5, "2025");
        Materia mat4 = new Materia ("COC", 9, "2023");
        Materia mat5 = new Materia ("Mate 1", 10, "2023");
        Materia mat6 = new Materia ("Estadistica", 8, "2000");
        Materia mat7 = new Materia ("Psicologia", 6, "1998");
        Materia mat8 = new Materia ("Rol social", 9, "2001");
        Materia mat9 = new Materia ("Sociologia", 10, "1994");
        Materia mat10 = new Materia ("Tesis", 4, "2000");
        
        AdeG.agregarMateriaAprobada(mat1);
        AdeG.agregarMateriaAprobada(mat2);
        AdeG.agregarMateriaAprobada(mat3);
        AdeG.agregarMateriaAprobada(mat4);
        AdeG.agregarMateriaAprobada(mat5);
        
        System.out.println(AdeG.estaGraduado(4));
        AdeD.agregarMateriaAprobada(mat6);
        AdeD.agregarMateriaAprobada(mat7);
        AdeD.agregarMateriaAprobada(mat8);
        AdeD.agregarMateriaAprobada(mat9);
        AdeD.agregarMateriaAprobada(mat10);
        
        System.out.println(AdeG.toString());
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.println(AdeD.toString());
        
    }
    
}
