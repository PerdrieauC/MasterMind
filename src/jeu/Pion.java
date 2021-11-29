package jeu;

import controller.Constantes;

import java.awt.*;
import java.io.Serializable;

/**
 * Classe qui représente un pion
 * Elle a comme attribut la couleur du pion
 */
public class Pion implements Serializable {
    private final int couleurIndex;

    public Pion(int couleur) {
        this.couleurIndex = couleur ;
    }

    public Color getCouleur() {
        return Constantes.colors[couleurIndex];
    }
    public int getCouleurIndex() {
        return couleurIndex;
    }

    /**
     * tableau de pion contient il la couleur donnée
     * @param c couleur à tester
     * @param pions tableau de pions
     * @return vrai si le tableau contient la couleur
     */
    public static boolean containsColor(int c, Pion[] pions){
        for(Pion p: pions){
            if(p!=null)if(p.getCouleurIndex()==c)return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return Constantes.colorsChar[this.couleurIndex];
    }
}
