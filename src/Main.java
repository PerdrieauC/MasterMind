import jeu.*;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        Plateau mastermind = new Plateau("easy");
        System.out.println(new Pion(Constantes.colors[0]).getCouleur()==new Pion(Constantes.colors[0]).getCouleur());
    }

}
