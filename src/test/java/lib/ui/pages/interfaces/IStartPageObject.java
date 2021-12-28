package lib.ui.pages.interfaces;

public interface IStartPageObject {
    public void initSearch();

    void goSaveButton();

    void goList();

    void goGotIt();

    void goMenu();

    void goLogin();

    String goSubmitLogin();
    
    void goSettings();

    String getSettingsText();

    void goNearby();

    String getNearbyText();
}
