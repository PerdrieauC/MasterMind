package jeu;

import controller.Constantes;

import java.awt.*;
import java.io.Serializable;

/**
 * Classe qui représente un pion
 * Elle a comme attribut la couleur du pion
 */
public class Pion implements Serializable {
    private final Color couleur;

    public Pion(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    /**
     * tableau de pion contient il la couleur donnée
     * @param c couleur à tester
     * @param pions tableau de pions
     * @return vrai si le tableau contient la couleur
     */
    public static boolean containsColor(Color c, Pion[] pions){
        for(Pion p: pions){
            if(p!=null)if(p.getCouleur()==c)return true;
        }
        return false;
    }
    @Override
    public String toString(){
        for(int i = 0; i< Constantes.colorsNumber; i++){
            if(this.couleur==Constantes.colors[i]){
                return Constantes.colorsChar[i];
            }
        }
        return null;
    }
}
