package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;

import static org.testng.Assert.*;


/**
 * Created by Артем on 21.03.2017.
 */
public class CatalogPage extends BaseForm {
    private String btnOnMenuLocator = "//div[@class='catalog-bar']//a[text()='%s']";
    private Label labelh1 = new Label(By.tagName("h1"));

    public void navigateOnMenu(String section){
        new Button(By.xpath(String.format(btnOnMenuLocator, section))).click();
    }

    public CatalogPage(){
        super(By.xpath("//div[@class='b-top-logo']//img"), "Catalog Page");
    }

    public void checkTruePage(){
        assertEquals("Каталог",labelh1.getText());
    }
}