package ge.tbc.automation.tests;

import ge.tbc.automation.setUp.BaseTest;
import ge.tbc.automation.steps.LoanSteps;
import ge.tbc.automation.steps.MainSteps;
import ge.tbc.automation.steps.MoneyTransferSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("TBC Bank UI Tests")
@Feature("Search and Loan Features")
public class TbcUiTests extends BaseTest {
    MainSteps steps;
    LoanSteps loanSteps;
    MoneyTransferSteps moneyTransferSteps;

    @BeforeMethod
    public void initSteps() {
        steps = new MainSteps(page);
        loanSteps = new LoanSteps(page);
        moneyTransferSteps = new MoneyTransferSteps(page);
    }

    @Test(description = "Count the amount of banks open to money transfers")
    @Story("Search, Money Transfer")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get to the page via search and fill in the field")
    public void moneyTransferSearchTest() throws InterruptedException {
        steps.goToMoneyTransfer();
        moneyTransferSteps.checkTheAmountOfAvailableBanks();
    }

    @Test(description = "Validate loan flow")
    @Story("Loan")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test the loan application process with random amount and term")
    public void loanTest() {
        steps.goToLoans();
        loanSteps.getTheLoan();
    }
}