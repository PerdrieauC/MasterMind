package jeu;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Ligne implements Serializable {
    ArrayList<Pion> liste_pions = new ArrayList<>();

    public Ligne(){}
    public Ligne(Pion... pions) {
        liste_pions.addAll(Arrays.asList(pions));
    }

    public void addPions(int index,Pion p) {
        for(int i=getSize();i<=index;i++)liste_pions.add(null);
        this.liste_pions.remove(index);
        this.liste_pions.add(index,p);
    }
    public void removePion(int n){
        addPions(n,null);
    }
    public void clear(){this.liste_pions.clear();}
    public Pion getPion(int n) {
        if(n>=liste_pions.size())return null;
        return liste_pions.get(n);
    }

    public int getSize(){return liste_pions.size();}

    public boolean containsColor(Color c){
        for (Pion p : liste_pions) {
            if (p.getCouleur() == c) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + liste_pions + "\n";
    }
}
