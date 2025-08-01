package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.LoanPage;
import io.qameta.allure.Step;

import java.util.Random;

public class LoanSteps {
    private final LoanPage loanPage;
    private final Page page;
    private final Random rand = new Random();

    public LoanSteps(Page page) {
        this.page = page;
        this.loanPage = new LoanPage(page);
    }

    @Step("Apply for a loan with random amount and term")
    public LoanSteps getTheLoan() {
        String amount = String.valueOf(rand.nextInt(200, 80000));
        String term = String.valueOf(rand.nextInt(3, 48));
        goToLoanPageAndAccept(amount, term);
        return this;
    }

    @Step("Fill loan form with amount: {amount} and term: {term}, then submit")
    private void goToLoanPageAndAccept(String amount, String term) {
        closePopupIfVisible();

        page.waitForNavigation(() -> loanPage.loanBtn().click());
        closePopupIfVisible();

        loanPage.moneyAndTime().first().fill(amount);
        loanPage.moneyAndTime().nth(0).fill(term);
        closePopupIfVisible();
        loanPage.confirmBtn().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        page.waitForNavigation(() -> loanPage.confirmBtn().click());
        closePopupIfVisible();
    }

    @Step("Close popup if visible")
    private void closePopupIfVisible() {
        Locator popup = page.locator("div.popup-back.active");
        Locator closeBtn = loanPage.closePopUp();

        for (int i = 0; i < 6; i++) {
            try {
                if (popup.isVisible()) {
                    if (closeBtn.isVisible()) {
                        closeBtn.click();
                    }
                    page.waitForSelector(
                            "div.popup-back.active",
                            new Page.WaitForSelectorOptions()
                                    .setState(WaitForSelectorState.HIDDEN)
                                    .setTimeout(2000)
                    );
                    break;
                }
            } catch (PlaywrightException e) {
                break;
            }
            page.waitForTimeout(500);
        }
    }
}