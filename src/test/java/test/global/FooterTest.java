package test.global;

import driver.DriverFactory;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.global.header.TopMenuComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.util.List;

public class FooterTest {

    @Test
    public void testFooterHomePage(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://demowebshop.tricentis.com");
            HomePage homePage = new HomePage(driver);

            TopMenuComponent topMenuComponent = homePage.topMenuComponent();

            List<WebElement> mainItemElems = topMenuComponent.mainItemElems();

            //TODO: throw error when mainItemElems is empty

            WebElement randomMainItemElem = mainItemElems.get(new SecureRandom().nextInt(mainItemElems.size()));

            Thread.sleep(2000);

            FooterComponent footerComponent = homePage.footerComponent();

            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComponent();

            System.out.println(informationColumnComponent.headerElem().getText());
            if(informationColumnComponent.linkElems().isEmpty()){
                throw new RuntimeException("There is no link in footer column");
            }
            informationColumnComponent.linkElems().forEach( link -> {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
            });


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

    @Test
    public void testFooterCategories(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://demowebshop.tricentis.com");
            HomePage homePage = new HomePage(driver);

            FooterComponent footerComponent = homePage.footerComponent();

            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComponent();

            System.out.println(informationColumnComponent.headerElem().getText());
            if(informationColumnComponent.linkElems().isEmpty()){
                throw new RuntimeException("There is no link in footer column");
            }
            informationColumnComponent.linkElems().forEach( link -> {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
            });



        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
