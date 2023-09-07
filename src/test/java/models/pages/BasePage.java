package models.pages;

import models.components.Component;
import models.components.global.footer.FooterComponent;
import models.components.global.header.TopMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage extends Component {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public FooterComponent footerComponent() throws IllegalAccessException {
        return findComponent(FooterComponent.class, driver);
    }

    public TopMenuComponent topMenuComponent() throws IllegalAccessException {
        return findComponent(TopMenuComponent.class, driver);

    }
}
