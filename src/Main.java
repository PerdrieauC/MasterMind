import jeu.*;
public class Main {

    public static void main(String[] args){
        System.out.println(getRandomCode("easy"));
    }

    public static Ligne getRandomCode(String diff){
        int dif = Constantes.difficulty.get(diff);
        Pion[] res = new Pion[5];
        for(int i=0;i<5;i++){
            res[i] = new Pion(Constantes.colors[(int)(Math.random()*dif)]);
        }
        return new Ligne(res);
    }
}
