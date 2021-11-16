import jeu.*;
import controller.*;
import ui.Window;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Game mastermind = new Game("easy");
        Window window = new Window();
        window.setVisible(true);
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        System.out.println(mastermind);
    }

}
