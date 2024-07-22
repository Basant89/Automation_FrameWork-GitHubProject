package testclasses;

import in.edso.pages.CafeFinderTabPage;
import in.edso.pages.HomePage;
import in.edso.testbase.WebTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CafeFinderTabTest extends WebTestBase {

    //Creating instance variable for all required page classes
    HomePage homePage;
    CafeFinderTabPage cafeFinderTabPage;

    //Calling constructor of CafeFinderTabTest class
    public CafeFinderTabTest(){
        super();
    }

    @BeforeMethod
    public void beforeMethod(){
        initialization();
        homePage=new HomePage();
        cafeFinderTabPage=new CafeFinderTabPage();
    }

    @Test(description = "Verify user able to find cafe with Near by option")
    public void verifyUserAbleToFindCafeWithNearByOpt(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickOnCafeFinderTab();
        cafeFinderTabPage.clickCafeFinderTab();
        String errorMessageT=cafeFinderTabPage.getTextOfErrorMessage();
        softAssert.assertEquals(errorMessageT,"YOUR LOCATION", "Error message should be matched");
        softAssert.assertAll();
    }

    @Test(description = "Verify user able to find cafe with Postcode/Suburb")
    public void verifyUserAbleToFindCafeWithPostcodeSuburb(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAdWithOutClickedUserLogo();
        homePage.clickOnCafeFinderTab();
        cafeFinderTabPage.clickCafeFinderTabPostCodeSuburb();
        cafeFinderTabPage.setPostCode(prop.getProperty("postcode"));
        String popUpText=cafeFinderTabPage.getTextOfErrorMessagePopUp();
        softAssert.assertEquals(popUpText,"Please choose a postcode/suburb", "Error PopUp box text should be match");
        cafeFinderTabPage.closeErrorMessagePopUp();
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
