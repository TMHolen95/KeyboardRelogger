package profiles;

import robots.WindowsRobot;
import util.ActionList;
import util.ActionType;

import java.awt.*;

import static org.jnativehook.keyboard.NativeKeyEvent.*;

/**
 * Created by Tor Martin Holen on 23-May-17.
 */
public class CapsProfile extends BaseProfile {

    private WindowsRobot r = new WindowsRobot();

    public CapsProfile() throws AWTException {

        super(0,150,300);
    }

    public CapsProfile(Integer... actionLimits) throws AWTException {

        super(actionLimits);
    }



    public void profileKeyLogic(){
        keyActionMap.put(VC_Q, new ActionList(
                () -> r.write("q"),
                () -> r.write("Q"),
                () -> r.openAppSearch()
        ));
        keyActionMap.put(VC_W, new ActionList(
                () -> r.write("w"),
                () -> r.write("W"),
                () -> r.closeTab()
        ));
        keyActionMap.put(VC_E, new ActionList(
                () -> r.write("e"),
                () -> r.write("E"),
                () -> r.openFileManager()
        ));
        keyActionMap.put(VC_R, new ActionList(
                () -> r.write("r"),
                () -> r.write("R"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_T, new ActionList(
                () -> r.write("t"),
                () -> r.write("T"),
                () -> r.newTab()
        ));
        keyActionMap.put(VC_Y, new ActionList(
                () -> r.write("y"),
                () -> r.write("Y"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_U, new ActionList(
                () -> r.write("u"),
                () -> r.write("U"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_I, new ActionList(
                () -> r.write("i"),
                () -> r.write("I"),
                () -> r.newTab()
        ));
        keyActionMap.put(VC_O, new ActionList(
                () -> r.write("o"),
                () -> r.write("O"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_P, new ActionList(
                () -> r.write("p"),
                () -> r.write("P"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_A, new ActionList(
                () -> r.write("a"),
                () -> r.write("A"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_S, new ActionList(
                () -> r.write("s"),
                () -> r.write("S"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_D, new ActionList(
                () -> r.write("d"),
                () -> r.write("D"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_F, new ActionList(
                () -> r.write("f"),
                () -> r.write("F"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_G, new ActionList(
                () -> r.write("g"),
                () -> r.write("G"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_H, new ActionList(
                () -> r.write("h"),
                () -> r.write("H"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_J, new ActionList(
                () -> r.write("j"),
                () -> r.write("J"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_K, new ActionList(
                () -> r.write("k"),
                () -> r.write("K"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_L, new ActionList(
                () -> r.write("l"),
                () -> r.write("L"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_Z, new ActionList(
                () -> r.write("z"),
                () -> r.write("Z"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_X, new ActionList(
                () -> r.write("x"),
                () -> r.write("X"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_C, new ActionList(
                () -> r.write("c"),
                () -> r.write("C"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_V, new ActionList(
                () -> r.write("v"),
                () -> r.write("V"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_B, new ActionList(
                () -> r.write("b"),
                () -> r.write("B"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_N, new ActionList(
                () -> r.write("n"),
                () -> r.write("N"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_M, new ActionList(
                () -> r.write("m"),
                () -> r.write("M"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_1, new ActionList(
                () -> r.write("1"),
                () -> r.write("!"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_2, new ActionList(
                () -> r.write("2"),
                () -> r.write("\""),
                () -> r.write("@")
        ));
        keyActionMap.put(VC_3, new ActionList(
                () -> r.write("3"),
                () -> r.write("#"),
                () -> r.write("£")
        ));
        keyActionMap.put(VC_4, new ActionList(
                () -> r.write("4"),
                () -> r.write("¤"),
                () -> r.write("$")
        ));
        keyActionMap.put(VC_5, new ActionList(
                () -> r.write("5"),
                () -> r.write("%"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_6, new ActionList(
                () -> r.write("6"),
                () -> r.write("&"),
                () -> r.write("")
        ));
        keyActionMap.put(VC_7, new ActionList(
                () -> r.write("7"),
                () -> r.write("/"),
                () -> r.write("{")
        ));
        keyActionMap.put(VC_8, new ActionList(
                () -> r.write("8"),
                () -> r.write("("),
                () -> r.write("[")
        ));
        keyActionMap.put(VC_9, new ActionList(
                () -> r.write("9"),
                () -> r.write(")"),
                () -> r.write("]")
        ));
        keyActionMap.put(VC_0, new ActionList(
                () -> r.write("0"),
                () -> r.write("="),
                () -> r.write("}")
        ));

        keyActionMap.put(VC_EQUALS, new ActionList( // Plus character NOR layout
                () -> r.write("+"),
                () -> r.write("?"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_OPEN_BRACKET, new ActionList( // BackSlash character NOR layout
                () -> r.write("+"),
                () -> r.write("?"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_COMMA, new ActionList(
                () -> r.write(","),
                () -> r.write(";"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_PERIOD, new ActionList(
                () -> r.write("."),
                () -> r.write(":"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_MINUS, new ActionList(
                () -> r.write("-"),
                () -> r.write("_"),
                () -> r.write("")
        ));

        keyActionMap.put(VC_BACKSPACE, new ActionList(
                () -> r.delete(),
                () -> r.deleteWord(),
                () -> r.deleteLine()
        ));

/*        keyActionMap.put(VC_ENTER, new ActionList(
                () -> r.shutdown()
        ));*/
    }

    public void execute(int key, int duration) {
        java.util.List<Runnable> actions = keyActionMap.get(key).getActions();
        actionHandlers.get(ActionType.TIMED).performAction(duration, 0, actions);
    }

    /**
     * Used to test that all characters are accessible;
     * @param args
     */
    public static void main(String[] args) {
        BaseProfile p;
        try {
            p = new CapsProfile(0,150,250);
            /*for (int i = VC_1; i < VC_0; i++) {
                int timePressed = 100;
                p.execute(i,timePressed);
                timePressed = 200;
                p.execute(i,timePressed);
                timePressed = 300;
                p.execute(i,timePressed);
            }*/
            int timePressed = 300;
            p.execute(VC_BACKSPACE, timePressed);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}