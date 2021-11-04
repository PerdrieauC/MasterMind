package jeu;

import java.util.ArrayList;
import controller.*;

public class Plateau {
    private ArrayList<Ligne> listeLignes = new ArrayList<>();
    private ArrayList<Clue> listeClues = new ArrayList<>();
    private Ligne secretCode;
    private int ligneSize;
    private int tryNumber;
    private int colorNumber;

    public Plateau(String diff) {
        this.ligneSize = Constantes.rowSize.get(diff);
        this.tryNumber = Constantes.numberRow.get(diff);
        this.colorNumber = Constantes.colorNumber.get(diff);
        this.secretCode = compute.getRandomCode(ligneSize, colorNumber, Constantes.remise.get(diff));
    }
    public Plateau(int ligne_size, int try_size, int color_number, boolean remise) {
        this.ligneSize = ligne_size;
        this.tryNumber = try_size;
        this.colorNumber = color_number;
        this.secretCode = compute.getRandomCode(ligne_size, color_number, remise);
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
                ", color_number=" + colorNumber + "\n"+
                '}';
    }

}
