package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebTestBase {

    @FindBy(id="username")
    WebElement userNameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(id = "rememberme")
    WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostPassword;

    @FindBy(xpath = "//a[text()='Click here']")
    WebElement clickHereToRegister;

    @FindBy(xpath = "//li[contains(.,': The username or password you entered is incorrect. ')]")
    WebElement errorInvalidUPText;

    @FindBy(xpath = "//ul[contains(.,' Username is required. ')]")
    WebElement errorUserNameRequired;

    @FindBy(xpath = "//ul[contains(., ' The password field is empty. ')]")
    WebElement errorPasswordRequired;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


    //Function for perform Login operations in login page.
    public void setLogin(String userName, String password){
        WebElementUtil.sendTextToElement(userNameTextBox, userName);
        WebElementUtil.sendTextToElement(passwordTextBox, password);
        CommonWaits.waitUtilElementToBeClickable(loginBtn);
    }

    //Function to click on Click Here to Register link on login page
    public void clickOnClickHereToRegister(){WebElementUtil.clickOnElement(clickHereToRegister);}

    //Function to click on Lost Your Password link on login page.
    public void lostYourPassword() {WebElementUtil.clickOnElement(lostPassword);}


    //Functions for getting Error message from Error message pop-ups.
    public String getErrorMessageTextForInvalidUsernameAndPassword(){return WebElementUtil.getTextOfElement(errorInvalidUPText);}
    public String getErrorUserNameRequired(){return WebElementUtil.getTextOfElement(errorUserNameRequired);}
    public String getErrorPasswordRequired(){return WebElementUtil.getTextOfElement(errorPasswordRequired);}
}
