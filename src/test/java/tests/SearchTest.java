package tests;

import lib.CoreTestCase;
import lib.ui.pages.factory.OnboardingPageFactory;
import lib.ui.pages.factory.SearchPageFactory;
import lib.ui.pages.factory.StartPageFactory;
import lib.ui.pages.interfaces.IOnboardingPageObject;
import lib.ui.pages.interfaces.ISearchPageObject;
import lib.ui.pages.interfaces.IStartPageObject;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class SearchTest extends CoreTestCase {

    //
    //@Test
    public void testSearch() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("Island of Indonesia");
    }

    //1 - Добавить страницу в закладки, проверить наличие в закладках
    @Test
    public void savePageInBookmarks() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.initSearch();
        searchPage.findByText("Java");
        searchPage.selectByText("Island of Indonesia");
        startPage.goSaveButton();
        startPage.goGotIt();
        WebElement ok = driver.findElementById("android:id/button1");
        ok.click();
        WebElement viewList = driver.findElementById("org.wikipedia:id/snackbar_action");
        viewList.click();
        startPage.goList();
        WebElement island = driver.findElementById("org.wikipedia:id/page_list_item_description");
        String text = island.getAttribute("text");
        String expectedText = "Indonesian island";
        assertEquals(text, expectedText);
    }

    //2 - Поиск по слову "Hemingway", открыть статью, проверить, что открыта искомая статья
    @Test
    public void searchHemingway() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.initSearch();
        searchPage.findByText("Hemingway");
        searchPage.selectByText("Ernest Hemingway");

    }

    //3 - Открыть форму авторизации, проверить, что открыта искомая форма
    @Test
    public void goLogIn() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.goMenu();
        startPage.goLogin();
        String text = startPage.goSubmitLogin();
        String expectedText = "Log in";
        //System.out.println(text);
        assertEquals(text, expectedText);
    }

    // 4 - Меню Settings открывается
    @Test
    public void openSettings() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.goMenu();
        startPage.goSettings();
        String text = startPage.getSettingsText();
        String expectedText = "Settings";
        //System.out.println(text);
        assertEquals(text, expectedText);
    }

    // 5 - Nearby открывается
   @Test
    public void openNearby() {
        IOnboardingPageObject onboardingPage = OnboardingPageFactory.get(this.driver);
        IStartPageObject startPage = StartPageFactory.get(this.driver);
        ISearchPageObject searchPage = SearchPageFactory.get(this.driver);

        onboardingPage.skipOnboarding();
        startPage.goNearby();
        String text = startPage.getNearbyText();
        String expectedText = "Nearby";
        //System.out.println(text);
        assertEquals(text, expectedText);
    }

}
