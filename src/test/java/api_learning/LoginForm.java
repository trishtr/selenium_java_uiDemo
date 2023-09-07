package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginForm {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get("https://the-internet.herokuapp.com/login");


            //Define locators:
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            //Find element :
            WebElement usernameEle = driver.findElement(usernameSel);
            WebElement loginBtnEle = driver.findElement(loginBtnSel);
            WebElement passwordEle = driver.findElement(passwordSel);

            //Interact with element:
            usernameEle.sendKeys("tomsmith");
            passwordEle.sendKeys("SuperSecretPassword!");
            loginBtnEle.click();

            printCurrentUrlAndTitle(driver);

            By welcomeTextSel = By.cssSelector("h4");
            WebElement welcomeTextElem = driver.findElement(welcomeTextSel);
            System.out.println(welcomeTextElem.getText());


            driver.navigate().back();
            printCurrentUrlAndTitle(driver);

            //Multiple matching elements:
            List<WebElement> loginInputFieldElems = driver.findElements(By.tagName("input"));

            if(loginInputFieldElems.isEmpty()){
                throw new RuntimeException("[ERR]  There is no login form input fields");
            }

            final int username_index = 0;
            final int password_index = 1;

            loginInputFieldElems.get(username_index).clear();
            loginInputFieldElems.get(username_index).sendKeys("tester");
            loginInputFieldElems.get(password_index).sendKeys("password");

            loginBtnEle = driver.findElement(loginBtnSel);
            loginBtnEle.click();


            //Get css selector, validate color:
            WebElement loginMsgElem = driver.findElement(By.cssSelector(".error"));
            String loginMsgBackgroundColor = loginMsgElem.getCssValue("background-color");
            System.out.println(loginMsgBackgroundColor);

            String classAttr = loginMsgElem.getAttribute("class");
            System.out.println(classAttr);

            printCurrentUrlAndTitle(driver);

            //Find the footer

            WebElement footerLinkElem = driver.findElement(By.linkText("Elemental Selenium"));

            System.out.println(footerLinkElem.getText());




        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }


    }

    public static void printCurrentUrlAndTitle (WebDriver driver){
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
}
