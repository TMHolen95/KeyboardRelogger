package profiles;

import robots.WindowsRobot;
import util.ActionList;

import java.awt.*;

import static util.ArduinoKeyEnum.*;

/**
 * Created by Tor Martin Holen on 06-Sep-17.
 */
public class ArduinoProfile extends BaseProfile {

    private WindowsRobot r = new WindowsRobot();

    public ArduinoProfile() throws AWTException {
        super(0,150,300);
    }

    public ArduinoProfile(Integer... actionLimits) throws AWTException {
        super(actionLimits);
    }


    @Override
    public void profileKeyLogic() {
        keyActionMap.put(1, new ActionList(
                () -> r.write("q"),
                () -> r.write("Q"),
                () -> r.closeTab()
        ));

        keyActionMap.put(2, new ActionList(
                () -> r.write("a"),
                () -> r.write("a"),
                () -> r.reopenTab()
        ));
    }

    @Override
    public void execute(int key, int keyPress) {

    }
}
