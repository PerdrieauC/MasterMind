import jeu.*;
import controller.*;
import ui.Ui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        JFrame frame = new JFrame();
        Ui panel = new Ui();

        frame.setSize(500, 1000);
        frame.setMinimumSize(new Dimension(400,800));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        Game mastermind = new Game("normal");
        for(int i=0;i<10;i++){
            mastermind.inputLigne(compute.getRandomCode(4,7,false));
        }

        System.out.println(mastermind);

        panel.setPlateau(mastermind.getPlateau());
        panel.repaint();
    }

}
