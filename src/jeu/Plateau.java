package jeu;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import controller.*;

public class Plateau implements Serializable {
    private ArrayList<Ligne> listeLignes = new ArrayList<>();
    private ArrayList<Clue> listeClues = new ArrayList<>();
    private Ligne secretCode;
    private int ligneSize;
    private int tryNumber;
    private int color_number;

    public Plateau(int ligne_size, int try_size, int color_number, Ligne secretCode) {
        this.ligneSize = ligne_size;
        this.tryNumber = try_size;
        this.secretCode = secretCode;
        this.color_number = color_number;
    }

    public int getInputSize(){
        return listeLignes.size();
    }
    public Ligne getLigne(int n) {
        return listeLignes.get(n);
    }
    public Clue getClue(int n) {
        return listeClues.get(n);
    }
    public Ligne getSecretCode() {
        return secretCode;
    }

    public int getLigneSize() {
        return ligneSize;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public int size(){
        return listeLignes.size();
    }

    public boolean ligneIndexExists(int index) {
        return index >= 0 && index < listeLignes.size();
    }

    public int getColor_number() {return color_number;}

    public void inputLigneAndClue(Ligne l, Clue c){
        if(getInputSize()< tryNumber) {
            listeLignes.add(l);
            listeClues.add(c);
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
