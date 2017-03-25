package demo.tests;

import demo.pages.CatalogPage;
import demo.pages.ConcreteTvPage;
import demo.pages.OnlinerPage;
import demo.pages.TVPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;
import webdriver.Browser;

import java.util.List;

/**
 * Created by Артем on 21.03.2017.
 */
public class TestTvsOnOnliner extends BaseTest {

    private String section, minYear, maxPrice, producer, minDiag, maxDiag;

    @Parameters({"section", "minYear", "maxPrice", "producer", "minDiag", "maxDiag"})
    @BeforeMethod
    public void setup(String section, String minYear, String maxPrice, String producer, String minDiag, String maxDiag){
        this.section = section;
        this.minYear = minYear;
        this.maxPrice = maxPrice;
        this.producer = producer;
        this.minDiag = minDiag;
        this.maxDiag = maxDiag;
    }

    @Override
    public void runTest() {
        OnlinerPage onlinerPage = new OnlinerPage();
        onlinerPage.clickCatalog();

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.checkTruePage();
        catalogPage.navigateOnMenu(section);


        TVPage tvPage = new TVPage();
        tvPage.checkTruePage();
        tvPage.setMinYear(minYear);
        tvPage.setMaxPrice(maxPrice);
        tvPage.setProducer(producer);
        tvPage.setMinDiagonal(minDiag);
        tvPage.setMaxDiagonal(maxDiag);
//        try {
//            Thread.sleep(4000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        List<String> list1 = tvPage.getListOfLinks();
        for (String s : list1){
            browser.getDriver().get(s);
            ConcreteTvPage concreteTvPage = new ConcreteTvPage();
            concreteTvPage.checkPrice(maxPrice);
            concreteTvPage.checkProducer(producer);
            concreteTvPage.checkYear(minYear);
            concreteTvPage.checkDiagonal(minDiag, maxDiag);
        }
    }
}