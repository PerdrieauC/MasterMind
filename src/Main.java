import jeu.*;
import controller.*;
import ui.Ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        Ui panel = new Ui();

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        Game mastermind = new Game("easy");
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        mastermind.inputLigne(compute.getRandomCode(4,6,false));
        System.out.println(mastermind);
        compute.writeGameToFile(mastermind);
        Game jeu2 = compute.readGameFromFile();
        System.out.println(jeu2);
    }

}
