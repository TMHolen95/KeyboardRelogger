package profiles;

import action_handlers.BaseActionHandler;
import robots.BaseRobot;
import robots.WindowsRobot;
import action_handlers.TimedActionHandler;
import util.ActionList;
import util.ActionType;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ActionType.*;

/**
 * Created by Tor Martin Holen on 12-May-17.
 */
public abstract class BaseProfile {
    protected Map<Integer, ActionList> keyActionMap;
    protected Map<ActionType, BaseActionHandler> actionHandlers;

    public BaseProfile(Integer... actionLimits){
        keyActionMap = new HashMap<>();
        actionHandlers = new HashMap<>();

        actionHandlers.put(TIMED, new TimedActionHandler(actionLimits));
        // TODO add future handlers

        profileKeyLogic();
    }

    public abstract void profileKeyLogic();

    public abstract void execute(int key, int keyPress);

    public int getAmountOfKeysUsed(){
        return keyActionMap.size();
    }

    public Map<Integer, ActionList> getKeyActionMap() {
        return keyActionMap;
    }

    public List<Runnable> getDurationActions(int key){
        return keyActionMap.get(key).getActions();
    }

    /*public TimedActionHandler.DurationActions getActions(int key){
        return keyActionMap.get(key).getActions();
    }*/
}
