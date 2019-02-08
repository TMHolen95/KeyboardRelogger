package util;

import java.util.Map;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Tor Martin Holen on 22-May-17.
 */
public abstract class MapPopulator {
    /**
     * Populates map with printable characters in AWT KeyEvent
     * Needs to provide a workaround for %'-<>? and various other symbols not printable with a single key
     *
     * @param m map to populate
     * @return populated map
     */
    public static void populateMap(Map<String, Integer> m) {
        m.put("0", VK_0);
        m.put("1", VK_1);
        m.put("2", VK_2);
        m.put("3", VK_3);
        m.put("4", VK_4);
        m.put("5", VK_5);
        m.put("6", VK_6);
        m.put("7", VK_7);
        m.put("8", VK_8);
        m.put("9", VK_9);
        m.put("a", VK_A);
        m.put("b", VK_B);
        m.put("c", VK_C);
        m.put("d", VK_D);
        m.put("e", VK_E);
        m.put("f", VK_F);
        m.put("g", VK_G);
        m.put("h", VK_H);
        m.put("i", VK_I);
        m.put("j", VK_J);
        m.put("k", VK_K);
        m.put("l", VK_L);
        m.put("m", VK_M);
        m.put("n", VK_N);
        m.put("o", VK_O);
        m.put("p", VK_P);
        m.put("q", VK_Q);
        m.put("r", VK_R);
        m.put("s", VK_S);
        m.put("t", VK_T);
        m.put("u", VK_U);
        m.put("v", VK_V);
        m.put("w", VK_W);
        m.put("x", VK_X);
        m.put("y", VK_Y);
        m.put("z", VK_Z);
        m.put("A", VK_A);
        m.put("B", VK_B);
        m.put("C", VK_C);
        m.put("D", VK_D);
        m.put("E", VK_E);
        m.put("F", VK_F);
        m.put("G", VK_G);
        m.put("H", VK_H);
        m.put("I", VK_I);
        m.put("J", VK_J);
        m.put("K", VK_K);
        m.put("L", VK_L);
        m.put("M", VK_M);
        m.put("N", VK_N);
        m.put("O", VK_O);
        m.put("P", VK_P);
        m.put("Q", VK_Q);
        m.put("R", VK_R);
        m.put("S", VK_S);
        m.put("T", VK_T);
        m.put("U", VK_U);
        m.put("V", VK_V);
        m.put("W", VK_W);
        m.put("X", VK_X);
        m.put("Y", VK_Y);
        m.put("Z", VK_Z);
        m.put(" ", VK_SPACE);
/*
        m.put("!", VK_EXCLAMATION_MARK);
        m.put("\"", VK_QUOTE);
        m.put("#", VK_NUMBER_SIGN);
        m.put("$", VK_DOLLAR);
        m.put("&", VK_AMPERSAND);
        m.put("(", VK_LEFT_PARENTHESIS);
        m.put(")", VK_RIGHT_PARENTHESIS);
        m.put("*", VK_MULTIPLY);
        m.put("+", VK_PLUS);
        m.put(",", VK_COMMA);
        m.put(".", VK_PERIOD);
        m.put("/", VK_SLASH);
        m.put(":", VK_COLON);
        m.put(";", VK_SEMICOLON);
        m.put("=", VK_EQUALS);
        m.put("@", VK_AT);
        m.put("[", VK_OPEN_BRACKET);
        m.put("]", VK_CLOSE_BRACKET);
        m.put("{", VK_BRACELEFT);
        m.put("}", VK_BRACERIGHT);
        m.put("\\", VK_BACK_SLASH);*/
    }

    public static void populateSpecialMap(Map<String, Integer[]> m) {
        //m.put(" ", new Integer[]{VK_ALT, VK_NUMPAD, VK_NUMPAD);
        m.put("¤", new Integer[]{VK_ALT, VK_NUMPAD1, VK_NUMPAD5});
        m.put("!", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD3});
        m.put("\"",new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD4});
        m.put("#", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD5});
        m.put("$", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD6});
        m.put("%", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD7});
        m.put("&", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD8});
        m.put("'", new Integer[]{VK_ALT, VK_NUMPAD3, VK_NUMPAD9});
        m.put("(", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD0});
        m.put(")", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD1});
        m.put("*", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD2});
        m.put("+", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD3});
        m.put(",", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD4});
        m.put("-", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD5});
        m.put(".", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD6});
        m.put("/", new Integer[]{VK_ALT, VK_NUMPAD4, VK_NUMPAD7});

        //Numbers

        m.put(":", new Integer[]{VK_ALT, VK_NUMPAD5, VK_NUMPAD8});
        m.put(";", new Integer[]{VK_ALT, VK_NUMPAD5, VK_NUMPAD9});
        m.put("<", new Integer[]{VK_ALT, VK_NUMPAD6, VK_NUMPAD0});
        m.put("=", new Integer[]{VK_ALT, VK_NUMPAD6, VK_NUMPAD1});
        m.put(">", new Integer[]{VK_ALT, VK_NUMPAD6, VK_NUMPAD2});
        m.put("?", new Integer[]{VK_ALT, VK_NUMPAD6, VK_NUMPAD3});
        m.put("@", new Integer[]{VK_ALT, VK_NUMPAD6, VK_NUMPAD4});

        m.put("[", new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD1});
        m.put("\\",new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD2});
        m.put("]", new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD3});
        m.put("^", new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD4});
        m.put("_", new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD5});
        m.put("`", new Integer[]{VK_ALT, VK_NUMPAD9, VK_NUMPAD6});

        m.put("{", new Integer[]{VK_ALT, VK_NUMPAD1, VK_NUMPAD2, VK_NUMPAD3});
        m.put("|", new Integer[]{VK_ALT, VK_NUMPAD1, VK_NUMPAD2, VK_NUMPAD4});
        m.put("}", new Integer[]{VK_ALT, VK_NUMPAD1, VK_NUMPAD2, VK_NUMPAD5});
        m.put("~", new Integer[]{VK_ALT, VK_NUMPAD1, VK_NUMPAD2, VK_NUMPAD6});
        //TODO add more symbols if needed.
    }
}


