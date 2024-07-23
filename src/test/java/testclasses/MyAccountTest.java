package testclasses;

import in.edso.pages.HomePage;
import in.edso.pages.LoginPage;
import in.edso.pages.MyAccountPage;
import in.edso.testbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyAccountTest extends WebTestBase {

    HomePage homePage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;

    public MyAccountTest(){super();}

    @BeforeMethod
    public void beforeMethod()
    {
        initialization();
        homePage=new HomePage();
        myAccountPage=new MyAccountPage();
        loginPage=new LoginPage();
    }

    @Test(description = "Verify Dashboard tab clickable at my account page")
    public void verifyDashBoardTabClickableAtMAPage(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        myAccountPage.clickDashBordMA();
        String infoText=myAccountPage.getTextOfSecondLineInDashBoardPage();
        softAssert.assertEquals(infoText, "From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.", "Second line info text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify Orders tab clickable at my account page")
    public void verifyOrdersTabClickableAtMAPage(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        myAccountPage.clickOrdersMA();
        String infoText=myAccountPage.getBrowserProductsBtn();
        softAssert.assertEquals(infoText, "BROWSE PRODUCTS", "Second line info text should be match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){driver.close();}
}
