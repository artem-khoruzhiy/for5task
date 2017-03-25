package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by Артем on 21.03.2017.
 */
public class OnlinerPage extends BaseForm {
    private Button btnCatalog = new Button(By.xpath("//span[text()='Каталог']"), "btnCatalog");

    public OnlinerPage(){
        super(By.xpath("//div[@class='b-top-logo']//img"), "Main Page");
    }

    public void clickCatalog(){
        btnCatalog.click();
    }
}
