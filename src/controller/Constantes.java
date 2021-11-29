package controller;

import java.awt.*;
import java.util.HashMap;

import static java.awt.Color.*;

/**
 * classe utilisée pour stocker des constantes
 * les couleurs utilisée
 * des hashmap pour choisir facilement la difficulté des parties
 */
public final class Constantes {
    public final static String[] colorsChar = {"rd", "bu", "gr", "wi", "bk", "mg", "or", "cy"};
    public final static Color[] colors = new Color[]{red, blue, green, white, black, magenta, orange, cyan};
    public final static int colorsNumber=8;


    public final static String[] difficulties={"easy","normal","hard"};

    public final static HashMap<String, Integer> colorNumber = new HashMap<>() {{
        put("easy", 5);
        put("normal", 6);
        put("hard", 8);
    }};

    public final static HashMap<String, Integer> rowSize = new HashMap<>() {{
        put("easy", 4);
        put("normal", 4);
        put("hard", 6);
    }};

    public final static HashMap<String, Integer> numberRow = new HashMap<>() {{
        put("easy", 14);
        put("normal", 12);
        put("hard", 10);
    }};

    public final static HashMap<String, Boolean> remise = new HashMap<>() {{
        put("easy", Boolean.FALSE);
        put("normal", Boolean.FALSE);
        put("hard", Boolean.TRUE);
    }};
}
