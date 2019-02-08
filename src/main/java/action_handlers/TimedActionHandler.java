package action_handlers;

import util.ActionType;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Tor Martin Holen on 12-May-17.
 */
public class TimedActionHandler extends BaseActionHandler {

    private Integer[] actionLimits;

    public TimedActionHandler(Integer... actionLimits) {
        this.actionLimits = actionLimits;
    }

    private boolean withinInterval(int interval, int duration) {
        if(interval < actionLimits.length){
            return actionLimits[interval - 1] <= duration && duration < actionLimits[interval];
        }else {
            return false;
        }

    }

    @Override
    public void performAction(int duration, int count, List<Runnable> actions) {
        boolean actionPerformed = false;

        //TODO correct error that causes application to stop working when duration exceeds intervals

        //Check which action should be performed
        for (int i = 0; i < actions.size(); i++) {
            if (withinInterval(i + 1, duration)) {
                actions.get(i).run();
                actionPerformed = true;
                break;
            }
        }

        //Perform default action if no action has been performed
        if (!actionPerformed && actions.size() == actionLimits.length) {
            actions.get(actions.size() - 1).run();
        }
    }
}
