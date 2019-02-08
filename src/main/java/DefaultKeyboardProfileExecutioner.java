import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import profiles.BaseProfile;
import profiles.CapsProfile;
import profiles.CurseKeyboardProfile;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DefaultKeyboardProfileExecutioner implements NativeKeyListener {
    private boolean executingCommand = false;
    private BaseProfile p;

    public DefaultKeyboardProfileExecutioner(BaseProfile p) throws NativeHookException, AWTException {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        GlobalScreen.setEventDispatcher(new VoidDispatchService());
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(this);

        this.p = p;
    }

    private class VoidDispatchService extends AbstractExecutorService {
        private boolean running = false;

        public VoidDispatchService() {
            running = true;
        }

        public void shutdown() {
            running = false;
        }

        public List<Runnable> shutdownNow() {
            running = false;
            return new ArrayList<>(0);
        }

        public boolean isShutdown() {
            return !running;
        }

        public boolean isTerminated() {
            return !running;
        }

        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return true;
        }

        public void execute(Runnable r) {
            r.run();
        }
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (!executingCommand){
            if (isKeyConsumed(e)) {
                startKeyTimer(e);
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {

        if (!executingCommand) {
            if(isKeyConsumed(e)){
                executingCommand = true;

                int timePressed = resetKeyTimer(e);
                int keyCode = e.getKeyCode();
                p.execute(keyCode,timePressed);

                System.out.println("Press duration: " + timePressed + ", Key: " + keyCode);

                executingCommand = false;
            }
        }
        //System.out.println("Executing:" + executingCommand);
    }

    private void startKeyTimer(NativeKeyEvent e) {
        p.getKeyActionMap().get(e.getKeyCode()).getKeyTimer().start();
    }

    /**
     * This method reads the
     * @param e the NativeKeyEvent which decides which timer to reset
     * @return the final value, before reseting
     */
    private int resetKeyTimer(NativeKeyEvent e) {
        return p.getKeyActionMap().get(e.getKeyCode()).getKeyTimer().getTimePressed();
    }

    private boolean isKeyConsumed(NativeKeyEvent e) {
        if (p.getKeyActionMap().containsKey(e.getKeyCode())) {
            try {
                Field f = NativeInputEvent.class.getDeclaredField("reserved");
                f.setAccessible(true);
                f.setShort(e, (short) 0x01);

                System.out.println("Consumed: " + e.getKeyCode());
                return true;
            } catch (Exception ex) {
                System.out.println("Failed to consume: " + e.getKeyCode());
                ex.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Key not contained");
            keyInfo(e);
            return false;
        }
    }

    private void keyInfo(NativeKeyEvent e){
        System.out.println("KeyNr: " + e.getKeyCode() + ", KeyChar: " + e.getKeyChar() + ", KeyLocation: " + e.getKeyLocation());

    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Triggered?");
    }

    public static void main(String[] args) throws NativeHookException, AWTException {
        new DefaultKeyboardProfileExecutioner(new CurseKeyboardProfile());
    }
}
