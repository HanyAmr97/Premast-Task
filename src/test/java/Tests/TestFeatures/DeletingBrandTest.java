package Tests.TestFeatures;

import Tests.Browser.SetUp_Website;
import org.testng.annotations.Test;
import pages.Brands.BrandCreation;
import pages.Brands.BrandsPage;
import pages.Brands.DeleteBrands;
import pages.RegisterUser.DeleteAccount;
import pages.RegisterUser.HomePage;
import pages.RegisterUser.SignUpPage;

public class DeletingBrandTest extends SetUp_Website {
    @Test
    public void deleteBrand() throws Exception {
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
        brand1.createValidNewBrand();

        DeleteBrands deleteBrands=new DeleteBrands(driver);
        deleteBrands.openBrandSettingsPage();
        deleteBrands.brandDeleting();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.openAccountSettings();
        deleteAccount.accountDelete();

    }
}
