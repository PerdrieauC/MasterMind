import jeu.*;
import controller.*;
import ui.Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

 public static Game mastermind;

    public static void main(String[] args){
        System.setProperty("sun.java2d.opengl", "true"); //opengl optimisation for performance
        JFrame frame = new JFrame();
        Ui panel = new Ui();

        frame.setSize(400, 800);
        frame.setMinimumSize(new Dimension(300,600));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setContentPane(panel);


        if(compute.saveFound() && JOptionPane.showOptionDialog(frame, "Voulez vous reprendre la partie sauvegardée ?",  "?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null)==JOptionPane.YES_OPTION) {
            mastermind=compute.readGameFromFile();
        }else{
            String val=(String) JOptionPane.showInputDialog(frame,"Veuillez choisir votre mode de jeu :", "",JOptionPane.PLAIN_MESSAGE,null,Constantes.difficulties,Constantes.difficulties[1]);
            mastermind = new Game(val);
        }

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(mastermind.isPlaying()) {
                    int result = JOptionPane.showOptionDialog(frame, "Voulez vous sauvegarder la partie en cours ?",  "?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                    if (result == JOptionPane.YES_OPTION) compute.writeGameToFile(mastermind);
                }
                System.exit(0);
            }
        });


        
        //framerate cap for performance
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
        if(mastermind.isLose())panel.setLoose();

    }
}
