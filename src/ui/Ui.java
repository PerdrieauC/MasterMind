package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class Ui extends JPanel {
    public Ui() {
        super();
    }
    int defaultx=150;
    int defaulty=400;
    int x=defaultx;
    int y=defaulty;
    boolean drag = false;
    public void drawClue(Graphics2D g2d, int x, int y, boolean perfect) {
        int radius = 10;
        Color m;
        Color s;
        Color b;
        if (perfect) {
            m = Color.black;
            s = Color.gray;
        } else {
            m = Color.white;
            s = Color.lightGray;
        }
        g2d.setColor(s);
        g2d.fillOval(x - 1, y - 1, radius + 2, radius + 2);
        g2d.setColor(m);
        g2d.fillOval(x, y, radius, radius);

    }

    public void drawCircle(Graphics2D g2d, int x, int y, Color c) {
        int radius = 30;
        int shadowSize = 1; //2%
        x = x-(radius/2); //draw centered
        y = y-(radius/2);

        Point2D center = new Point2D.Float(x - shadowSize + (radius/2), y + shadowSize + (radius/2));
        Color b = new Color(0xFF000000, true); //using colors with transparency!!!
        Color w = new Color(0x00FFFFFF, true);
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, new float[]{0.4f, 0.5f}, new Color[]{b, w}, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2d.setPaint(paint);
        g2d.fillOval(x - shadowSize, y + shadowSize, radius, radius);

        center = new Point2D.Double(x + radius * 0.65, y + radius * 0.3);
        float[] dist = {0.00f, 0.4f, 0.9f};
        Color[] colors = {Color.white, c, c.darker()};
        paint = new RadialGradientPaint(center, radius, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        g2d.setPaint(paint);
        g2d.fillOval(x, y, radius, radius);
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
        //drawClue(g2d, 100, 150, true);
        //drawClue(g2d, 120, 150, false);
        drawCircle(g2d, 150, 150, Color.red);
        drawCircle(g2d, 200, 150, Color.green);
        drawCircle(g2d, 250, 150, Color.black);
        drawCircle(g2d, 300, 150, Color.orange);
        //drawCircle(g2d, 150, 200, Color.black);
        //drawCircle(g2d, 200, 200, Color.blue);
        //drawCircle(g2d, 250, 200, Color.yellow);
        drawCircle(g2d, x, y, Color.cyan);
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