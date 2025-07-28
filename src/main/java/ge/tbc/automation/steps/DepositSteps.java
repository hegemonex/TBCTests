package ge.tbc.automation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.DepositPage;
import io.qameta.allure.Step;

public class DepositSteps {
    private final DepositPage depositPage;

    public DepositSteps(Page page) {
        this.depositPage = new DepositPage(page);
    }

    @Step("Click on the card and get a deposit")
    public DepositSteps getADeposit(){
        depositPage.myGoalCard().click();
        depositPage.getTheDepositBtn().click();

        return this;
    }
}
