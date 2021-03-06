package ui;

import controller.Constantes;
import controller.Events;
import jeu.Clue;
import jeu.Ligne;
import jeu.Plateau;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Librairie pour dessiner tous les objets du plateau
 */
public class Draw {
    public static final double MAX_CIRCLE_SIZE=0.7;

    /**
     * dessiner un cercle
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param x position x
     * @param y position y
     * @param radius rayon du cercle
     * @param c couleur du cercle
     * @param shadowed dessiner une ombre ou pas
     */
    public static void Circle(Graphics2D g2d, int x, int y, int radius, Color c,boolean shadowed) {
        double shadowSize = radius*0.1;
        x = (int) (x-(radius*0.5)); //draw centered
        y = (int) (y-(radius*0.5));

        if(shadowed) {
            Point2D center = new Point2D.Double(x - shadowSize + radius*0.5, y + shadowSize + radius*0.5);
            Color b = new Color(0xFF000000, true); //using colors with transparency!!!
            Color w = new Color(0x00FFFFFF, true);
            RadialGradientPaint paint = new RadialGradientPaint(center, radius, new float[]{0.4f, 0.5f}, new Color[]{b, w}, MultipleGradientPaint.CycleMethod.NO_CYCLE);
            g2d.setPaint(paint);
            g2d.fillOval((int)(x - shadowSize), (int)(y + shadowSize), radius, radius);
        }

        Point2D center = new Point2D.Double(x + radius * 0.65, y + radius * 0.3);
        float[] dist = {0.00f, 0.4f, 0.9f};
        Color[] colors = {Color.white, c, c.darker()};
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2d.setPaint(paint);
        g2d.fillOval(x, y, radius, radius);
    }

    /**
     * dessiner un emplacement vide du plateau
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param x position x
     * @param y position y
     * @param radius
     */
    public static void Hole(Graphics2D g2d, int x, int y, int radius){
        double Contour_x = x-(radius*0.5); //draw centered
        double Contour_y = y-(radius*0.5);

        Point2D center = new Point2D.Double(Contour_x + radius*0.5, Contour_y + radius*0.5);
        Color b = new Color(0x9b653f); //using colors with transparency!!!
        Color w = b.brighter();
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, new float[]{0.45f, 0.5f}, new Color[]{b, w}, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2d.setPaint(paint);
        g2d.fillOval((int) Contour_x, (int)Contour_y, radius, radius);

        radius= (int) (radius*0.8);
        double trou_x = x-(radius*0.5); //draw centered
        double trou_y = y-(radius*0.5);

        center = new Point2D.Double(trou_x + radius * 0.4, trou_y + radius * 0.7);
        float[] dist = {0.00f, 0.4f, 0.9f};
        Color[] colors = {b, b.darker(), b.darker().darker()};
        paint = new RadialGradientPaint(center, radius, dist, colors, MultipleGradientPaint.CycleMethod.REFLECT);
        g2d.setPaint(paint);
        g2d.fillOval((int) trou_x, (int) trou_y, radius, radius);
    }

    /**
     * dessiner un pion d'indice
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param x position x
     * @param y position y
     * @param radius rayon
     * @param perfect dessiner un perfect si vrai ou good si false
     */
    public static void clue_pin(Graphics2D g2d, int x, int y, int radius, boolean perfect) {
        x = (int) (x-(radius*0.5)); //draw centered
        y = (int) (y-(radius*0.5));
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

    /**
     * dessiner tous les pions d'indices d'une ligne
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param clue objet indice à dessiner
     * @param size taille d'une ligne
     * @param width largeur de la fenetre
     * @param posY position Y
     * @param lineHeight hauteur max d'une ligne
     */
    public static void clues(Graphics2D g2d, Clue clue, int size, int width, int posY, int lineHeight){
        double marginLeft=width*0.10; //10%
        double marginRight=width*0.75; //10%
        double circleSize=0.2;

        double trueWidth=width-marginLeft-marginRight;
        double circleRadius=lineHeight*circleSize;

        ArrayList<Boolean> info = clue.getList();

        for(int row=0;row<2;row++) {
            for (int i = 0; i < (int) Math.ceil((double) size / 2); i++) {
                int posX = (int) (marginLeft+circleRadius*i*1.4);
                if(row*2+i< info.size()) Draw.clue_pin(g2d,posX, (int) (posY-circleRadius*0.7+row*circleRadius*1.4), (int) circleRadius, info.get(row*2+i));
            }
        }
    }

    /**
     * dessiner tous les pions d'une ligne
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param ligne ligne à dessiner
     * @param size taille d'une ligne
     * @param width largeur de la fenetre
     * @param posY position y
     * @param lineHeight taille maximal d'un ligne
     */
    public static void Ligne(Graphics2D g2d, Ligne ligne, int size, int width, int posY, int lineHeight){
        double marginLeft=width*0.3; //10%
        double marginRight=width*0.15; //10%
        double circleSize=3/(4*(double)size);

        double trueWidth=width-marginLeft-marginRight;
        double circleRadius=trueWidth*circleSize;
        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;

        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        ArrayList<Integer[]> res=new ArrayList<>();
        for(int i=0;i<size;i++){
            int posX = (int) (marginLeft+circleRadius*i+gap*i);
            res.add(new Integer[]{posX, posY});
            if(ligne.getPion(i)!=null)Draw.Circle(g2d, posX,posY,(int)circleRadius,ligne.getPion(i).getCouleur(), false);
        }
        Events.setInputPositions(res);
    }

    /**
     * dessiner une ligne vide (emplacement des pions)
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param size taille de la ligne
     * @param width largeur de la fenetre
     * @param posY position y
     * @param lineHeight taille maximal de la ligne
     */
    public static void LigneVide(Graphics2D g2d, int size, int width, int posY, int lineHeight){
        double marginLeft=width*0.3; //10%
        double marginRight=width*0.15; //10%
        double circleSize=3/(4*(double)size);//20% of screen width w/o margin
        double ratioToCircle=1.2;


        double trueWidth=width-marginLeft-marginRight;//500
        double circleRadius=trueWidth*circleSize;


        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;
        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        g2d.setColor(new Color(0x9b5c3f));
        g2d.fillRoundRect((int) ((int) marginLeft*0.25), (int) (posY-(lineHeight*MAX_CIRCLE_SIZE*0.65)), (int) (marginLeft*0.75+circleRadius*(size)+gap*(size-1)), (int) (lineHeight*MAX_CIRCLE_SIZE*1.3), lineHeight/2, lineHeight/2);

        double holeRadius = circleRadius*ratioToCircle;
        for(int i=0;i<size;i++){
            int posX = (int) (marginLeft+circleRadius*i+gap*i);
            Draw.Hole(g2d, posX,posY,(int)holeRadius);
        }
    }

    /**
     * dessiner le selecteur de couleur utilisé par le joueur pour poser des pions
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param moovedCircle indice de la couleur du cercle entrain d'être bougé
     * @param moovedX position x du cercle entrain d'être bougé
     * @param moovedY position y du cercle entrain d'être bougé
     * @param colorNumber nombre de couleur utilisé dans cette partie
     * @param size taille d'une ligne
     * @param width largeur de la fenetre
     * @param y position y où dessiner le selecteurs
     * @param lineHeight taille maximum d'une ligne
     */
    public static void Selector(Graphics2D g2d, int moovedCircle, int moovedX, int moovedY, int colorNumber, int size, int width, int y, int lineHeight){
        double marginLeft=width*0.3; //10%
        double marginRight=width*0.15; //10%
        double circleSize=3/(4*(double)size);//20% of screen width w/o margin

        double trueWidth=width-marginLeft-marginRight;//500
        double circleRadius=trueWidth*circleSize;//75
        if(circleRadius>lineHeight*MAX_CIRCLE_SIZE)circleRadius=lineHeight*MAX_CIRCLE_SIZE;

        double gap=(trueWidth*(1-(size-1)*circleSize))/(size-1);

        ArrayList<Integer[]> res = new ArrayList<>();
        Events.setStoreCircleRadius (circleRadius);


        for(int j=0;j<=colorNumber/size;j++) {
            for (int i = 0; i < size; i++) {
                int posX = (int) (marginLeft + circleRadius * i + gap * i);
                int posY = y+lineHeight*j;
                if(i+j*size<colorNumber)res.add(new Integer[]{posX, posY});
                if(i+j*size!=moovedCircle && i+j*size<colorNumber){
                    Draw.Circle(g2d, posX, posY, (int) circleRadius, Constantes.colors[i+j*size],true);
                }
            }
        }
        Events.setSelectorPositions(res);
        if(moovedCircle>=0)Draw.Circle(g2d, moovedX, moovedY, (int) circleRadius, Constantes.colors[moovedCircle],true);
    }

    /**
     * dessiner le plateau complet
     * @param g2d object Graphic2D utilisé pour dessiner
     * @param plateau objet plateau à dessiner
     * @param width largeur de la fenetre
     * @param height hauteur de la fenetre
     * @param moovedCircle dessiner le cercle entrain d'être déplacé
     * @param moovedX positon x du cercle entrain d'être déplacé
     * @param moovedY positon y du cercle entrain d'être déplacé
     */
    public static void Plateau(Graphics2D g2d, Plateau plateau, int width, int height, int moovedCircle, int moovedX, int moovedY){
        int marginTop = (int) (height*0.1); //10% top
        int marginBottom = (int) (height*0.2); //20% bottom
        int lineNTotal = plateau.getTryNumber();
        int lineHeight = (height-marginBottom-marginTop)/(lineNTotal-1);


        for(int i = 0; i<lineNTotal; i++) {
            Draw.LigneVide(g2d, plateau.getLigneSize(), width, height-marginBottom-i*lineHeight, lineHeight);
            if(plateau.ligneIndexExists(i)){
                int posY=height-marginBottom-i*lineHeight;
                Draw.Ligne(g2d, plateau.getLigne(i), plateau.getLigneSize(), width, posY, lineHeight);
                Draw.clues(g2d, plateau.getClue(i), plateau.getLigneSize(), width, posY, lineHeight);
            }

        }

        if(plateau.getInputSize()==lineNTotal) Draw.Ligne(g2d, plateau.getSecretCode(), plateau.getLigneSize(), width, height-marginBottom-plateau.size()*lineHeight, lineHeight); //draw secret code if player loose
        else Draw.Ligne(g2d, Events.getCurrentInput(), plateau.getLigneSize(), width, height-marginBottom-plateau.size()*lineHeight, lineHeight); //current line we r inputing

        Draw.Selector(g2d, moovedCircle,moovedX,moovedY,plateau.getColor_number(),plateau.getLigneSize(), width, height-marginBottom/2, lineHeight);
    }


}
