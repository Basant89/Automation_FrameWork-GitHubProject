package testclasses;

import in.edso.pages.HomePage;
import in.edso.testbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends WebTestBase {
    HomePage homePage;

    public HomeTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage=new HomePage();
    }

    @Test(description = "Verify Cafe Finder tab clickable & window title matching")
    public void verifyCafeFinderTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickOnCafeFinderTab();
        String expectedTitle=prop.getProperty("actualTitle");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify OurStory tab clickable & window title matching")
    public void verifyOurStoryTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickOurStoryTab();
        String expectedTitle=prop.getProperty("actualTitle1");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify Shop tab clickable & window title matching")
    public void verifyShopTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickShopTabTab();
        String expectedTitle=prop.getProperty("actualTitle2");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify Subscriptions tab clickable & window title matching")
    public void verifySubscriptionsTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickSubscriptionsTab();
        String expectedTitle=prop.getProperty("actualTitle3");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify BrewGuides tab clickable & window title matching")
    public void verifyBrewGuidesTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickBrewGuidesTab();
        String expectedTitle=prop.getProperty("actualTitle4");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify News tab clickable & window title matching")
    public void verifyNewsTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickNewsTab();
        String expectedTitle=prop.getProperty("actualTitle5");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify Wholesale tab clickable & window title matching")
    public void verifyWholesaleTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickWholesaleTab();
        String expectedTitle=prop.getProperty("actualTitle6");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify WOOLWORTHS COMP tab clickable & window title matching")
    public void verifyWoolWorthsCompTabClickableOrNot(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickWoolWorthsCompTab();
        String expectedTitle=prop.getProperty("actualTitle7");
        String actualTitleText=driver.getTitle();
        softAssert.assertEquals(actualTitleText,expectedTitle,"Title text should be match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
