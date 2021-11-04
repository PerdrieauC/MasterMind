import jeu.*;
import controller.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Plateau mastermind = new Plateau("easy");
        mastermind.inputLigne(game.getRandomCode(4,6,false));
        mastermind.inputLigne(game.getRandomCode(4,6,false));
        mastermind.inputLigne(game.getRandomCode(4,6,false));
        System.out.println(mastermind);
    }

}
