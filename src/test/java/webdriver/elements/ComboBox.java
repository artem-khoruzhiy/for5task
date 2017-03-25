package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Артем on 22.03.2017.
 */
public class ComboBox extends BaseElement{

    public ComboBox(final By locator, final String name){
        super(locator, name);
    }

    public ComboBox(String locator, String name){
        super(locator, name);
    }

    public ComboBox(By locator){
        super(locator);
    }

    protected String getElementType(){
        return getLoc("loc.comboBox");
    }

    public void selectByValue(String value){
        waitForIsElementPresent();
        new Select(element).selectByVisibleText(value);
    }
}
