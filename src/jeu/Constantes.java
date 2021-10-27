package jeu;

import java.awt.*;
import java.util.HashMap;

import static java.awt.Color.*;

public final class Constantes {
    public final static Color[] colors = new Color[]{red, blue, green, white, black, cyan, orange, magenta};
    public final static HashMap<String, Integer> difficulty = new HashMap<String, Integer>(){{
        put("easy", Integer.valueOf(4));
        put("normal", Integer.valueOf(6));
        put("hard", Integer.valueOf(8));
    }};
}
