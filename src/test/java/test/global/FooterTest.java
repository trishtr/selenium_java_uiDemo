package test.global;

import driver.DriverFactory;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.global.header.TopMenuComponent;
import models.components.global.header.TopMenuComponent.CartItemComponent;
import models.components.global.header.TopMenuComponent.MainCartItem;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class FooterTest {

    @Test
    public void testFooterCategories(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://demowebshop.tricentis.com");
            HomePage homePage = new HomePage(driver);

            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCartFooterComp();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

    @Test
    public void testFooterHomePage(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://demowebshop.tricentis.com");
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComp();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }

    @Test
    public void testFooterRegisterPage(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://demowebshop.tricentis.com/register");
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComp();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
