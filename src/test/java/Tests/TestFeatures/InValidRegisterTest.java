package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import org.testng.annotations.Test;
import pages.RegisterUser.HomePage;
import pages.RegisterUser.SignUpPage;

public class InValidRegisterTest extends SetUp_Website {
    @Test
    public void completeRegister() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnTryForFree();

        SignUpPage signUp = new SignUpPage(driver);
        signUp.assertSignupPage();
        signUp.inValidUserSignup();

    }
}
