package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.MainPage;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(Page page) {
        this.mainPage = new MainPage(page);
    }

    public MainSteps goToCurrencyPage() {
        mainPage.forYou().click();
        mainPage.currencyBtn().click();

        return this;
    }

    public MainSteps goToTBCCardPage() {
        mainPage.forYou().click();
        mainPage.TBCCard().click();

        return this;
    }

    public MainSteps clickSearch() {
        mainPage.searchBtn().click();
        return this;
    }
}