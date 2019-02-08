package robots.functionality_interfaces;

/**
 * Created by Tor Martin Holen on 12-May-17.
 */
public interface ChromeFunctions {
    void newTab();
    void newIncognitoWindow();
    void closeTab();
    void reopenTab();
    void duplicateTab();

    void closeBrowser();
    void bookmarkTab();
    void bookmarkOpenTabs();

    void openHistory();
    void openDownloads();
}
