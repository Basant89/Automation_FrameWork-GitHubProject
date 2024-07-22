package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CafeFinderTabPage extends WebTestBase {

    //Elements in Cafe Finder tab
    @FindBy(xpath = "//div[@class='mc-modal']//child::button")
    WebElement iFBtn;

    @FindBy(xpath = "(//*[local-name()='svg'])[10]")
    WebElement lookingForCamposCafeNearMe;

    @FindBy(xpath = "//li[contains(text(),'Near Me')]")
    WebElement nearMeOpt;

    @FindBy(xpath ="//li[contains(text(),'Postcode/Suburb')]")
    WebElement postcodeSuburbOpt;

    @FindBy(id = "locationSearch")
    WebElement insertPostCodeSubTextBox;

    @FindBy(className = "general-dialog-content")
    WebElement getErrorMessagePopUpText;

    @FindBy(className = "ngdialog-close")
    WebElement errorMessagePopUpCloseBtn;

    @FindBy(xpath = "//button[@id='locationSearchButton']")
    WebElement findMeBtn;

    @FindBy(xpath = "//h2[contains(@class, 'map-inner-header-result') and contains(@class, 'ng-scope')]")
    WebElement errorMessageText;

    //Calling constructor to initialize all elements in this page class
    public CafeFinderTabPage(){
        PageFactory.initElements(driver,this);
    }



    public void clickCafeFinderTab(){
        CommonWaits.waitUtilElementToBeClickable(iFBtn);
        CommonWaits.waitUtilElementToBeClickable(lookingForCamposCafeNearMe);
        CommonWaits.waitUtilElementToBeClickable(nearMeOpt);
        CommonWaits.waitUtilElementToBeClickable(findMeBtn);
    }
    public String getTextOfErrorMessage(){
        CommonWaits.waitUtilElementToBeClickable(errorMessageText);
        return WebElementUtil.getTextOfElement(errorMessageText);
    }

    public void setPostCode(String postCode1){
        WebElementUtil.sendTextToElement(insertPostCodeSubTextBox,postCode1);
        CommonWaits.waitUtilElementToBeClickable(findMeBtn);
    }

    public void clickCafeFinderTabPostCodeSuburb(){
        CommonWaits.waitUtilElementToBeClickable(iFBtn);
        CommonWaits.waitUtilElementToBeClickable(lookingForCamposCafeNearMe);
        CommonWaits.waitUtilElementToBeClickable(postcodeSuburbOpt);
    }

    public String getTextOfErrorMessagePopUp(){
        CommonWaits.waitUtilElementToBeClickable(getErrorMessagePopUpText);
        return WebElementUtil.getTextOfElement(getErrorMessagePopUpText);
    }

    public void closeErrorMessagePopUp(){
        CommonWaits.waitUtilElementToBeClickable(errorMessagePopUpCloseBtn);
    }
}
