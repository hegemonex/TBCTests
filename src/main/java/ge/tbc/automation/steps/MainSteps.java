package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.MainPage;
import io.qameta.allure.Step;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(Page page) {
        this.mainPage = new MainPage(page);
    }

    @Step("Navigate to Loans page")
    public MainSteps goToLoans() {
        mainPage.forYou().click();
        mainPage.loanBtn().click();
        return this;
    }

    @Step("Navigate to Money Transfer page")
    public MainSteps goToMoneyTransfer() {
        mainPage.forYou().click();
        mainPage.moneyTransferBtn().click();
        return this;
    }

    @Step("Navigate to Deposit page")
    public MainSteps goDeposit() {
        mainPage.forYou().click();
        mainPage.depositBtn().click();
        return this;
    }
}
