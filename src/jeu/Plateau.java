package jeu;

import jeu.Ligne;

import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    ArrayList<Ligne> liste_lignes = new ArrayList<>();

    public Plateau(Ligne... lignes) {
        liste_lignes.addAll(Arrays.asList(lignes));
    }

    public ArrayList<Ligne> getListe_lignes() {
        return liste_lignes;
    }

    public Ligne get_ligne(int n) {
        return liste_lignes.get(n);
    }

    public int size(){
        return liste_lignes.size();
    }
}
