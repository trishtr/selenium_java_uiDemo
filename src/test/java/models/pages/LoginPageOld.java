package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageOld {

    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("#password");
    private final static By loginBtnSel = By.cssSelector("[type='submit']");

    public LoginPageOld(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameElem() {
        return driver.findElement(usernameSel);
    }

    public WebElement passwordElem() {
        return driver.findElement(passwordSel);
    }

    public WebElement loginBntElem() {
        return driver.findElement(loginBtnSel);
    }

    public void inputUsename(String username) {
        if (username.isEmpty()) return;
        driver.findElement(usernameSel).sendKeys(username);
    }

    public void inputPwd(String pwd) {
        if (pwd.isEmpty()) return;
        driver.findElement(passwordSel).sendKeys(pwd);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtnSel).click();
    }

    //method chaining :
    public LoginPageOld _inputUsername(String username) {
        if (username.isEmpty()) return this;
        driver.findElement(usernameSel).sendKeys(username);
        return this;
    }

    public LoginPageOld _inputPwd(String pwd) {
        if (pwd.isEmpty()) return this;
        driver.findElement(passwordSel).sendKeys(pwd);
        return this;
    }

    public void _clickLoginBtn() {
        driver.findElement(loginBtnSel).click();
//        return this;
//        do not need to return since it's the last method in chains
    }



}
