package ui;

import controller.Events;
import jeu.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * classe principal de l'affichage utilisateur
 */
public class Ui extends JPanel {

    Plateau plateau=null;
    Events listener = new Events();
    private BufferedImage background;
    private boolean won=false;
    private boolean loose=false;

    public Ui() {
        super();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        this.addComponentListener(new FrameSizeListener());
        URL resource = getClass().getResource("bg.png");
        try {
            background = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePlateau(Plateau plateau) {
        this.plateau = plateau;
        repaint();
    }

    public void setWon(){
        won=true;
        repaint();
    }
    public void setLoose(){
        loose=true;
        repaint();
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

        g2d.drawImage(background, 0, 0, getWidth(), getHeight(),this);
        if(plateau!=null)Draw.Plateau(g2d,plateau, getWidth(), getHeight(), listener.getMoovedColor(), listener.getX(), listener.getY());
        //Draw.Hole(g2d,100,100,50);
        if(won || loose){
            String info = "";

            g2d.setColor(Color.BLACK);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.6f));
            g2d.fillRect(0 , 0, getWidth(), getHeight());

            Font font=new Font("Arial", Font.BOLD, 40);
            g2d.setFont(font);
            FontMetrics metrics = g.getFontMetrics(font);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            if(won){
                g2d.setColor(Color.green);
                info = "GAGNE !";
            }
            if(loose){
                g2d.setColor(Color.red);
                info = "PERDU :(";
            }
            g2d.drawString(info, (float) ((getWidth() - metrics.stringWidth(info))*0.5), (float) (getHeight() * 0.5));
        }
    }

    private class FrameSizeListener implements ComponentListener {
        public void componentResized(ComponentEvent e) {
            listener.windowWidth=getWidth();
            listener.windowHeight=getHeight();
        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }

        @Override
        public void componentHidden(ComponentEvent e) {
            System.out.println("hidden");
        }
    }

}