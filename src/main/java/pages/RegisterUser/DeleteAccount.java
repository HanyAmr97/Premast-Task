package pages.RegisterUser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;


public class DeleteAccount {
    final By accountDropList = By.xpath("//div[@class='css-kbdj9e']");
    final By settingsBtn = By.xpath("//a[contains(text(),'Settings')]");
    final By deleteAccount = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-izn7qc']");
    final By deleteBtn = By.xpath("//button[@data-cy='confirm-delete']");
    final By accountIsDeleted = By.xpath("//h1[contains(text(),'Welcome Back!')]");

    protected WebDriver driver;

    //Constructor for the page
    public DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void openAccountSettings() throws InterruptedException {
        WebElement webElement =driver.findElement(accountDropList);
        new Actions(driver).moveToElement(webElement).perform();
        driver.findElement(settingsBtn).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://app.premast.com/account/settings");
        softAssert.assertAll();
    }

    //Checking the delete account
    public void accountDelete() {
        driver.findElement(deleteAccount).click();
        try {
            Alert a = driver.switchTo().alert();
            a.accept();
        } catch (Exception ignored){

        }
        driver.findElement(deleteBtn).click();
        String str = driver.findElement(accountIsDeleted).getText();
        if (str.contains("Welcome Back")) {
            System.out.println("Congrats! Your account has been created successfully!");
        } else {
            System.out.println("unfortunately! Your account has been not created!");
        }

    }

}
