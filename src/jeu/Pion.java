package jeu;

import java.awt.*;

public class Pion {
    private final Color couleur;

    public Pion(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Pion{" +
                "couleur=" + couleur +
                '}';
    }
}
