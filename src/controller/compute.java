package controller;

import jeu.*;

import java.awt.*;
import java.io.*;

public class compute {
    public static Ligne getRandomCode(int ligne_size, int dif, boolean duplicate){
        Pion[] res = new Pion[ligne_size];
        for(int i=0;i<ligne_size;i++){
            if (duplicate){
                res[i] = new Pion(Constantes.colors[(int)(Math.random()*dif)]);
            }else{
                Color tmpColor;
                do {
                    tmpColor = Constantes.colors[(int) (Math.random() * dif)];
                }while (Pion.containsColor(tmpColor, res));
                res[i]=new Pion(tmpColor);
            }
        }
        return new Ligne(res);
    }

    public static Clue genClue(Ligne l, Ligne code, int ligneSize){
        int perfect=0;
        for(int i = 0; i< ligneSize; i++){
            if(l.getPion(i).getCouleur()==code.getPion(i).getCouleur())perfect++;
        }
        if(perfect==ligneSize){
            System.out.println("gaggnnnnnnnne"); //TODO
        }
        int good=-perfect;
        for(int i = 0; i< ligneSize; i++){
            if(code.containsColor(l.getPion(i).getCouleur()))good+=1;
        }
        return new Clue(perfect,good);
    }

    public static void writeGameToFile(Game g){
        try (FileOutputStream fos = new FileOutputStream("mastermind.save");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // write object to file
            oos.writeObject(g);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean saveFound(){
        try (FileInputStream fis = new FileInputStream("mastermind.save")){
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static Game readGameFromFile(){
        try (FileInputStream fis = new FileInputStream("mastermind.save");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // write object to file
            return (Game) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
