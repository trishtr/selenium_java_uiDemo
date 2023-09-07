package models.components;

import org.openqa.selenium.WebDriver;

public class ExternalLoginPage extends LoginPage{


    public ExternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername() {
        System.out.println("External | Input username");
    }

    @Override
    protected void inputPwd() {
        System.out.println("External | Input username");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("External | Input username");
    }
}
