package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnbordingPage extends WebTestBase{

    @FindBy(name = "email")
    WebElement nUserEmail;

    @FindBy(name = "password")
    WebElement nUserPassword;

    @FindBy(xpath = "//span[text()='Sign up to the Campos Coffee Newsletter']")
    WebElement signUpCCNews;

    @FindBy(name = "register")
    WebElement nUserRegisterBtn;

    @FindBy(xpath = "//a[text()='Please log in.']//preceding-sibling::text()")
    WebElement errorMessage;

    public OnbordingPage(){
        PageFactory.initElements(driver,this);
    }

    public void newUserRegister(String newUserEmail, String newUserPass){
        WebElementUtil.sendTextToElement(nUserEmail,newUserEmail);
        WebElementUtil.sendTextToElement(nUserPassword,newUserPass);
        CommonWaits.waitUtilElementToBeClickable(signUpCCNews);
        CommonWaits.waitUtilElementToBeClickable(nUserRegisterBtn);
    }

    public String getTextOfMyAccount(){
        return WebElementUtil.getTextOfElement(errorMessage);
    }
}
