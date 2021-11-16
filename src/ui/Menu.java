package ui;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private JPanel contenu;

    public Menu() {
        this.contenu = new JPanel();
        this.contenu.setLayout(new BoxLayout(this.contenu, BoxLayout.Y_AXIS));
        this.insertButtons();
    }

    public void insertButtons() {
        //JPanel pJouer = new JPanel();
        Button bJouer = new Button("Jouer");
        bJouer.setSize(100, 50);
        //pJouer.add(bJouer);
        //pJouer.setSize(100, 50);
        //pJouer.setBackground(Color.blue);


        JButton regles = new JButton("Règles");
        JButton quitter = new JButton("Quitter");

        this.contenu.add(bJouer);
        this.contenu.add(regles);
        this.contenu.add(quitter);
    }

    public void afficherMenu(JFrame window) {
        window.setContentPane(this.contenu);
        window.repaint();
        window.revalidate();
    }

    public JPanel getContenu() {
        this.contenu.setVisible(true);
        return contenu;
    }
}
