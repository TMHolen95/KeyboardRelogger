package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tor Martin Holen on 21-May-17.
 */
public class ActionList {
    //TimedActionHandler.DurationActions actions;
    List<Runnable> actions;
    KeyTimer keyTimer;
    int keyTapCount; // TODO use this variable for profiles utilising quick successive taps instead of a timer


    public ActionList(Runnable... runnables) {
        actions = new ArrayList<>();
        Collections.addAll(actions, runnables);
        this.keyTimer = new KeyTimer();
        this.keyTapCount = 0;
    }

    public List<Runnable> getActions() {
        return actions;
    }

    public KeyTimer getKeyTimer() {
        return keyTimer;
    }
}
