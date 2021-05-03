package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().window().maximize();

    }

    protected WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, 300)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
