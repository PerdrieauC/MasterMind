package jeu;

import java.util.ArrayList;

public class Plateau {
    ArrayList<Ligne> listeLignes = new ArrayList<>();
    ArrayList<Clue> listeClues = new ArrayList<>();
    Ligne secretCode;
    int ligneSize;
    int tryNumber;
    int colorNumber;

    public static Ligne getRandomCode(int ligne_size, int dif, boolean duplicate){
        Pion[] res = new Pion[ligne_size];
        for(int i=0;i<ligne_size;i++){
            res[i] = new Pion(Constantes.colors[(int)(Math.random()*dif)]);
        }
        return new Ligne(res);
    }

    public Plateau(String diff) {
        this.ligneSize = Constantes.rowSize.get(diff);
        this.tryNumber = Constantes.numberRow.get(diff);
        this.colorNumber = Constantes.colorNumber.get(diff);
        this.secretCode =getRandomCode(ligneSize, colorNumber, Constantes.remise.get(diff));
    }
    public Plateau(int ligne_size, int try_size, int color_number, boolean remise) {
        this.ligneSize = ligne_size;
        this.tryNumber = try_size;
        this.colorNumber = color_number;
        this.secretCode =getRandomCode(ligne_size, color_number, remise);
    }
    public Ligne get_ligne(int n) {
        return listeLignes.get(n);
    }

    public int size(){
        return listeLignes.size();
    }

    public Clue genClue(Ligne l, Ligne code){
        int perfect=0;
        for(int i = 0; i< ligneSize; i++){
            if(l.getPion(i)==code.getPion(i))perfect+=1;
        }
        int good=-perfect;
        for(int i = 0; i< ligneSize; i++){
            if(code.containsColor(l.getPion(i).getCouleur()))good+=1;
        }
        return new Clue(perfect,good);
    }
    public void inputLigne(Ligne l){
        if(listeLignes.size()< tryNumber) {
            listeLignes.add(l);
            listeClues.add(genClue(l, secretCode));
        }
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "liste_lignes=" + listeLignes + "\n"+
                ", liste_clues=" + listeClues + "\n"+
                ", secret_code=" + secretCode + "\n"+
                ", ligne_size=" + ligneSize + "\n"+
                ", try_size=" + tryNumber + "\n"+
                ", color_number=" + colorNumber + "\n"+
                '}';
    }
}
