package testclasses;

import in.edso.pages.HomePage;
import in.edso.pages.LoginPage;
import in.edso.pages.MyAccountPage;
import in.edso.testbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends WebTestBase {

    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
      homePage=new HomePage();
      loginPage=new LoginPage();
      myAccountPage=new MyAccountPage();
    }

    @Test(description = "Verify login with valid username & valid password")
    public void verifyLoginWithValidUsernamePassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        String myAccountText= myAccountPage.getTextOfMyAccount();
        softAssert.assertEquals(myAccountText,"MY ACCOUNT", "MY ACCOUNT Text should be matched");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with invalid username & password")
    public void verifyLoginWithInvalidUsernameAndPassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();;
        loginPage.setLogin(prop.getProperty("invalidusername"), prop.getProperty("invalidpassword"));
        String actualErrorMessageText= loginPage.getErrorMessageTextForInvalidUsernameAndPassword();
        softAssert.assertEquals(actualErrorMessageText,"ERROR: The username or password you entered is incorrect. Lost your password?", "Error message text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with valid username & invalid password")
    public void verifyLoginWithValidUsernameAndInvalidPassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();;
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("invalidpassword"));
        String actualErrorMessageText= loginPage.getErrorMessageTextForInvalidUsernameAndPassword();
        softAssert.assertEquals(actualErrorMessageText,"ERROR: The username or password you entered is incorrect. Lost your password?", "Error message text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with invalid username & valid password")
    public void verifyLoginWithInvalidUsernameAndValidPassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();;
        loginPage.setLogin(prop.getProperty("invalidusername"), prop.getProperty("password"));
        String actualErrorMessageText= loginPage.getErrorMessageTextForInvalidUsernameAndPassword();
        softAssert.assertEquals(actualErrorMessageText,"ERROR: The username or password you entered is incorrect. Lost your password?", "Error message text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with blank username & valid password")
    public void verifyLoginWithBlankUsernameAndValidPassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();;
        loginPage.setLogin(prop.getProperty("blankusername"), prop.getProperty("password"));
        String actualErrorMessageText= loginPage.getErrorUserNameRequired();
        softAssert.assertEquals(actualErrorMessageText,"Error: Username is required.", "Username required Error message text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with valid username & blank password")
    public void verifyLoginWithValidUsernameAndBlankPassword(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();;
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("blankpassword"));
        String actualErrorMessageText= loginPage.getErrorPasswordRequired();
        softAssert.assertEquals(actualErrorMessageText,"Error: The password field is empty.", "Password required Error message text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify logout button is displayed in My Account page")
    public void verifyLogOutBtnDisplayed(){
        SoftAssert softAssert1=new SoftAssert();
        homePage.closeFirstAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        softAssert1.assertTrue(myAccountPage.logOutBtnDisplayed(), "Logout button should be displayed.");
        softAssert1.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
