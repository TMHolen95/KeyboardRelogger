package robots;

import robots.functionality_interfaces.*;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

/**
 * Created by Tor Martin Holen on 12-May-17.
 */
public class WindowsRobot extends BaseRobot implements ShutdownCommands, PasteHistory, NavigationFunctions, UtilityFunctions, ChromeFunctions, FileManagerFunctions, TextUtilities {

    //TODO implement a smart clipboard feature

    public WindowsRobot() throws AWTException {
        super();
    }

    // Windows specific


    public void openTaskbarWindow(int windowNr) {
        keyCombo(VK_WINDOWS, getKeyCode(Integer.toString(windowNr)));
    }

    // Navigate functions
    public void moveWindowLeft() {
        keyCombo(VK_WINDOWS, VK_LEFT);
    }

    public void moveWindowRight() {
        keyCombo(VK_WINDOWS, VK_RIGHT);
    }

    public void moveWindowUp() {
        keyCombo(VK_WINDOWS, VK_UP);
    }

    public void moveWindowDown() {
        keyCombo(VK_WINDOWS, VK_DOWN);
    }

    public void minimizeWindow() {

    }

    public void maximizeWindow() {

    }

    public void showOpenApps() {
        keyCombo(VK_WINDOWS, VK_TAB);
    }

    public void nextDesktop() {
        keyCombo(VK_CONTROL, VK_WINDOWS, VK_RIGHT);
    }

    public void previousDesktop() {

    }

    // Utility functions
    public void openAppSearch() {
        keyCombo(VK_WINDOWS, VK_Q);
    }

    public void openApp(String appName) {
        openAppSearch();
        write(appName);
        enter();
    }

    public void findText() {
        keyCombo(VK_CONTROL, VK_F);
    }

    // Common browser tasks

    public void newTab() {
        keyCombo(VK_CONTROL, VK_T);
    }

    public void newIncognitoWindow() {
        keyCombo(VK_CONTROL, VK_SHIFT, VK_N);
    }

    public void closeTab() {
        keyCombo(VK_CONTROL, VK_W);
    }

    public void reopenTab() {
        keyCombo(VK_CONTROL, VK_SHIFT, VK_W);
    }

    public void duplicateTab() {
        heldKeyCombo(VK_ALT, VK_D, VK_ENTER);
    }

    public void closeBrowser() {
        keyCombo(VK_CONTROL, VK_SHIFT, VK_N);
    }

    public void bookmarkTab() {
        keyCombo(VK_CONTROL, VK_D);
    }

    @Override
    public void bookmarkOpenTabs() {
        keyCombo(VK_CONTROL, VK_SHIFT, VK_D);
    }


    public void openHistory() {
        keyCombo(VK_CONTROL, VK_H);
    }

    @Override
    public void openDownloads() {
        keyCombo(VK_CONTROL, VK_J);
    }

    //Common file manager functions

    public void openFileManager() {
        keyCombo(VK_WINDOWS, VK_E);
    }

    public void searchFileManager() {

    }

    public void closeFileManager() {
        keyCombo(VK_CONTROL, VK_W);
    }

    // Text utilities

    @Override
    public void delete() {
        activateKey(VK_BACK_SPACE);
    }

    @Override
    public void deleteWord() {
        heldKeyCombo(VK_CONTROL, VK_BACK_SPACE);
    }

    @Override
    public void deleteNextWord() {
        selectNextWord();
        delete();
    }

    @Override
    public void deleteLine() {
        activateKey(VK_HOME);
        selectLine();
        delete();
    }

    @Override
    public void moveCursorToPreviousWord() {
        keyCombo(VK_CONTROL, VK_RIGHT);
    }

    @Override
    public void moveCursorToNextWord() {
        keyCombo(VK_CONTROL, VK_LEFT);
    }

    @Override
    public void selectPreviousWord() {
//        toggleNumOff();
        heldKeyCombo(VK_CONTROL, VK_SHIFT, VK_RIGHT);
//        toggleNumOn();
    }

    @Override
    public void selectNextWord() {
//        toggleNumOff();
        heldKeyCombo(VK_CONTROL, VK_SHIFT, VK_LEFT);
//        toggleNumOn();
    }

    @Override
    public void selectLine() {
//        toggleNumOff();
        activateKey(VK_HOME);
//        selectTextCursorToEnd();
    }

    @Override
    public void selectTextCursorToHome() {
//        toggleNumOff();
        heldKeyCombo(VK_SHIFT, VK_HOME);
//        toggleNumOn();
    }

    @Override
    public void selectTextCursorToEnd() {
//        toggleNumOff();
        heldKeyCombo(VK_SHIFT, VK_END);
//        toggleNumOn();
    }

    @Override
    public void shutdown() {
        keyCombo(VK_WINDOWS, VK_D);
        keyCombo(VK_ALT, VK_F4);
        delay(250);
        activateKey(VK_ENTER);
    }


/*    public void toggleNumOff() {
        t.setLockingKeyState(VK_NUM_LOCK, false);
        waitForIdle();
    }

    public void toggleNumOn() {
        waitForIdle();
        t.setLockingKeyState(VK_NUM_LOCK, true);
    }*/
}
