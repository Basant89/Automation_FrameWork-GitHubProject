package in.edso.util;

import in.edso.testbase.WebTestBase;
import org.openqa.selenium.WebElement;

public class WebElementUtil extends WebTestBase {

    public static void sendTextToElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public static void clickOnElement(WebElement element)
    {
        element.click();
    }

    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    public static boolean getElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

}
