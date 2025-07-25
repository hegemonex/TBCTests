package ge.tbc.automation.steps;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.LoanPage;
import org.testng.Assert;

import java.util.Random;

public class LoanSteps {
    private final LoanPage loanPage;
    private final Page page;
    private final Random rand = new Random();
    private Faker faker = new Faker();

    public LoanSteps(Page page) {
        this.page = page;
        this.loanPage = new LoanPage(page);
    }

    public LoanSteps getTheLoan(){
        int randomNum = rand.nextInt(200, 80000);
        int randomNum2 = rand.nextInt(3, 48);
        String personalId = String.valueOf(rand.nextLong(10000000000L, 99999999999L));

        String ranNum = String.valueOf(randomNum);
        String ranNum2 = String.valueOf(randomNum2);
        loanPage.loanBtn().click();

        loanPage.moneyAndTime().first().click();
        loanPage.moneyAndTime().first().fill(ranNum);

        loanPage.moneyAndTime().nth(0).click();
        loanPage.moneyAndTime().nth(0).fill(ranNum2);

        loanPage.confirmBtn().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        loanPage.confirmBtn().click();

        if(loanPage.popUp().isVisible()){
            loanPage.closePopUp().click();
        }

        loanPage.timeCalc().click();
        loanPage.timeCalc().fill((ranNum2));

        loanPage.amountCalc().click();
        loanPage.amountCalc().fill(ranNum);

        loanPage.employmentBtn().click();

        loanPage.amount().nth(0).click();
        loanPage.amount().nth(0).fill(ranNum);

        loanPage.amount().nth(1).click();
        loanPage.amount().nth(1).fill(ranNum2);

        loanPage.acceptLoansBtn().click();
        loanPage.okayBtn().click();

        loanPage.personalId().click();
        loanPage.personalId().fill(personalId);

        loanPage.personalNumber().click();
        loanPage.personalNumber().fill(faker.phoneNumber().cellPhone());

        loanPage.yesBtn().click();
        loanPage.checkbtn().click();
        loanPage.finalBtn().click();

        Assert.assertTrue(loanPage.youGotTheLoan().isVisible());

        loanPage.closeBtn().click();

        return this;
    }
}
