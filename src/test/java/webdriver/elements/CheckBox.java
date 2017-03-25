package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Created by Артем on 22.03.2017.
 */
public class CheckBox extends BaseElement {

    public CheckBox(final By locator, final String name){
        super(locator, name);
    }

    public CheckBox(String locator, String name){
        super(locator, name);
    }

    public CheckBox(By locator){
        super(locator);
    }

    protected String getElementType(){
        return getLoc("loc.checkBox");
    }
}
