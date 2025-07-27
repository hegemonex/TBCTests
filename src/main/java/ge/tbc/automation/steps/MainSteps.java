package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.MainPage;
import io.qameta.allure.Step;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(Page page) {
        this.mainPage = new MainPage(page);
    }

    @Step("Click search button on the main page")
    public MainSteps clickSearch() {
        mainPage.searchBtn().first().click();
        return this;
    }

    @Step("Navigate to Loans page")
    public MainSteps goToLoans() {
        mainPage.forYou().click();
        mainPage.loanBtn().click();
        return this;
    }
}
