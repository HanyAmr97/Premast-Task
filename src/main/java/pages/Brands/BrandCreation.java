package pages.Brands;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;

public class BrandCreation {
    final By createBrandBtn = By.xpath("//span[contains(text(),'Create New Brand')]");
    final By createNewBrandBtn = By.xpath("//button[@class='ant-btn css-p7e5j5 ant-btn-primary']");
    final By createNewBrandTxt = By.xpath("//h3[contains(text(),'Create new Brand')]");
    final By brandName = By.xpath("//input[@id='name']");
    final By firstUpload = By.xpath("//body/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]/div[1]");
    final By secondUpload = By.xpath("//body/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/span[1]/div[1]/div[1]");
    final By errorMessage = By.xpath("//span[contains(text(),'Image must smaller than 2MB!')]");
    final By submitBtn = By.xpath("//button[@type='submit']");
    final By closeBtn= By.xpath("//button[@class='ant-modal-close']");
    protected WebDriver driver;

    //Constructor for the page
    public BrandCreation(WebDriver driver) {
        this.driver = driver;
    }
    public void getBrandsPage() {
        driver.findElement(createBrandBtn).click();
    }
    public void assertBrandsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(createNewBrandTxt).getText(), "");
        softAssert.assertAll();
    }
    public void createValidNewBrand() throws Exception {
        driver.findElement(createNewBrandBtn).click();
        driver.findElement(firstUpload).click()
        ;
        Thread.sleep(5000);
        Robot robo1=new Robot();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("C:\\Users\\AlBadr\\Desktop\\Premast.PNG"),null);
        robo1.keyPress(KeyEvent.VK_CONTROL);
        robo1.keyPress(KeyEvent.VK_V);
        robo1.keyRelease(KeyEvent.VK_CONTROL);
        robo1.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject brandNameObj = (JSONObject) obj;
        driver.findElement(brandName).sendKeys((String) brandNameObj.get("Brand Name"));

        Thread.sleep(5000);

        driver.findElement(secondUpload).click();
        Thread.sleep(5000);
        Robot robo2=new Robot();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("C:\\Users\\AlBadr\\Desktop\\Premast.PNG"),null);
        robo2.keyPress(KeyEvent.VK_CONTROL);
        robo2.keyPress(KeyEvent.VK_V);
        robo2.keyRelease(KeyEvent.VK_CONTROL);
        robo2.keyPress(KeyEvent.VK_ENTER);

        driver.findElement(submitBtn).click();

    }

    public void createInValidNewBrand() throws Exception {
        driver.findElement(createNewBrandBtn).click();
        driver.findElement(secondUpload).click();

        Thread.sleep(5000);

        Robot robo1=new Robot();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("C:\\Users\\AlBadr\\Desktop\\Size2.jpg"),null);
        robo1.keyPress(KeyEvent.VK_CONTROL);
        robo1.keyPress(KeyEvent.VK_V);
        robo1.keyRelease(KeyEvent.VK_CONTROL);
        robo1.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        try {
            Alert a = driver.switchTo().alert();
            a.accept();
        } catch (Exception ignored) {
        }

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(errorMessage).getText(),"Image must smaller than 2MB!");
        softAssert.assertAll();

        Thread.sleep(5000);

        driver.findElement(closeBtn).click();

    }
}
