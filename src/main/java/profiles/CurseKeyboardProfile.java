package profiles;

import robots.WindowsRobot;
import util.ActionList;
import util.ActionType;


import java.awt.AWTException;
import java.util.*;
import java.util.List;

import static org.jnativehook.keyboard.NativeKeyEvent.*;

/**
 * Created by Tor Martin Holen on 21-May-17.
 */

public class CurseKeyboardProfile extends BaseProfile {

    private WindowsRobot r = new WindowsRobot();

    public CurseKeyboardProfile() throws AWTException {
        super(0,150,230);
    }

    public CurseKeyboardProfile(Integer... actionLimits) throws AWTException {
        super(actionLimits);
    }

    public void profileKeyLogic(){
        keyActionMap.put(VC_Q, new ActionList(
                () -> r.write("q"),
                () -> r.write("Q"),
                () -> r.write("queef ")
        ));
        keyActionMap.put(VC_W, new ActionList(
                () -> r.write("w"),
                () -> r.write("W"),
                () -> r.write("whore ")
        ));
        keyActionMap.put(VC_E, new ActionList(
                () -> r.write("e"),
                () -> r.write("E"),
                () -> r.write("erection ")
        ));
        keyActionMap.put(VC_R, new ActionList(
                () -> r.write("r"),
                () -> r.write("R"),
                () -> r.write("roid ")
        ));
        keyActionMap.put(VC_T, new ActionList(
                () -> r.write("t"),
                () -> r.write("T"),
                () -> r.write("turd ")
        ));
        keyActionMap.put(VC_Y, new ActionList(
                () -> r.write("y"),
                () -> r.write("Y"),
                () -> r.write("yanking ")
        ));
        keyActionMap.put(VC_U, new ActionList(
                () -> r.write("u"),
                () -> r.write("U"),
                () -> r.write("underpants ")
        ));
        keyActionMap.put(VC_I, new ActionList(
                () -> r.write("i"),
                () -> r.write("I"),
                () -> r.write("incestbreeded ")
        ));
        keyActionMap.put(VC_O, new ActionList(
                () -> r.write("o"),
                () -> r.write("O"),
                () -> r.write("overlactating ")
        ));
        keyActionMap.put(VC_P, new ActionList(
                () -> r.write("p"),
                () -> r.write("P"),
                () -> r.write("panties ")
        ));
        keyActionMap.put(VC_A, new ActionList(
                () -> r.write("a"),
                () -> r.write("A"),
                () -> r.write("analsniffing ")
        ));
        keyActionMap.put(VC_S, new ActionList(
                () -> r.write("s"),
                () -> r.write("S"),
                () -> r.write("slippery ")
        ));
        keyActionMap.put(VC_D, new ActionList(
                () -> r.write("d"),
                () -> r.write("D"),
                () -> r.write("drunken ")
        ));
        keyActionMap.put(VC_F, new ActionList(
                () -> r.write("f"),
                () -> r.write("F"),
                () -> r.write("fucking ")
        ));
        keyActionMap.put(VC_G, new ActionList(
                () -> r.write("g"),
                () -> r.write("G"),
                () -> r.write("gluten ")
        ));
        keyActionMap.put(VC_H, new ActionList(
                () -> r.write("h"),
                () -> r.write("H"),
                () -> r.write("horsefucking ")
        ));
        keyActionMap.put(VC_J, new ActionList(
                () -> r.write("j"),
                () -> r.write("J"),
                () -> r.write("jelly ")
        ));
        keyActionMap.put(VC_K, new ActionList(
                () -> r.write("k"),
                () -> r.write("K"),
                () -> r.write("king ")
        ));
        keyActionMap.put(VC_L, new ActionList(
                () -> r.write("l"),
                () -> r.write("L"),
                () -> r.write("loadtaking ")
        ));
        keyActionMap.put(VC_Z, new ActionList(
                () -> r.write("z"),
                () -> r.write("Z"),
                () -> r.write("zebra ")
        ));
        keyActionMap.put(VC_X, new ActionList(
                () -> r.write("x"),
                () -> r.write("X"),
                () -> r.write("xxx ")
        ));
        keyActionMap.put(VC_C, new ActionList(
                () -> r.write("c"),
                () -> r.write("C"),
                () -> r.write("cunt ")
        ));
        keyActionMap.put(VC_V, new ActionList(
                () -> r.write("v"),
                () -> r.write("V"),
                () -> r.write("vicious ")
        ));
        keyActionMap.put(VC_B, new ActionList(
                () -> r.write("b"),
                () -> r.write("B"),
                () -> r.write("bunburned ")
        ));
        keyActionMap.put(VC_N, new ActionList(
                () -> r.write("n"),
                () -> r.write("N"),
                () -> r.write("niggah ")
        ));
        keyActionMap.put(VC_M, new ActionList(
                () -> r.write("m"),
                () -> r.write("M"),
                () -> r.write("motherfucking ")
        ));
        keyActionMap.put(VC_BACKSPACE, new ActionList(
                () -> r.delete(),
                () -> r.deleteWord(),
                () -> r.selectNextWord()
        ));
        keyActionMap.put(VC_SCROLL_LOCK, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_INSERT, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_PAUSE, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_CAPS_LOCK, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_NUM_LOCK, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_SCROLL_LOCK, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_F9, new ActionList(
                () -> r.nextDesktop()
        ));
        keyActionMap.put(VC_F13, new ActionList(
                () -> r.nextDesktop()
        ));
    }

    public void execute(int key, int duration) {
        List<Runnable> actions = keyActionMap.get(key).getActions();
        actionHandlers.get(ActionType.TIMED).performAction(duration, 0, actions);
    }
}