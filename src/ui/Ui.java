package ui;

import controller.Constantes;
import controller.Events;
import jeu.Ligne;
import jeu.Pion;
import jeu.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class Ui extends JPanel {

    Plateau plateau=null;

    Events listener = new Events();
    public Ui() {
        super();
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        Draw.Plateau(g2d,plateau, getWidth(), getHeight(), listener.getMoovedColor(), listener.getX(), listener.getY());

        //input circles
        //Draw.Circle(g2d, x, y,30,Color.cyan);

        listener.windowWidth=getWidth();
        listener.windowHeight=getHeight();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        repaint();
    }

}