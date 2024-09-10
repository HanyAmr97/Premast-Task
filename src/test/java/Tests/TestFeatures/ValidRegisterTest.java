package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import org.testng.annotations.Test;
import pages.RegisterUser.*;
import pages.RegisterUser.DeleteAccount;

public class ValidRegisterTest extends SetUp_Website {
    @Test
    public void completeRegister() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnTryForFree();

        SignUpPage signUp = new SignUpPage(driver);
        signUp.assertSignupPage();
        signUp.validUserSignup();


        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.openAccountSettings();
        deleteAccount.accountDelete();
    }
}
