package pages.Brands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class DeleteBrands {
    final By brandEditingBtn = By.xpath("//i[@class='fi fi-sr-menu-dots-vertical']");
    final By logosPage = By.xpath("//span[contains(text(),'Logos')]");
    final By brandSettingBtn = By.xpath("//body/div[5]/div[1]/ul[1]/li[3]");
    final By deleteBtn =By.xpath("//button[@class='ant-btn css-p7e5j5 ant-btn-primary ant-btn-dangerous']");
    final By count_0 = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/sup[1]");


    protected WebDriver driver;

    //Constructor for the page
    public DeleteBrands(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrandSettingsPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(brandEditingBtn).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(logosPage).getText(),"Logos");
        softAssert.assertAll();
        Thread.sleep(5000);

    }
    public void brandDeleting(){
        driver.findElement(brandSettingBtn).click();
        try {
            Alert a = driver.switchTo().alert();
            a.accept();
        } catch (Exception ignored){

        }
        driver.findElement(deleteBtn).click();

        String str = driver.findElement(count_0).getText();
        if (str.contains("0")) {
            System.out.println("Your brand has been deleted successfully!");
        } else {
            System.out.println("Your brand has not been deleted!");
        }
    }
}
