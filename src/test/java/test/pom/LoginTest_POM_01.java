package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_01 implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(loginSlug));

            LoginPageOld loginPage = new LoginPageOld(driver);
            loginPage.usernameElem().sendKeys("Example");
            loginPage.passwordElem().sendKeys("abc");
            loginPage.loginBntElem().click();

        }catch(Exception e){
            e.printStackTrace();

        }finally {

        }
    }
}
