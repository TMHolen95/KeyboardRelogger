package action_handlers;

import java.util.List;

/**
 * Created by Tor Martin Holen on 23-May-17.
 */
public abstract class BaseActionHandler {

    public abstract void performAction(int duration, int step, List<Runnable> actions);
}
