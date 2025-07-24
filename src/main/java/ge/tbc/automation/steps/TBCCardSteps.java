package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.TBCCardPage;
import org.testng.Assert;

public class TBCCardSteps {
    private final TBCCardPage tbcPage;

    public TBCCardSteps(Page page) {
        this.tbcPage = new TBCCardPage(page);
    }

    public TBCCardSteps getTheQRCode() {
        tbcPage.getCardBtn().click();

        tbcPage.QRCode().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000));

        Assert.assertTrue(tbcPage.QRCode().isVisible(), "QR Code should be visible after clicking the card button");
        return this;
    }
}
