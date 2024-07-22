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

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void setLogin(String userName, String password){
        WebElementUtil.sendTextToElement(userNameTextBox, userName);
        WebElementUtil.sendTextToElement(passwordTextBox, password);
        CommonWaits.waitUtilElementToBeClickable(loginBtn);
    }

    public void clickOnClickHereToRegister(){
        WebElementUtil.clickOnElement(clickHereToRegister);
    }

    public void lostYourPassword()
    {
        WebElementUtil.clickOnElement(lostPassword);
    }
}
