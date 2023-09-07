package models.components;

import org.openqa.selenium.WebDriver;

public class InternalLoginPage extends LoginPage{

    public InternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername() {
        System.out.println("Internal | Input username");
    }

    @Override
    protected void inputPwd() {
        System.out.println("Internal | Input pwd");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("Internal | Click on Login Btn");

    }
}
