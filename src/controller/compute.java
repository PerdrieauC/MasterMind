package controller;

import jeu.*;

import java.awt.*;
import java.io.*;

/**
 * Class qui contient des methods statiques de calcul
 */
public class compute {
    /**
     * Créé un objet Ligne aleatoire
     * @param ligne_size taille de la ligne
     * @param dif nombre de couleur différente
     * @param duplicate aléatoire avec remise
     * @return objet ligne aléatoire
     */
    public static Ligne getRandomCode(int ligne_size, int dif, boolean duplicate){
        Pion[] res = new Pion[ligne_size];
        for(int i=0;i<ligne_size;i++){
            if (duplicate){
                res[i] = new Pion((int)(Math.random()*dif));
            }else{
                int tmpColor;
                do {
                    tmpColor = (int) (Math.random() * dif);
                }while (Pion.containsColor(tmpColor, res));
                res[i]=new Pion(tmpColor);
            }
        }
        return new Ligne(res);
    }

    /**
     * calculer les indices d'une ligne
     * @param l ligne
     * @param code code secret
     * @param ligneSize taille de la ligne
     * @return Objet Clue relatif à la ligne donnée
     */
    public static Clue genClue(Ligne l, Ligne code, int ligneSize){
        int perfect=0;
        for(int i = 0; i< ligneSize; i++){
            if(l.getPion(i).getCouleur()==code.getPion(i).getCouleur())perfect++;
        }
        int good=-perfect;
        for(int i = 0; i< ligneSize; i++){
            if(code.containsColor(l.getPion(i).getCouleur()))good+=1;
        }
        return new Clue(perfect,good);
    }

    /**
     * sauvegarder une partie
     * @param g partie à sauvegarder
     */
    public static void writeGameToFile(Game g){
        try (FileOutputStream fos = new FileOutputStream("mastermind.save");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // write object to file
            oos.writeObject(g);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * tester s'il y a une sauvegarde
     * @return vrai s'il y a une sauvegarde
     */
    public static boolean saveFound(){
        try (FileInputStream fis = new FileInputStream("mastermind.save")){
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * charger une partie sauvegarder
     * @return objet Game sauvegardé precedemment
     */
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
