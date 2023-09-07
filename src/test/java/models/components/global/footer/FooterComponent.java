package models.components.global.footer;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".footer")
public class FooterComponent extends Component {

    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InformationColumnComponent informationColumnComponent() throws IllegalAccessException {
        return findComponent(InformationColumnComponent.class, driver);
    }

    public AccountColumnComponent accountColumnComponent() throws IllegalAccessException {
        return findComponent(AccountColumnComponent.class, driver);
    }

    public CustomerServiceColumnComponent customerServiceColumnComponent() throws IllegalAccessException {
        return findComponent(CustomerServiceColumnComponent.class, driver);
    }

    public FollowUsColumnComponent followUsColumnComponent() throws IllegalAccessException {
        return findComponent(FollowUsColumnComponent.class, driver);
    }

}
