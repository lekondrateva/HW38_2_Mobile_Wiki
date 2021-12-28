package lib.ui.pages.ios;

import lib.ui.MainPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSStartPageObject extends MainPageObject implements IStartPageObject {
    final static String INIT_SEARCH = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
    final static String SAVE_BUTTON = "xpath://android.widget.ImageView[@content-desc='Add this article to a reading list']";
    final static String LIST = "id:org.wikipedia:id/item_title";
    final static String GOTIT_BUTTON = "id:org.wikipedia:id/onboarding_button";
    final static String MENU_BUTTON = "id:org.wikipedia:id/menu_overflow_button";
    final static String LOGIN_BUTTON = "id:org.wikipedia:id/explore_overflow_account_name";
    final static String SUBMIT_LOGIN_BUTTON = "id:org.wikipedia:id/login_button";
    final static String SETTINGS_BUTTON = "id:org.wikipedia:id/explore_overflow_settings";
    final static String SETTINGS_TEXT = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView";
    final static String NEARBY_BUTTON = "xpath://android.widget.FrameLayout[@content-desc=\"Nearby\"]/android.widget.ImageView";
    final static String NEARBY = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";


    public iOSStartPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void initSearch() {
        WebElement searchInit = this.waitForElementPresent(
                INIT_SEARCH,
                "Cannot find Search Wikipedia init search input"
        );
        searchInit.click();
    }
    public void goSaveButton() {
        WebElement SaveButton = this.waitForElementPresent(
                SAVE_BUTTON,
                "Cannot find save button"
        );
        SaveButton.click();
    }
    public void goList() {
        WebElement list = this.waitForElementPresent(
                LIST,
                "Cannot find list"
        );
        list.click();
    }

    public void goGotIt() {
        WebElement gotIt = this.waitForElementPresent(
                GOTIT_BUTTON,
                "Cannot find Got it button"
        );
        gotIt.click();
    }

    public void goMenu() {
        WebElement menu = this.waitForElementPresent(
                MENU_BUTTON,
                "Cannot find menu button"
        );
        menu.click();
    }

    public void goLogin() {
        WebElement login = this.waitForElementPresent(
                LOGIN_BUTTON,
                "Cannot find login button"
        );
        login.click();
    }

    public String goSubmitLogin() {
        WebElement SubmitLogin = this.waitForElementPresent(
                SUBMIT_LOGIN_BUTTON,
                "Cannot find submit login button"
        );
        String text = SubmitLogin.getAttribute("text");
        return text;
    }

    public void goSettings() {
        WebElement settings = this.waitForElementPresent(
                SETTINGS_BUTTON,
                "Cannot find settings button"
        );
        settings.click();
    }

    public String getSettingsText() {
        WebElement settings = this.waitForElementPresent(
                SETTINGS_TEXT,
                "Cannot find submit login button"
        );
        String text = settings.getAttribute("text");
        return text;
    }

    public void goNearby() {
        WebElement nearby = this.waitForElementPresent(
                NEARBY_BUTTON,
                "Cannot find nearby button"
        );
        nearby.click();
    }

    public String getNearbyText() {
        WebElement nearby = this.waitForElementPresent(
                NEARBY,
                "Cannot find text"
        );
        String text = nearby.getAttribute("text");
        return text;
    }
}
