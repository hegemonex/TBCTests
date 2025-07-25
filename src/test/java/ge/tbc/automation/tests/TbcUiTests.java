package ge.tbc.automation.tests;

import ge.tbc.automation.setUp.BaseTest;
import ge.tbc.automation.steps.LoanSteps;
import ge.tbc.automation.steps.MainSteps;
import ge.tbc.automation.steps.SearchSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TbcUiTests extends BaseTest {
    MainSteps steps;
    SearchSteps searchSteps;
    LoanSteps loanSteps;

    @BeforeMethod
    public void initSteps() {
        steps = new MainSteps(page);
        searchSteps = new SearchSteps(page);
        loanSteps = new LoanSteps(page);
    }

    @Test
    public void searchTest() {
        steps.clickSearch();
        searchSteps
                .searchInvalid()
                .searchValid();
    }

    @Test
    public void loanTest() {
        steps.goToLoans();
        loanSteps.getTheLoan();
    }

}
