package jeu;

public class Clue {
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
}
