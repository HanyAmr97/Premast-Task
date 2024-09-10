package pages.RegisterUser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;

public class SignUpPage {

    final By signupEmail = By.name("email");
    final By signupPass = By.name("password");
    final By signupConfirmPass = By.name("confirmPassword");
    final By signupBtn = By.xpath("//span[contains(text(),'Sign Up')]");
    final By invalidMessage = By.xpath("//div[contains(text(),'Invalid password')]");



    protected WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertSignupPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "");
        softAssert.assertAll();
    }

    public void validUserSignup() throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(signupEmail).sendKeys((String) emailObj.get("Email"));

        JSONObject passObj = (JSONObject) obj;
        driver.findElement(signupPass).sendKeys((String) passObj.get("Password"));

        JSONObject confirmPassObj = (JSONObject) obj;
        driver.findElement(signupConfirmPass).sendKeys((String) confirmPassObj.get("Confirm Password"));


        driver.findElement(signupBtn).click();
        Thread.sleep(30000);


    }

    public void inValidUserSignup() throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/Resources/TestDataFiles/RegisterData.json");
        Object obj = jsonParser.parse(reader);

        JSONObject emailObj = (JSONObject) obj;
        driver.findElement(signupEmail).sendKeys((String) emailObj.get("Email"));

        JSONObject passObj = (JSONObject) obj;
        driver.findElement(signupPass).sendKeys((String) passObj.get("Invalid password"));

        JSONObject confirmPassObj = (JSONObject) obj;
        driver.findElement(signupConfirmPass).sendKeys((String) confirmPassObj.get("Invalid password"));

        driver.findElement(signupBtn).click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(invalidMessage).getText(), "Invalid password");
        softAssert.assertAll();

    }


}
