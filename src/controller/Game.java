package controller;

import jeu.Clue;
import jeu.Ligne;
import jeu.Plateau;

import java.io.Serializable;

/**
 * classe qui stock toute les informations d'une partie
 */
public class Game implements Serializable {
    private Plateau plateau;
    private int colorNumber;
    private boolean duplicate; //allow for 2 or more times the same color
    private boolean win;
    private boolean lose;

    public Game(String diff) {
        this.win=false;
        this.lose=false;
        int ligneSize = Constantes.rowSize.get(diff);
        int tryNumber = Constantes.numberRow.get(diff);
        this.colorNumber = Constantes.colorNumber.get(diff);
        this.duplicate = Constantes.remise.get(diff);
        Ligne secretCode = compute.getRandomCode(ligneSize, colorNumber, duplicate);
        this.plateau = new Plateau(ligneSize, tryNumber, colorNumber, secretCode);
    }

    /**
     * ajouter une ligne à la partie
     * genère aussi les indices associées
     * @param l ligne à insérer
     */
    public void inputLigne(Ligne l){
        if(l.getSize()==plateau.getLigneSize() && !win && !lose) {
            Clue tmpClue = compute.genClue(l, plateau.getSecretCode(), plateau.getLigneSize());
            if (!win) this.plateau.inputLigneAndClue(l, tmpClue);
            if (tmpClue.getPerfect() == plateau.getLigneSize()) win = true;
            else if (plateau.getInputSize() == plateau.getTryNumber()) lose = true;
        }
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

    public boolean isWin() {
        return win;
    }

    public boolean isLose() {
        return lose;
    }
    public boolean isPlaying() {
        return !win&&!lose;
    }
    @Override
    public String toString() {
        return "Game{" +
                ", colorNumber=" + colorNumber +
                ", duplicate=" + duplicate +
                ", gagne=" + win +
                ", perdu=" + lose +
                ", plateau=" + plateau +
                '}';
    }
}
