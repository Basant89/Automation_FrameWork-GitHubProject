package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends WebTestBase {


    @FindBy(name="user_login")
    WebElement userNameOrEmail;

    @FindBy(xpath = "//input[@value='Reset password']")
    WebElement resetPasswordBtn;

    @FindBy(className = "woocommerce-message")
    WebElement errorMessageInThankYouPage;

    public ForgotPasswordPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void resetForgotPassword(String userEmail)
    {
        WebElementUtil.sendTextToElement(userNameOrEmail,userEmail);
        CommonWaits.waitUtilElementToBeClickable(resetPasswordBtn);
    }

    public String getTextOfErrorMessage()
    {
        return WebElementUtil.getTextOfElement(errorMessageInThankYouPage);
    }
}
