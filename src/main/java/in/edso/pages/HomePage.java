package in.edso.pages;

import in.edso.testbase.WebTestBase;
import in.edso.util.CommonWaits;
import in.edso.util.WebElementUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebTestBase {

    /*@FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    List<WebElement> userLogo1; // Help with List <WebElement> we can fetch multiple web elements.*/

    //User controls menu web elements
    @FindBy(xpath = "//a[contains(@class, 'user-controls__ul__li__a')]")
    WebElement userLogo;
    @FindBy(xpath = "//a[contains(@class, 'newsletter__close') and contains(@class, 'newsletter__trigger')]")
    WebElement closeFirstAd;
    @FindBy(xpath = "//a[@class='mini-cart']")
    WebElement miniCart;
    @FindBy(xpath = "//a[contains(@class, 'user-controls__ul__li__a') and contains(@class, 'user-controls__ul__li__a--newsletter') and contains(@class, 'newsletter__trigger')]")
    WebElement signUpToOurNewsLetter;
    @FindBy(className = "search__button")
    WebElement searchIconBtn;


    //Main Menu Tabs web elements
    @FindBy(xpath = "//a[text()='Café Finder']")
    WebElement cafeFinderTab;
    @FindBy(xpath = "//a[text()='Our Story']")
    WebElement ourStoryTab;
    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopTab;
    @FindBy(id = "menu-item-359695")
    WebElement subscriptionsTab;
    @FindBy(xpath = "//a[text()='Brew Guides']")
    WebElement brewGuidesTab;
    @FindBy(xpath = "//a[text()='News']")
    WebElement newsTab;
    @FindBy(xpath = "//a[text()='Wholesale']")
    WebElement wholesaleTab;
    @FindBy(xpath = "//a[contains(text(),'WOOLWORTHS COMP')]")
    WebElement woolWorthsCompTab;


    //Calling constructor to initialize all Web element existing in HomePage.

    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    //Function for closing add with clicked on User logo icon in home page.

    public void closeFirstAd(){
        CommonWaits.waitUtilElementToBeClickable(closeFirstAd);
        CommonWaits.waitUtilElementToBeClickable(userLogo);
    }

    //Function for closing add with-out clicked on User logo icon in home page.

    public void closeFirstAdWithOutClickedUserLogo(){
        CommonWaits.waitUtilElementToBeClickable(closeFirstAd);
    }

    //Functions for click on each menu Tabs.
    public void clickOnCafeFinderTab(){
        CommonWaits.waitUtilElementToBeClickable(cafeFinderTab);
    }

    public void clickOurStoryTab(){
        CommonWaits.waitUtilElementToBeClickable(ourStoryTab);
    }

    public void clickShopTabTab(){
        CommonWaits.waitUtilElementToBeClickable(shopTab);
    }

    public void clickSubscriptionsTab(){
        CommonWaits.waitUtilElementToBeClickable(subscriptionsTab);
    }

    public void clickBrewGuidesTab(){
        CommonWaits.waitUtilElementToBeClickable(brewGuidesTab);
    }

    public void clickNewsTab(){
        CommonWaits.waitUtilElementToBeClickable(newsTab);
    }

    public void clickWholesaleTab(){
        CommonWaits.waitUtilElementToBeClickable(wholesaleTab);
    }

    public void clickWoolWorthsCompTab(){
        CommonWaits.waitUtilElementToBeClickable(woolWorthsCompTab);
    }


}
