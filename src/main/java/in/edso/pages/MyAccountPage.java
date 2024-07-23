package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends WebTestBase {

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logOutBtn;


    //My Account Navigation Menu Tabs options elements
    @FindBy(xpath = "//a[text()='Dashboard']")
    WebElement dashBordMA;

    @FindBy(xpath = "//a[text()='Orders']")
    WebElement ordersMA;

    @FindBy(xpath = "//a[text()='Subscriptions']")
    WebElement subscriptionsMA;

    @FindBy(xpath = "//a[text()='Coupons']")
    WebElement couponsMA;

    @FindBy(xpath = "//a[text()='Addresses']")
    WebElement addressesMA;

    @FindBy(xpath = "//a[text()='Payment methods']")
    WebElement paymentMethodsMA;

    @FindBy(xpath = "//a[text()='Account details']")
    WebElement accountDetailsMA;

    @FindBy(xpath = "//a[text()='Your Waitlists']")
    WebElement yourWaitlistsMA;


    //Info text element in dashboard page
    @FindBy(xpath = "//p[contains(., ', manage your ')]")
    WebElement secondLineInfoText;

    //Info text element in Orders page
    @FindBy(xpath = "//div/div/div/div/a[contains(., 'Browse products')]")
    WebElement browserProductsBtn;

    public MyAccountPage(){PageFactory.initElements(driver, this);}

    //To get My Account info text at my account page
    public String getTextOfMyAccount(){return WebElementUtil.getTextOfElement(myAccountText);}

    //To get Second line info text at DashBoard page.
    public String getTextOfSecondLineInDashBoardPage(){return WebElementUtil.getTextOfElement(secondLineInfoText);}

    //To get info Text of browserProductsBtn at Order page
    public String getBrowserProductsBtn(){return WebElementUtil.getTextOfElement(browserProductsBtn);}

    //To know logout button displayed or not at My account page.
    public boolean logOutBtnDisplayed(){
        return WebElementUtil.getElementDisplayed(logOutBtn);
    }

    //Click Functions for each tab option
    public void clickDashBordMA(){CommonWaits.waitUtilElementToBeClickable(dashBordMA);}
    public void clickOrdersMA(){CommonWaits.waitUtilElementToBeClickable(ordersMA);}
    public void clickSubscriptionsMA(){CommonWaits.waitUtilElementToBeClickable(subscriptionsMA);}
    public void clickCouponsMA(){CommonWaits.waitUtilElementToBeClickable(couponsMA);}
    public void clickAddressesMA(){CommonWaits.waitUtilElementToBeClickable(addressesMA);}
    public void clickPaymentMethodsMA(){CommonWaits.waitUtilElementToBeClickable(paymentMethodsMA);}
    public void clickAccountDetailsMA(){CommonWaits.waitUtilElementToBeClickable(accountDetailsMA);}
    public void clickYourWaitlistsMA(){CommonWaits.waitUtilElementToBeClickable(yourWaitlistsMA);}
}
