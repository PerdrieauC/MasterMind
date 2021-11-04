package controller;

import jeu.Ligne;
import jeu.Plateau;

public class Game {
    private Plateau plateau;
    private int colorNumber;
    private boolean duplicate; //allow for 2 or more times the same color
    private boolean gagne;

    public Game(String diff) {
        this.gagne=false;
        int ligneSize = Constantes.rowSize.get(diff);
        int tryNumber = Constantes.numberRow.get(diff);
        this.colorNumber = Constantes.colorNumber.get(diff);
        this.duplicate = Constantes.remise.get(diff);
        Ligne secretCode = compute.getRandomCode(ligneSize, colorNumber, duplicate);
        this.plateau = new Plateau(ligneSize, tryNumber, colorNumber, secretCode);
    }

    public void inputLigne(Ligne l){
        if(!gagne)this.plateau.inputLigne(l);
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public int getColorNumber() {
        return colorNumber;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public boolean isGagne() {
        return gagne;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", colorNumber=" + colorNumber +
                ", duplicate=" + duplicate +
                ", gagne=" + gagne +
                "plateau=" + plateau +
                '}';
    }
}
