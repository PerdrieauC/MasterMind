package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {

    private Menu menu;

    public Window() throws HeadlessException, IOException {
        super();
        this.menu = new Menu();
        this.propriete();
        menu.afficherMenu(this);
    }

    private void propriete() {
        setTitle("Master Mind");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(this.Contenu());
    }

    private JPanel Contenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        //panel.setBackground(new Color(160, 106, 68));
        panel.setBackground(new Color(212, 230, 241));
        

        return panel;
    }
}
