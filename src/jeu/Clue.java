package jeu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe permet de stocker les informations sur les indices
 * elle comprend deux valeurs, perfect et good qui représente respectivemment
 * les pions de la bonne couleur à la bonne place(perfect)
 * les pions de la bonne couleur mais à la mauvaise place(good)
 */
public class Clue implements Serializable {
    private int perfect;
    private int good;

    public Clue(int perfect, int good) {
        this.perfect = perfect;
        this.good = good;
    }

    public int getPerfect() {
        return perfect;
    }

    public int getGood() {
        return good;
    }

    /**
     * Utilisée pour l'affichage.
     * @return une arraylist de boolean TRUE si perfect et FALSE si good, taille de l'arraylist=perfect+good
     */
    public ArrayList<Boolean> getList(){
        ArrayList<Boolean> res = new ArrayList<>();
        for(int i=0;i<perfect;i++){
            res.add(Boolean.TRUE);
        }
        for(int i=0;i<good;i++){
            res.add(Boolean.FALSE);
        }
        return res;
    }

    @Override
    public String toString() {
        return "{" +
                "perfect=" + perfect +
                ", good=" + good +
                "}\n";
    }
}
