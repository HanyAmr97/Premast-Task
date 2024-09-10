package pages.RegisterUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;

public class HomePage {
    protected WebDriver driver;
    private final By signupPage = By.xpath("//span[contains(text(),'Try for free')]");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void openUrl(String url) {
        try {
            int respCode;
            HttpURLConnection huc = (HttpURLConnection) (new URL(url)).openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            respCode = huc.getResponseCode();
            if (respCode >= 400) {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("URL is wrong !!!!");
            System.exit(0);
        }
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), "Premast | Elevate Your Presentations with Professional Design Solutions");
    }

    public void clickOnTryForFree() {
        driver.findElement(signupPage).click();

    }
}
