public class Main {

    public static void main(String[] args){
        System.out.println(getRandomCode(4));
    }

    public static Ligne getRandomCode(int size, int diff){
        Pion[] res = new Pion[size];
        for(int i=0;i<size;i++){
            res[i] = new Pion(Constantes.colors[0]);
        }
        return new Ligne(res);
    }
}
