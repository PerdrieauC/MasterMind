package jeu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe qui represente le plateeau du mastermind
 * Elle contient une liste de ligne et une liste d'indice(clue)
 * Attributs:
 * secretCode qui contient le code secret a trouver
 * ligneSize qui contient la taille des lignes du plateau
 * tryNumber qui est le nombre d'essais dont le joueur dispose
 * color_number le nombre de couleur utilisés dans cette partie
 * (qui dépend de la difficulté, 6 couleurs en mode simple, 8 en difficile)
 */
public class Plateau implements Serializable {
    private ArrayList<Ligne> listeLignes = new ArrayList<>();
    private ArrayList<Clue> listeClues = new ArrayList<>();
    private Ligne secretCode;
    private int ligneSize;
    private int tryNumber;
    private int color_number;

    public Plateau(int ligne_size, int try_size, int color_number, Ligne secretCode) {
        this.ligneSize = ligne_size;
        this.tryNumber = try_size;
        this.secretCode = secretCode;
        this.color_number = color_number;
    }

    public int getInputSize(){
        return listeLignes.size();
    }
    public Ligne getLigne(int n) {
        return listeLignes.get(n);
    }
    public Clue getClue(int n) {
        return listeClues.get(n);
    }
    public Ligne getSecretCode() {
        return secretCode;
    }

    public int getLigneSize() {
        return ligneSize;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    /**
     * taille actuel du plateau
     */
    public int size(){
        return listeLignes.size();
    }

    /**
     * est ce que la ligne existe
     */
    public boolean ligneIndexExists(int index) {
        return index >= 0 && index < listeLignes.size();
    }

    public int getColor_number() {return color_number;}

    /**
     * ajouter une ligne et son indice
     */
    public void inputLigneAndClue(Ligne l, Clue c){
        if(getInputSize()< tryNumber) {
            listeLignes.add(l);
            listeClues.add(c);
        }
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "liste_lignes=\n " + listeLignes + "\n"+
                ", liste_clues=\n " + listeClues + "\n"+
                ", secret_code=" + secretCode + "\n"+
                ", ligne_size=" + ligneSize + "\n"+
                ", try_size=" + tryNumber + "\n"+
                '}';
    }

}
