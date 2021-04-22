package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleCloudPage;

public class GoogleCloudPageTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkTotalEstimatedMonthlyCost() {

        double totalEstimatedMonthlyCost =
                new GoogleCloudPage(driver)
                .openPage()
                .clickSearchBtn()
                .searchForPricingCalculator("Google Cloud Platform Pricing Calculator")
                .goTOPricingCalculator()
                .goToCalculatorFrame()
                .activateComputeEngine()
                //filling out the form
                .selectNumberOfInstances()
                .selectOS()
                .selectMachineClass()
                .selectMachineSeries()
                .selectMachineType()
                .selectAddGPUsCheckbox()
                .selectNumberOfGPUs()
                .selectGPUType()
                .selectLocalSSD()
                .selectDatacenterLocation()
                .selectCommittedUsage()
                .clickAddToEstimateButton()
                .getTotalEstimatedMonthlyCost();


//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.get("http://google.com");
//
//                System.out.println("Just text");


        Assert.assertEquals(totalEstimatedMonthlyCost, 1082.77, "Search results are empty!");

    }




    @AfterMethod(alwaysRun = true)
    public void BrowserClose() {
        driver.quit();
        driver = null;
    }



}
