package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudPage;
import page.PricingCalculatorPage;
import page.TenMinutEmailPage;

import java.util.ArrayList;

public class GoogleCloudCalculatorTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkTotalEstimatedMonthlyCost() {

       /* 1. Открыть https://cloud.google.com/
        * 2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
        * 3. Запустить поиск, нажав кнопку поиска.
        * 4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
        */
        PricingCalculatorPage calculatorPage = new GoogleCloudPage(driver)
                .openPage()
                .clickSearchBtn()
                .searchForPricingCalculator("Google Cloud Platform Pricing Calculator")
                .goTOPricingCalculator();

        double totalEstimatedMonthlyCost = calculatorPage
                .goToCalculatorFrame()
                .activateComputeEngine() // 5. Активировать раздел COMPUTE ENGINE вверху страницы
                .selectNumberOfInstances() // filling out the form
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
                .clickAddToEstimateButton() // 7. Нажать Add to Estimate
                .getTotalEstimatedMonthlyCost();

        // 9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // 10. Скопировать почтовый адрес сгенерированный в 10minutemail
        TenMinutEmailPage mailPage = new TenMinutEmailPage(driver);
        String mailAddress = mailPage.openPage().copyMailAddress();

        // 11. Вернуться в калькулятор,
        driver.switchTo().window(tabs.get(0));
        calculatorPage.goToCalculatorFrame()
                .clickEmailEstimateButton() // 8. Выбрать пункт EMAIL ESTIMATE
                .fillEmailField(mailAddress)  // в поле Email ввести адрес из предыдущего пункта
                .clickSendEmailButton(); // 12. Нажать SEND EMAIL

        //13. Дождаться письма с расчетом стоимости и проверить
        // что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
        driver.switchTo().window(tabs.get(1));
        double totalEstimatedMonthlyCostFromEmail = mailPage.openMail().getTotalEstimatedMonthlyCostFromEmail();

        Assert.assertEquals(totalEstimatedMonthlyCost, totalEstimatedMonthlyCostFromEmail);

    }

    @AfterMethod(alwaysRun = true)
    public void BrowserClose() {
        driver.quit();
        driver = null;
    }

}
