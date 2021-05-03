package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends BasePage {
    private static final String PAGE_URL = "https://cloud.google.com";

    public GoogleCloudPage(WebDriver driver) { super(driver); }

    @FindBy(className = "devsite-search-form")
    private WebElement searchFormIcon;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchTextField;


    //1. Открыть https://cloud.google.com/
    public GoogleCloudPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    //2. Нажав кнопку поиска по порталу вверху страницы,
    public GoogleCloudPage clickSearchBtn() {
        waitVisibilityOf(searchFormIcon).click();
        return this;
    }

    //ввести в поле поиска "Google Cloud Platform Pricing Calculator"
    //3. Запустить поиск, нажав кнопку поиска.
    public GoogleSearchResultsPage searchForPricingCalculator(String searchTerm) {
        waitVisibilityOf(searchTextField).sendKeys(searchTerm);
        searchTextField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultsPage(driver);
    }
}
