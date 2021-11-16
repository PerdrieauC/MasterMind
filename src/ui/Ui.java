package ui;

import jeu.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class Ui extends JPanel {
    int defaultx=150;
    int defaulty=400;
    int x=defaultx;
    int y=defaulty;
    boolean drag = false;
    Plateau plateau=null;

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

        Draw.Plateau(g2d,plateau, getWidth(), getHeight());

        //input circles
        //Draw.Circle(g2d, x, y,30,Color.cyan);

        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);


    }

    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            if(defaultx-15<e.getX() && e.getX()<defaultx+15 && defaulty-15<e.getY() && e.getY()<defaulty+15){
                drag=true;
            }
        }

        public void mouseDragged(MouseEvent e) {
            if(drag) {
                x = e.getX();
                y = e.getY();
                if(x>getWidth())x=getWidth();
                if(y>getHeight())y=getHeight();
                if(x<0)x=0;
                if(y<0)y=0;
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            x=defaultx;
            y=defaulty;
            drag=false;
            repaint();
        }
    }
}