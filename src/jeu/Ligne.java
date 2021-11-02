package jeu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ligne {
    ArrayList<Pion> liste_pions = new ArrayList<>();

    public Ligne(Pion... pions) {
        liste_pions.addAll(Arrays.asList(pions));
    }

    public Pion getPion(int n) {
        return liste_pions.get(n);
    }

    public boolean containsColor(Color c){
        for (Pion liste_pion : liste_pions) {
            if (liste_pion.getCouleur() == c) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "" + liste_pions + "\n";
    }
}
