package jeu;

import controller.Constantes;

import java.awt.*;
import java.io.Serializable;

public class Pion implements Serializable {
    private final Color couleur;

    public Pion(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

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
