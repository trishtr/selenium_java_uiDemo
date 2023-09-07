package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover implements Urls {

    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");
    private final static By hoverElemSel = By.className("figure");
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(hovers));
            List<WebElement> hoverElemLst = driver.findElements(hoverElemSel);


            if(hoverElemLst.isEmpty()) {
                throw new RuntimeException("there is no profile image");
            }
            Actions act = new Actions(driver);

            for(WebElement hoverElem : hoverElemLst){
                WebElement descElem = hoverElem.findElement(profileNameSel);
                WebElement profileLinkElem = hoverElem.findElement(profileLinkSel);

                System.out.println(descElem.isDisplayed());

                act.moveToElement(hoverElem).perform();

                System.out.println(descElem.isDisplayed());
                System.out.println(descElem.getText());
                System.out.println(profileLinkElem.getText());
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            driver.quit();
        }
    }
}
