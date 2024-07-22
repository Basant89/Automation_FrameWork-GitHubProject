package testclasses;

import in.edso.pages.ForgotPasswordPage;
import in.edso.pages.HomePage;
import in.edso.pages.LoginPage;
import in.edso.testbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        forgotPasswordPage=new ForgotPasswordPage();
    }

    @Test(description = "Verify user able to reset password")
    public void verifyUserAbleToResetPassword()
    {
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.lostYourPassword();
        forgotPasswordPage.resetForgotPassword(prop.getProperty("username"));
        String errorMessage=forgotPasswordPage.getTextOfErrorMessage();
        softAssert.assertEquals(errorMessage, "Password reset email has been sent.", "Error message should be match with THANK YOU page.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.close();
    }
}
