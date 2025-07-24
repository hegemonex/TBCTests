package ge.tbc.automation.tests;

import ge.tbc.automation.setUp.BaseTest;
import ge.tbc.automation.steps.CurrencySteps;
import ge.tbc.automation.steps.MainSteps;
import ge.tbc.automation.steps.SearchSteps;
import ge.tbc.automation.steps.TBCCardSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TbcUiTests extends BaseTest {
    MainSteps steps;
    CurrencySteps currencySteps;
    TBCCardSteps tbcSteps;
    SearchSteps searchSteps;

    @BeforeMethod
    public void initSteps() {
        steps = new MainSteps(page);
        currencySteps = new CurrencySteps(page);
        tbcSteps = new TBCCardSteps(page);
        searchSteps = new SearchSteps(page);
    }

    @Test
    public void currencyTest() {
        steps.goToCurrencyPage();
        currencySteps.calculateCurrency();
    }

    @Test
    public void searchTest() {
        steps.clickSearch();
        searchSteps
                .searchInvalid()
                .searchValid();
    }

}
