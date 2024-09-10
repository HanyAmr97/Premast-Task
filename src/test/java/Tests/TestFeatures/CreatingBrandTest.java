package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import org.testng.annotations.Test;
import pages.Brands.BrandCreation;
import pages.Brands.BrandsPage;
import pages.RegisterUser.DeleteAccount;
import pages.RegisterUser.HomePage;
import pages.RegisterUser.SignUpPage;


public class CreatingBrandTest extends SetUp_Website {

    @Test
    public void createBrand() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl(website);
        homePage.clickOnTryForFree();


        SignUpPage signUp = new SignUpPage(driver);
        signUp.assertSignupPage();
        signUp.validUserSignup();

        BrandsPage brand=new BrandsPage(driver);
        brand.getBrandsPage();
        brand.assertBrandsPage();

        BrandCreation brand1 = new BrandCreation(driver);
        brand1.getBrandsPage();
        brand1.assertBrandsPage();
        brand1.createValidNewBrand();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.openAccountSettings();
        deleteAccount.accountDelete();

    }
}
