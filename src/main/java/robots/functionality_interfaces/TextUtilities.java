package robots.functionality_interfaces;

/**
 * Created by Tor Martin Holen on 26-May-17.
 */
public interface TextUtilities {
    void delete();
    void deleteWord();
    void deleteNextWord();
    void deleteLine();
    void moveCursorToPreviousWord();
    void moveCursorToNextWord();
    void selectPreviousWord();
    void selectNextWord();
    void selectLine();
    void selectTextCursorToHome();
    void selectTextCursorToEnd();
}
