package ui;

import controller.Constantes;
import controller.Events;
import jeu.Ligne;
import jeu.Pion;
import jeu.Plateau;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Draw {
    public static final double MAX_CIRCLE_SIZE=0.7;

    public static void Circle(Graphics2D g2d, int x, int y, int radius, Color c) {
        int shadowSize = 1;
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

    public static void Hole(Graphics2D g2d, int x, int y, int radius){
        double Contour_x = x-(radius/2); //draw centered
        double Contour_y = y-(radius/2);

        Point2D center = new Point2D.Double(Contour_x + (radius/2), Contour_y + (radius/2));
        Color b = new Color(0x9b653f); //using colors with transparency!!!
        Color w = b.brighter();
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, new float[]{0.45f, 0.5f}, new Color[]{b, w}, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2d.setPaint(paint);
        g2d.fillOval((int) Contour_x, (int)Contour_y, radius, radius);

        radius= (int) (radius*0.8);
        int trou_x = x-(radius/2); //draw centered
        int trou_y = y-(radius/2);

        center = new Point2D.Double(trou_x + radius * 0.4, trou_y + radius * 0.7);
        float[] dist = {0.00f, 0.4f, 0.9f};
        Color[] colors = {b, b.darker(), b.darker().darker()};
        paint = new RadialGradientPaint(center, radius, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        g2d.setPaint(paint);
        g2d.fillOval(trou_x, trou_y, radius, radius);
    }

    public static void Clue(Graphics2D g2d, int x, int y, boolean perfect) {
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
    public static void Ligne(Graphics2D g2d, Ligne ligne, int size, int width, int posY, int lineHeight){
        double marginLeft=width*0.4; //10%
        double marginRight=width*0.25; //10%
        double circleSize=3/(4*(double)size);//20% of screen width w/o margin

        double trueWidth=width-marginLeft-marginRight;//500
        double circleRadius=trueWidth*circleSize;//75
        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;

        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        ArrayList<Integer[]> res=new ArrayList<>();
        for(int i=0;i<size;i++){
            int posX = (int) (marginLeft+circleRadius*i+gap*i);
            res.add(new Integer[]{posX, posY});
            if(ligne.getPion(i)!=null)Draw.Circle(g2d, posX,posY,(int)circleRadius,ligne.getPion(i).getCouleur());
        }
        Events.setInputPositions(res);
    }

    public static void LigneVide(Graphics2D g2d, int size, int width, int posY, int lineHeight){
        double marginLeft=width*0.4; //10%
        double marginRight=width*0.25; //10%
        double circleSize=3/(4*(double)size);//20% of screen width w/o margin
        double ratioToCircle=1.2;


        double trueWidth=width-marginLeft-marginRight;//500
        double circleRadius=trueWidth*circleSize;

        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;
        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        double holeRadius = circleRadius*ratioToCircle;
        for(int i=0;i<size;i++){
            int posX = (int) (marginLeft+circleRadius*i+gap*i);
            Draw.Hole(g2d, posX,posY,(int)holeRadius);
        }
    }

    public static void Selector(Graphics2D g2d, int moovedCircle, int moovedX, int moovedY, int colorNumber, int size, int width, int y, int lineHeight){
        double marginLeft=width*0.4; //10%
        double marginRight=width*0.25; //10%
        double circleSize=3/(4*(double)size);//20% of screen width w/o margin

        double trueWidth=width-marginLeft-marginRight;//500
        double circleRadius=trueWidth*circleSize;//75
        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;

        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        ArrayList<Integer[]> res = new ArrayList<>();
        Events.setStoreCircleRadius ((int) circleRadius);


        for(int j=0;j<=colorNumber/size;j++) {
            for (int i = 0; i < size; i++) {
                int posX = (int) (marginLeft + circleRadius * i + gap * i);
                int posY = y+lineHeight*j;
                res.add(new Integer[]{posX, posY});
                if(i+j*size!=moovedCircle && i+j*size<colorNumber)Draw.Circle(g2d, posX, posY, (int) circleRadius, Constantes.colors[i+j*size]);
            }
        }
        Events.setSelectorPositions(res);
        if(moovedCircle>=0)Draw.Circle(g2d, moovedX, moovedY, (int) circleRadius, Constantes.colors[moovedCircle]);
    }

    public static void Plateau(Graphics2D g2d, Plateau plateau, int width, int height, int moovedCircle, int moovedX, int moovedY){
        int marginTop = (int) (height*0.1); //10% top
        int marginBottom = (int) (height*0.2); //20% bottom
        int lineNTotal = plateau.getTryNumber();
        int lineHeight = (height-marginBottom-marginTop)/(lineNTotal-1);


        for(int i = 0; i<lineNTotal; i++) {
            Draw.LigneVide(g2d, plateau.getLigneSize(), width, height-marginBottom-i*lineHeight, lineHeight);
            if(plateau.ligneIndexExists(i)) Draw.Ligne(g2d, plateau.getLigne(i), plateau.getLigneSize(), width, height-marginBottom-i*lineHeight, lineHeight);

        }

        Draw.Ligne(g2d, Events.getCurrentInput(), plateau.getLigneSize(), width, height-marginBottom-plateau.size()*lineHeight, lineHeight); //current line we r inputing

        Draw.Selector(g2d, moovedCircle,moovedX,moovedY,plateau.getColor_number(),plateau.getLigneSize(), width, height-marginBottom/2, lineHeight);
    }


}
