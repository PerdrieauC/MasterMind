import jeu.*;
import controller.*;

public class Main {

    public static void main(String[] args){
        Game mastermind = new Game("easy");
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        System.out.println(mastermind);
    }

}
