package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.MoneyTransferPage;

import java.util.Random;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertTrue;

public class MoneyTransferSteps {
    private final MoneyTransferPage moneyTransferPage;
    private Random rand = new Random();

    public MoneyTransferSteps(Page page) {
        this.moneyTransferPage = new MoneyTransferPage(page);
    }

    public MoneyTransferSteps checkTheAmountOfAvailableBanks() throws InterruptedException {
        moneyTransferPage.moneyTransferBtn().click();

        moneyTransferPage.selectDropdownItem(moneyTransferPage.currencyDropdown(), "USD");
        moneyTransferPage.inputField().fill(String.valueOf(rand.nextInt(1000)));

        moneyTransferPage.selectDropdownItem(moneyTransferPage.countryDropdown().nth(1), "აშშ");

        moneyTransferPage.cards().first().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000));
        int count = moneyTransferPage.cards().count();
        assertTrue(count > 0, "No money transfer cards found!");

        return this;
    }
}
