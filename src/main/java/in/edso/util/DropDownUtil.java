package in.edso.util;

import in.edso.testbase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownUtil extends WebTestBase {

    public static Select select;

    public static void selectDropDownByValue(WebElement element, String value){
        select=new Select(element);
        select.selectByValue(value);
    }

    public static void selectDropDownByVisibleText(WebElement element, String text){
        select=new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectDropDownByVisibleIndex(WebElement element, int index){
        select=new Select(element);
        select.selectByIndex(index);
    }

    public void bootStrapDropDown(List <WebElement> elementList, String text){

        for (WebElement element: elementList)
        {
            if(element.getText().equalsIgnoreCase(text))
            {
                element.click();
                break;
            }
        }
    }
}
