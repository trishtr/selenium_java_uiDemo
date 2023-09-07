package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class IFrame implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{

            driver.get(baseUrl.concat(iFramePage));

            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            driver.switchTo().frame(iFrameElem);

            //locate element inside iframe
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("AbC");

            driver.switchTo().defaultContent();
            System.out.println(driver.findElement(By.partialLinkText("Selenium")).getAttribute("href"));




        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            driver.quit();
        }

    }
}
