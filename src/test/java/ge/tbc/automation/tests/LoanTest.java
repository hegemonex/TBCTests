package ge.tbc.automation.tests;

import ge.tbc.automation.setUp.BaseTest;
import ge.tbc.automation.steps.LoanSteps;
import ge.tbc.automation.steps.MainSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("TBC Bank UI Tests")
@Feature("SLoan Features")
public class LoanTest extends BaseTest {
    MainSteps steps;
    LoanSteps loanSteps;

    @BeforeMethod
    public void initSteps() {
        steps = new MainSteps(page);
        loanSteps = new LoanSteps(page);
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
