package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {

    protected final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void inputUsername();
    protected abstract void inputPwd();
    protected abstract void clickOnLoginBtn();
}
