package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_02 implements Urls {

        public static void main(String[] args) {
            WebDriver driver = DriverFactory.getChromeDriver();

            try{
                driver.get(baseUrl.concat(loginSlug));

                LoginPageOld loginPage = new LoginPageOld(driver);
                loginPage.inputUsename("test");
                loginPage.inputPwd("123");
                loginPage.clickLoginBtn();

            }catch(Exception e){
                e.printStackTrace();

            }finally {

            }
        }

}
