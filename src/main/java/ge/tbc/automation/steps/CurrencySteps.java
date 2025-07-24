package ge.tbc.automation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.CurrencyPage;
import org.testng.Assert;

public class CurrencySteps {
    private final CurrencyPage currencyPage;

    public CurrencySteps(Page page) {
        this.currencyPage = new CurrencyPage(page);
    }

    public CurrencySteps calculateCurrency() {
        validateConversion(1);
        validateConversion(20);
        validateConversion(100);
        validateConversion(1000);
        validateConversion(17);
        return this;
    }

    public CurrencySteps checkWholesalePrices() {
        currencyPage.wholsalePriceBtn().click();

        String valueText = currencyPage.wholsaleCourse().nth(3).textContent().trim();
        String offValueText = currencyPage.officialCourse().first().textContent().trim();

        double value = extractDouble(valueText);
        double offValue = extractDouble(offValueText);

        Assert.assertNotEquals(value, offValue);
        return this;
    }

    private void validateConversion(double value) {
        Locator usdInput = currencyPage.USD();
        usdInput.click();
        usdInput.clear();

        String text = currencyPage.conversionRate().innerText();
        double secondNumber = Double.parseDouble(
                text.replaceAll(".*=\\s*([0-9]+\\.?[0-9]*).*", "$1")
        );

        usdInput.fill(String.valueOf(value));

        double bought = Double.parseDouble(usdInput.inputValue());
        double sold = bought * secondNumber;
        double soldRounded = Math.round(sold * 100.0) / 100.0;
        double actualSold = Double.parseDouble(currencyPage.GEL().inputValue());

        Assert.assertEquals(actualSold, soldRounded, 0.001,
                "Conversion mismatch: expected " + soldRounded + " but found " + actualSold);
    }


    private double extractDouble(String text) {
        String numberOnly = text.replaceAll("[^\\d.\\-]+", "");
        if (numberOnly.isEmpty()) {
            throw new NumberFormatException("No numeric value found in: " + text);
        }
        return Double.parseDouble(numberOnly);
    }
}