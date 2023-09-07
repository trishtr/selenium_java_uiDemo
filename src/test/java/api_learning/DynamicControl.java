package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{

            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            By checkboxFormSel = By.id("checkbox-example");


            //narrow down searching element scopes:
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));

            if(!checkboxElem.isSelected()){
                checkboxElem.click();
            };



            //narrow down searching for inputFormSel:
            By inputFormSel = By.id("input-example");
            By inputElemSel = By.tagName("input");
            WebElement inputFormElem = driver.findElement(inputFormSel);
            WebElement inputElem = inputFormElem.findElement(By.tagName("input"));
            WebElement inputBtnElem = inputFormElem.findElement(By.tagName("button"));

            if(!inputElem.isEnabled()){

                inputBtnElem.click();
            }


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            wait.until(ExpectedConditions.invisibilityOf(inputFormElem.findElement(By.id("loading"))));

            inputElem.sendKeys(" testing explicitly wait");


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
