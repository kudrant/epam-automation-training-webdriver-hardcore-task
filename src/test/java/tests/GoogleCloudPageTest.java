package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleCloudPage;

import java.util.concurrent.TimeUnit;

public class GoogleCloudPageTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void commonSearchTermResultsNotEmpty() {

        //double totalEstimatedMonthlyCost =
                new GoogleCloudPage(driver)
                .openPage()
                .clickSearchBtn()
                .searchForPricingCalculator("Google Cloud Platform Pricing Calculator");
        System.out.println("sdfsdfsdf");
        //Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty!");

    }

    @AfterMethod(alwaysRun = true)

    public void BrowserClose() {
        driver.quit();
        driver = null;
    }



}
