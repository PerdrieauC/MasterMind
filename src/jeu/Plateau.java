package jeu;

import java.util.ArrayList;
import controller.*;

public class Plateau {
    private ArrayList<Ligne> listeLignes = new ArrayList<>();
    private ArrayList<Clue> listeClues = new ArrayList<>();
    private Ligne secretCode;
    private int ligneSize;
    private int tryNumber;

    public Plateau(int ligne_size, int try_size, int color_number, Ligne secretCode) {
        this.ligneSize = ligne_size;
        this.tryNumber = try_size;
        this.secretCode = secretCode;
    }
    public Ligne get_ligne(int n) {
        return listeLignes.get(n);
    }

    public int size(){
        return listeLignes.size();
    }

    public void inputLigne(Ligne l){
        if(listeLignes.size()< tryNumber) {
            listeLignes.add(l);
            listeClues.add(compute.genClue(l, secretCode, ligneSize));
        }
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "liste_lignes=\n " + listeLignes + "\n"+
                ", liste_clues=\n " + listeClues + "\n"+
                ", secret_code=" + secretCode + "\n"+
                ", ligne_size=" + ligneSize + "\n"+
                ", try_size=" + tryNumber + "\n"+
                '}';
    }

}
