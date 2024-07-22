package testclasses;

import in.edso.pages.HomePage;
import in.edso.pages.LoginPage;
import in.edso.pages.OnbordingPage;
import in.edso.testbase.WebTestBase;
import in.edso.util.WebElementUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OnbordingTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    OnbordingPage onbordingPage;

    public OnbordingTest()
    {
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        onbordingPage=new OnbordingPage();
    }

    @Test(description = "Verify new user registration with SIGN UP CC Newsletter")
    public void verifyNewUserRegistrationWithCCNewsLetter(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.clickOnClickHereToRegister();
        onbordingPage.newUserRegister(prop.getProperty("username"), prop.getProperty("password"));
        String onBordErrorMessage= onbordingPage.getTextOfMyAccount();
        softAssert.assertEquals(onBordErrorMessage,"Error:", "Error message text should be match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.close();
    }
}
