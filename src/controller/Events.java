package controller;

import jeu.Ligne;
import jeu.Pion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * classe utilisée pour gérer les inputs utilisateurs
 * clique de souris
 * drap and drop
 * reçoit les positions du selecteurs de la classe UI
 */
public class Events extends MouseAdapter {
    private int x=-100;//x mouse position
    private int y=-100;//y mouse position

    private static ArrayList<Integer[]> selectorPositions = new ArrayList<>();
    private static ArrayList<Integer[]> inputPositions = new ArrayList<>();
    private static double storeCircleRadius=10;
    private static Ligne currentInput = new Ligne();



    private int moovedColor=-1;
    public int windowWidth;
    public int windowHeight;

    public static void setSelectorPositions(ArrayList<Integer[]> selectorPositions) {
        Events.selectorPositions = selectorPositions;
    }
    public static void setInputPositions(ArrayList<Integer[]> inputPositions) {
        Events.inputPositions = inputPositions;
    }
    public static void setStoreCircleRadius(double storeCircleRadius) {
        Events.storeCircleRadius = storeCircleRadius/2;
    }
    public static void setCurrentInput(Ligne currentInput) {Events.currentInput = currentInput;
    }

    public static Ligne getCurrentInput() {return currentInput;}

    public int getX() {return x;}
    public int getY() {return y;}
    public int getMoovedColor() {return moovedColor;}


    private static int getCircleClickedSelector(int mouseX, int mouseY){
        for(Integer[] pos:selectorPositions) {
            if (pos[0] - storeCircleRadius < mouseX && mouseX < pos[0] + storeCircleRadius && pos[1] - storeCircleRadius < mouseY && mouseY < pos[1] + storeCircleRadius) {
                return selectorPositions.indexOf(pos);
            }
        }
        return -1;
    }
    private static int getCircleClickedInput(int mouseX, int mouseY){
        for(Integer[] pos:inputPositions) {
            if (pos[0] - storeCircleRadius < mouseX && mouseX < pos[0] + storeCircleRadius && pos[1] - storeCircleRadius < mouseY && mouseY < pos[1] + storeCircleRadius) {
                return inputPositions.indexOf(pos);
            }
        }
        return -1;
    }

    public void mousePressed(MouseEvent e) {
        if(e.getButton()==2) currentInput.clear();

        moovedColor=getCircleClickedSelector(e.getX(),e.getY());
        x = e.getX();
        y = e.getY();
        int index=getCircleClickedInput(e.getX(),e.getY());
        if(index>=0 && e.getButton()==3)currentInput.removePion(index);

    }

    public void mouseDragged(MouseEvent e) {
        if(moovedColor>=0) {
            x = e.getX();
            y = e.getY();
            if(x>windowWidth)x=windowWidth;
            if(y>windowHeight)y=windowHeight;
            if(x<0)x=0;
            if(y<0)y=0;
        }
    }

    public void mouseReleased(MouseEvent e) {
        int index=getCircleClickedInput(e.getX(),e.getY());
        if(moovedColor>=0 && index>=0){
            currentInput.addPions(index,new Pion(moovedColor));
        }
        index=getCircleClickedSelector(e.getX(),e.getY());
        if(index>=0){
            currentInput.addPions(new Pion(index));
        }


        moovedColor=-1;
        x=-100;
        y=-100;
    }

}

