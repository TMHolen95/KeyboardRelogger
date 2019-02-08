package util;

/**
 * Created by Tor Martin Holen on 15-May-17.
 */
public class KeyTimer {
    long timePressed;
    boolean started = false;
    public KeyTimer() {
    }

    public void start(){
        if(!started) {
            started = true;
            timePressed = System.currentTimeMillis();
        }
    }

    public boolean isStarted() {
        return started;
    }

    public int getTimePressed(){
        if(started) {
            started = false;
            return (int)(System.currentTimeMillis() - timePressed);
        }else {
            return -1;
        }
    }

}
