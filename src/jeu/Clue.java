package jeu;

import java.io.Serializable;

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

    @Override
    public String toString() {
        return "{" +
                "perfect=" + perfect +
                ", good=" + good +
                "}\n";
    }
}
