package robots;

import util.MapPopulator;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Tor Martin Holen on 30-Mar-17.
 */
public class BaseRobot extends Robot {
    protected static Map<String, Integer> signMap;
    protected static Map<String, Integer[]> specialCharacterMap;
    protected int stdDelay = 10;
    protected Toolkit t;

    public BaseRobot() throws AWTException {
        super();

        signMap = new HashMap<>();
        MapPopulator.populateMap(signMap);

        specialCharacterMap = new HashMap<>();
        MapPopulator.populateSpecialMap(specialCharacterMap);

        t = Toolkit.getDefaultToolkit();
    }

    public void write(String s) {
        while (s.length() != 0) {
            String l = s.substring(0, 1);
            boolean uppercase = l.matches("[A-Z]");
            if (uppercase) {
                keyCombo(VK_SHIFT, signMap.get(l));
            } else if (signMap.containsKey(l)){
                activateKey(l);
            } else if (specialCharacterMap.containsKey(l)) {
                Integer[] keys = specialCharacterMap.get(l);
                heldKeyCombo(keys[0], Arrays.copyOfRange(keys, 1, keys.length));
            }

            s = s.substring(1);
        }
        waitForIdle();
    }



    protected void activateKey(String letter) {
        int code = getKeyCode(letter);
        keyPress(code);
        keyRelease(code);
    }

    protected void keyPress(String letter) {
        int code = getKeyCode(letter);
        keyPress(code);
    }

    protected void keyRelease(String letter) {
        int code = getKeyCode(letter);
        keyRelease(code);
    }

    protected void activateKey(String letter, int delay) {
        int code = getKeyCode(letter);
        keyPress(code);
        delay(delay);
        keyRelease(code);
    }

    protected void activateKey(int keyCode) {
        keyPress(keyCode);
        keyRelease(keyCode);
    }

    protected void activateKeys(String[] keys){
        for (String key : keys) {
            keyPress(key);
        }
        delay(stdDelay);
        for (String key : keys) {
            keyRelease(key);
        }
    }

    protected void activateKeys(String[] keys, int delay){
        for (String key : keys) {
            keyPress(key);
        }
        delay(delay);
        for (String key : keys) {
            keyRelease(key);
        }
    }

    protected void sequentialKeyActivation(Integer... keys){
        for (Integer key : keys) {
            activateKey(key);
            delay(2);
        }
    }


    protected void keyCombo(Integer... keys){
        delay(stdDelay);
        pressKeys(keys);
        delay(stdDelay);
        releaseKeys(keys);

    }

    protected void heldKeyCombo(int heldKey, Integer... keys){
        keyPress(heldKey);
        sequentialKeyActivation(keys);
        keyRelease(heldKey);
    }

    protected void heldTwoKeyCombo(int heldKey1,int heldKey2, Integer... keys){
        keyPress(heldKey1);
        keyPress(heldKey2);
        sequentialKeyActivation(keys);
        keyRelease(heldKey2);
        keyRelease(heldKey1);
    }



    protected void pressKeys(Integer... keys){
        for (Integer key : keys) {
            keyPress(key);
        }
    }

    protected void pressKeys(int delay, Integer... keys){
        for (Integer key : keys) {
            keyPress(key);
            delay(delay);
        }
    }

    protected void releaseKeys(Integer... keys) {
        for (Integer key : keys) {
            keyRelease(key);
        }
    }

    protected int getKeyCode(String letter) {
        return signMap.get(letter);
    }

    protected void enter() {
        keyPress(VK_ENTER);
        keyRelease(VK_ENTER);
    }
}
