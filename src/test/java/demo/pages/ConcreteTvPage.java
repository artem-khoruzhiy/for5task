package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import static org.testng.Assert.*;

/**
 * Created by Артем on 22.03.2017.
 */
public class ConcreteTvPage extends BaseForm {
    private Label lblHead = new Label(By.tagName("h1"));
    private Label lblPrice = new Label(By.xpath("//div[@class='offers-description__price offers-description__price_primary']/a"));
    private Label lblYear = new Label(By.xpath("//td[contains(text(),'Дата выхода на рынок')]/../td[2]/span"));
    private Label lblDiagonal = new Label(By.xpath("//td[contains(text(), 'Диагональ экрана')]/../td[2]/span"));
    private Label lblOtherPricePlus = new Label(By.xpath("//div[@class='offers-description__price offers-description__price_secondary']/a"));
    private Label lblOtherPriceMinus = new Label(By.xpath("//div[contains(@class, 'offers-description__status_secondary')]"));

    public ConcreteTvPage(){
        super(By.xpath("//div[@class='b-top-logo']//img"), "Concrete TV page");
    }

    public void checkProducer(String producer){
        assertTrue(lblHead.getText().contains(producer));
    }

    public void checkPrice(String price){
        double maxPrice = Double.parseDouble(price);
        if (lblOtherPriceMinus.isPresent()){
            double otherPrice = Double.parseDouble(lblPrice.getText().replaceAll(",", ".").split(" ")[0]);
            assertTrue(otherPrice < maxPrice);
        }
        else{
            double actualMinPrice = Double.parseDouble(lblOtherPricePlus.getText().replaceAll(",", ".").split(" ")[0]);
            assertTrue(actualMinPrice < maxPrice);
        }
    }

    public void checkYear(String year){
        int actualYear = Integer.parseInt(lblYear.getText().substring(0, 4));
        int y = Integer.parseInt(year);
        assertTrue(actualYear >= y);
    }

    public void checkDiagonal(String diagonalMin, String diagonalMax){
        int dMin = Integer.parseInt(diagonalMin);
        int dMax = Integer.parseInt(diagonalMax);
        int actualDiagonal = Integer.parseInt(lblDiagonal.getText().substring(0,2));
        assertTrue(actualDiagonal <= dMax && actualDiagonal >= dMin);
    }
}