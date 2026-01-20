package parcialconcursobaile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class Pareja {
    private Participante par1;
    private Participante par2;
    private String estilo;
    
    public Pareja (Participante unPar1, Participante unPar2, String unEstilo) {
        setPar1 (unPar1);
        setPar2 (unPar2);
        setEstilo (unEstilo);
    }
    
    
    public int difEdad() {
        int aux=0;
        if (par1.getEdad() > par2.getEdad()) {
            aux = par1.getEdad() - par2.getEdad();
        }
        else if (par1.getEdad() < par2.getEdad()) {
            aux= par2.getEdad() - par1.getEdad();
        }
       return aux; 
    }
    
    
    public Participante getPar1() {
        return par1;
    }

    public void setPar1(Participante par1) {
        this.par1 = par1;
    }

    public Participante getPar2() {
        return par2;
    }

    public void setPar2(Participante par2) {
        this.par2 = par2;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    public String toString () {
        String aux;
        aux = "Participante 1: " + getPar1().getNombre() + "\n" +
                "Participante 2: " + getPar2().getNombre();
        return aux;
    }
}
