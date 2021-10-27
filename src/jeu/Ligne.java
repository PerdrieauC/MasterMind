package jeu;

import java.util.ArrayList;
import java.util.Arrays;

public class Ligne {
    ArrayList<Pion> liste_pions = new ArrayList<>();

    public Ligne(Pion ... pions) {
        liste_pions.addAll(Arrays.asList(pions));
    }

    public ArrayList<Pion> getListe_pions() {
        return liste_pions;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "liste_pions=" + liste_pions +
                '}';
    }
}
