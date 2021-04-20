package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchResultsPage extends GoogleCloudPage{

    public GoogleSearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
    }


    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement calculatorLink;

    public PricingCalculatorPage searchForPricingCalculator() {
        calculatorLink.click();
        return new PricingCalculatorPage(driver);
    }
}
