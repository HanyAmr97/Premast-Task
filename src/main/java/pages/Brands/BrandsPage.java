package pages.Brands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BrandsPage {
    final By brandsPage = By.xpath("//a[contains(text(),'Brands')]");
    final  By brandsText = By.xpath("//h2[contains(text(),'Brands')]");

    protected WebDriver driver;

    //Constructor for the page
    public BrandsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getBrandsPage() {
        driver.findElement(brandsPage).click();
    }
    public void assertBrandsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(brandsText).getText(), "Brands");
        softAssert.assertAll();
    }


}
