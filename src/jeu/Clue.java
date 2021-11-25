package jeu;

import java.io.Serializable;
import java.util.ArrayList;

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

    public ArrayList<Boolean> getList(){
        ArrayList<Boolean> res = new ArrayList<>();
        for(int i=0;i<perfect;i++){
            res.add(Boolean.TRUE);
        }
        for(int i=0;i<good;i++){
            res.add(Boolean.FALSE);
        }
        return res;
    }

    public int size(){
        return perfect+good;
    }

    @Override
    public String toString() {
        return "{" +
                "perfect=" + perfect +
                ", good=" + good +
                "}\n";
    }
}
