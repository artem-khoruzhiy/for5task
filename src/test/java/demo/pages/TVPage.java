package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 21.03.2017.
 */
public class TVPage extends BaseForm{
    private Label lblHead = new Label(By.tagName("h1"));
    private ComboBox cbxDiagMin = new ComboBox(By.xpath("//div[@class='schema-filter__fieldset' and ./*/*[text()='Диагональ']]//div[@class='schema-filter__group']/div[1]/select"));
    private ComboBox cbxDiagMax = new ComboBox(By.xpath("//div[@class='schema-filter__fieldset' and ./*/*[text()='Диагональ']]//div[@class='schema-filter__group']/div[2]/select"));
    private TextBox txbMinYear = new TextBox(By.xpath("//input[@placeholder='2010']"));
    private TextBox txtMaxPrice = new TextBox(By.xpath("//input[@placeholder='до']"));
    private Link linkOfProduct = new Link(By.xpath("//div[@class='schema-product__title']/a"));
    private String locatorProducer = "//span[text()='Производитель']/../..//span[text()='%s']/../span[1]";
    private String locForNameOfGood = "//div[@class='schema-product__title']//span";

    public TVPage(){
        super(By.xpath("//div[@class='b-top-logo']//img"), "Page with TVs");
    }

    public void checkTruePage(){
        assertEquals("Телевизоры", lblHead.getText());
    }

    public void setMinYear(String minYear){
        txbMinYear.setText(minYear);
    }

    public void setProducer(String producer){
        CheckBox cbxProducer = new CheckBox(By.xpath(String.format(locatorProducer, producer)));
        cbxProducer.click();
    }

    public void setMaxPrice(String price){
        txtMaxPrice.setText(price);
    }

    public void setMinDiagonal(String minDiag){
        cbxDiagMin.selectByValue(minDiag + "\"");
    }

    public void setMaxDiagonal(String maxDiag){
        cbxDiagMax.selectByValue(maxDiag + "\"");
    }

    public List<String> getListOfLinks(){
        return linkOfProduct.getLinksOfProducts();
    }
}
