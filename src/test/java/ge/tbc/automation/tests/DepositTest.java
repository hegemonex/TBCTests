package ge.tbc.automation.tests;

import ge.tbc.automation.setUp.BaseTest;
import ge.tbc.automation.steps.DepositSteps;
import ge.tbc.automation.steps.MainSteps;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({io.qameta.allure.testng.AllureTestNg.class})
@Epic("TBC Bank UI Tests")
@Feature("Deposit Features")
public class DepositTest extends BaseTest {
    MainSteps steps;
    DepositSteps depositSteps;

    @BeforeMethod
    public void initSteps() {
        steps = new MainSteps(page);
        depositSteps = new DepositSteps(page);
    }
    @Test(description = "Validate deposit flow")
    @Story("Deposit")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test the deposit application by clicking the card and then the button")
    public void depositTest() {
        steps.goDeposit();
        depositSteps.getADeposit();
    }
}
