package models.pages;

import models.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginComponent loginComponent() throws IllegalAccessException {
        return findComponent(LoginComponent.class, driver);
    }
}
