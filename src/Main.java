import jeu.*;
import controller.*;
import ui.Ui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        System.setProperty("sun.java2d.opengl", "true");
        JFrame frame = new JFrame();
        Ui panel = new Ui();

        frame.setSize(500, 1000);
        frame.setMinimumSize(new Dimension(400,800));
        frame.setName("Mastermind");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        Game mastermind = new Game("normal");
        for(int i=0;i<3;i++){
            mastermind.inputLigne(compute.getRandomCode(4,7,true));
        }
        System.out.println(mastermind);

        final int FPS = 60;
        final int SKIP_TICKS = 1000 / FPS;
        final int MAX_FRAMESKIP = 5;
        double next_game_tick = System.currentTimeMillis();
        int loops;
        while (mastermind.isPlaying()) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick && loops < MAX_FRAMESKIP) {
                if(Events.getCurrentInput().getSize()==mastermind.getPlateau().getLigneSize() && Events.getCurrentInput().isFull()) {
                    mastermind.inputLigne(Events.getCurrentInput());
                    Events.setCurrentInput(new Ligne());
                }
                panel.updatePlateau(mastermind.getPlateau());
                next_game_tick += SKIP_TICKS;
                loops++;
            }
        }

        if(mastermind.isWin())panel.setWon();
        if(mastermind.isLose())System.out.println("perdu le code etait " + mastermind.getPlateau().getSecretCode());

    }

}
