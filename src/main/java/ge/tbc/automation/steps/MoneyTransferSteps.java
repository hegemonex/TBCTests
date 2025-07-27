package ge.tbc.automation.steps;

import ge.tbc.automation.pages.MoneyTransferPage;

import static org.testng.Assert.assertTrue;

public class MoneyTransferSteps {
    private final MoneyTransferPage moneyTransferPage;

    public MoneyTransferSteps(MoneyTransferPage moneyTransferPage) {
        this.moneyTransferPage = moneyTransferPage;
    }

    public MoneyTransferSteps checkTheAmountOfAvailableBanks() {
        moneyTransferPage.moneyTransferBtn().click();
        moneyTransferPage.dropDownBtn().first().click();
        moneyTransferPage.chooseCurrency().click();
        moneyTransferPage.inputField().click();
        moneyTransferPage.inputField().fill("233");

        moneyTransferPage.dropDownBtn().nth(0).click();
        moneyTransferPage.selectQountry().click();

        int count = moneyTransferPage.cards().count();
        assertTrue(count > 0, "No money transfer cards found!");

        return this;
    }
}
