package in.edso.util;

import in.edso.testbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil extends WebTestBase {

    public static Actions actions;

    public static void moveToTheElement(WebElement element){
        actions=new Actions(driver);
        actions.moveToElement(element)
                .click()
                .perform();

    }

    public static void dragAndDropToTheElement(WebElement srcElement, WebElement descElement){
        actions=new Actions(driver);
        actions.dragAndDrop(srcElement,descElement)
                .perform();

    }

}
