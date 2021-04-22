package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorPage extends BasePage{

    public PricingCalculatorPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//div[@class='tab-holder compute']//div[@class='name ng-binding']")
    private WebElement computeEngine;

    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/../input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemsDropdownList;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement operatingSystem;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClassDropdownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='regular']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement machineSeriesDropDownList;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement machineSeries;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropdownList;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropdownList;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value='1']")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropdownList;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropdownList;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedSsd'][@value='2']")
    private WebElement localSSD;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropdownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[contains(.,'Frankfurt (europe-west3)')]")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropdownList;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement committedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    private WebElement totalEstimatedMonthlyCost;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateBtn;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement mailAddressField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailBtn;


    public PricingCalculatorPage goToCalculatorFrame() {
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public PricingCalculatorPage activateComputeEngine() {
        waitVisibilityOf(computeEngine).click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfInstances() {
        numberOfInstances.sendKeys("4");
        return this;
    }

    public PricingCalculatorPage selectOS() {
        operatingSystemsDropdownList.click();
        waitVisibilityOf(operatingSystem).click();
        return this;
    }

    public PricingCalculatorPage selectMachineClass() {
        machineClassDropdownList.click();
        waitVisibilityOf(machineClass).click();
        return this;
    }

    public PricingCalculatorPage selectMachineSeries() {
        machineSeriesDropDownList.click();
        waitVisibilityOf(machineSeries).click();
        return this;
    }

    public PricingCalculatorPage selectMachineType() {
        machineTypeDropdownList.click();
        waitVisibilityOf(machineType).click();
        return this;
    }

    public PricingCalculatorPage selectAddGPUsCheckbox() {
        addGPUsCheckbox.click();
        return this;
    }

    public PricingCalculatorPage selectNumberOfGPUs() {
        numberOfGPUsDropdownList.click();
        waitVisibilityOf(numberOfGPUs).click();
        return this;
    }

    public PricingCalculatorPage selectGPUType() {
        gpuTypeDropdownList.click();
        waitVisibilityOf(gpuType).click();
        return this;
    }

    public PricingCalculatorPage selectLocalSSD() {
        localSSDDropdownList.click();
        waitVisibilityOf(localSSD).click();
        return this;
    }

    public PricingCalculatorPage selectDatacenterLocation() {
        datacenterLocationDropdownList.click();
        waitVisibilityOf(datacenterLocation).click();
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage() {
        committedUsageDropdownList.click();
        waitVisibilityOf(committedUsage).click();
        return this;
    }

    public PricingCalculatorPage clickAddToEstimateButton() {
        waitVisibilityOf(addToEstimateBtn).click();
        return this;
    }

    public double getTotalEstimatedMonthlyCost() {
        return Double.parseDouble(totalEstimatedMonthlyCost.getText()
                .split("USD ")[1]
                .replaceAll(",", "")
                .split(" ")[0]);
    }

    public PricingCalculatorPage clickEmailEstimateButton() {
        waitVisibilityOf(emailEstimateBtn).click();
        return this;
    }

    public PricingCalculatorPage fillEmailField(String mailAddress) {
        waitVisibilityOf(mailAddressField).sendKeys(mailAddress);
        return this;
    }

    public PricingCalculatorPage clickSendEmailButton() {
        waitVisibilityOf(sendEmailBtn).click();
        return this;
    }











}
