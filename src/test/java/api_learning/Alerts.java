package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts implements Urls {

    // find cssSelector by attribute : remember to cover with []
    private final static By jsAlertSel = By.cssSelector("[onclick='jsAlert()']");
    private final static By jsPromptSel = By.cssSelector("[onclick='jsPrompt()']");
    private final static By jsConfirmSel = By.cssSelector("[onclick='jsConfirm()']");
    private final static By resultSel = By.cssSelector("#result");



    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(jsAlertPage));

            WebElement triggerJsAlertBtn;
            Alert alert;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));



            triggerJsAlertBtn = driver.findElement(jsAlertSel);
            triggerJsAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println(driver.findElement(resultSel).getText());




            triggerJsAlertBtn = driver.findElement(jsConfirmSel);
            triggerJsAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();
            System.out.println(driver.findElement(resultSel).getText());


            triggerJsAlertBtn = driver.findElement(jsPromptSel);
            triggerJsAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.sendKeys("testing");
            alert.accept();
            System.out.println(driver.findElement(resultSel).getText());


        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
