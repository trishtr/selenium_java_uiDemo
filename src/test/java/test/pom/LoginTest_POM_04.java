package test.pom;

import api_learning.Urls;
import driver.DriverFactory;
import models.components.LoginComponent;
import models.pages.LoginPage;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

import static api_learning.Urls.baseUrl;
import static api_learning.Urls.loginSlug;

public class LoginTest_POM_04 {

        public static void main(String[] args) {
            WebDriver driver = DriverFactory.getChromeDriver();

            try {
                driver.get(baseUrl.concat(loginSlug));

                LoginPage loginPage = new LoginPage(driver);
                LoginComponent loginComponent = loginPage.loginComponent();
                loginComponent.inputUsername("abc");

            } catch (Exception e) {
                e.printStackTrace();

            } finally {

            }
        }


}
