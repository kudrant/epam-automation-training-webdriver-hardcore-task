package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TenMinutEmailPage extends BasePage{
    private static final String PAGE_URL = "https://10minutemail.com";

    public TenMinutEmailPage(WebDriver driver) { super(driver); }

    public TenMinutEmailPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    @FindBy(xpath = "//input[@id='mail_address']")
    private WebElement mailAddress;

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copyMailAddressBtn;

    @FindBy(xpath = "//div[@class='small_sender']")
    private WebElement incomingMail;

    @FindBy(xpath = "//h3[contains(.,'USD')]")
    private WebElement totalEstimatedCostFromEmail;

    public String copyMailAddress() {

        waitVisibilityOf(copyMailAddressBtn).click();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String mailAddress = null;
        try {
            mailAddress = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return mailAddress;
    }

    public TenMinutEmailPage openMail() {
        waitVisibilityOf(incomingMail).click();
        return this;
    }

    public double getTotalEstimatedMonthlyCostFromEmail() {
        return Double.parseDouble(totalEstimatedCostFromEmail.getText()
                .split(" ")[1]
                .replaceAll(",", ""));
    }




}
