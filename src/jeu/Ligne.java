package jeu;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * classe qui stock les informations d'une ligne de pions du mastermind
 * Elle a comme attribut une arraylist de Pion.
 */
public class Ligne implements Serializable {
    ArrayList<Pion> liste_pions = new ArrayList<>();

    public Ligne(){}
    public Ligne(Pion... pions) {
        liste_pions.addAll(Arrays.asList(pions));
    }

    /**
     * ajouter un pion à la suite dans ligne
     * @param p pion à ajouter
     */
    public void addPions(Pion p) {
        for(int i=0;i<getSize();i++) {
            if(liste_pions.get(i)==null){
                liste_pions.set(i,p);
                return;
            }
        }
        this.liste_pions.add(p);
    }

    /**
     * ajouter un pion à un index specifique
     * @param index index où inserer
     * @param p pion à inserer
     */
    public void addPions(int index,Pion p) {
        for(int i=getSize();i<=index;i++)liste_pions.add(null);
        this.liste_pions.remove(index);
        this.liste_pions.add(index,p);
    }

    /**
     * supprimer un pion de la ligne
     * @param n
     */
    public void removePion(int n){
        addPions(n,null);
    }

    /**
     * supprimer tous les pions de la ligne
     */
    public void clear(){this.liste_pions.clear();}
    public Pion getPion(int n) {
        if(n>=liste_pions.size())return null;
        return liste_pions.get(n);
    }

    /**
     * Taille d'une ligne (nb de pion)
     * @return
     */
    public int getSize(){return liste_pions.size();}

    /**
     * Est ce que la ligne ne contient pas de pion null
     * @return True si la ligne est pleine
     */
    public boolean isFull(){return !liste_pions.contains(null);}

    /**
     * La ligne contient elle une certaine couleur
     * @param c couleur
     * @return Vrai si la couleur est dans la ligne
     */
    public boolean containsColor(Color c){
        for (Pion p : liste_pions) {
            if (p.getCouleur() == c) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + liste_pions + "\n";
    }
}
