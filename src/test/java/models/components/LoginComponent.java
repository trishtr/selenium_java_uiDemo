package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = "#login")
public class LoginComponent  extends Component{

    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.id("password");


    public LoginComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void inputUsername(String username){
        if(username.isEmpty()) return;
        component.findElement(usernameSel).sendKeys(username);
    }
}
