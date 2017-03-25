package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.Browser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 23.03.2017.
 */
public class Link extends BaseElement {

    public Link(final By locator, final String name){
        super(locator, name);
    }

    public Link(String locator, String name){
        super(locator, name);
    }

    public Link(By locator){
        super(locator);
    }

    protected String getElementType(){
        return getLoc("loc.link");
    }

    public List<String> getLinksOfProducts(){
        List<WebElement> list = browser.getDriver().findElements(locator);
        List<String> stringLinks = new ArrayList<>();
        for(WebElement w : list){
            stringLinks.add(w.getAttribute("href"));
        }
        return stringLinks;
     }
}
