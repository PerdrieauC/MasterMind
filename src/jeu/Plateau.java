package jeu;

import jeu.Ligne;

import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    ArrayList<Ligne> liste_lignes = new ArrayList<>();
    ArrayList<Clue> liste_clues = new ArrayList<>();
    Ligne secret_code;
    int ligne_size;
    int try_size;
    int color_number;

    public static Ligne getRandomCode(int ligne_size, int dif, boolean duplicate){
        Pion[] res = new Pion[5];
        for(int i=0;i<ligne_size;i++){
            res[i] = new Pion(Constantes.colors[(int)(Math.random()*dif)]);
        }
        return new Ligne(res);
    }

    public Plateau(String diff) {
        this.ligne_size = Constantes.rowSize.get(diff);
        this.try_size = Constantes.numberRow.get(diff);
        this.color_number = Constantes.colorNumber.get(diff);
        this.secret_code=getRandomCode(ligne_size, color_number, Constantes.remise.get(diff));
    }
    public Plateau(int ligne_size, int try_size, int color_number, boolean remise) {
        this.ligne_size = ligne_size;
        this.try_size = try_size;
        this.color_number= color_number;
        this.secret_code=getRandomCode(ligne_size, color_number, remise);
    }
    public Ligne get_ligne(int n) {
        return liste_lignes.get(n);
    }

    public int size(){
        return liste_lignes.size();
    }

    public Clue genClue(Ligne l, Ligne code){
        int perfect=0;
        for(int i=0;i<ligne_size;i++){
            if(l.getPion(i)==code.getPion(i))perfect+=1;
        }
        int good=-perfect;
        for(int i=0;i<ligne_size;i++){
            if(code.containsColor(l.getPion(i).getCouleur()))good+=1;
        }
        return new Clue(perfect,good);
    }
    public void inputLigne(Ligne l){
        if(liste_lignes.size()<try_size) {
            liste_lignes.add(l);
            liste_clues.add(genClue(l, secret_code));
        }
    }
    @Override
    public String toString() {
        return "Plateau:\n" +
                liste_lignes;
    }
}
