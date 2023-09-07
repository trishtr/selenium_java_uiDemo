package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@ComponentCssSelector(".top-menu")
public class TopMenuComponent extends Component {

    private final By mainItemSel  = By.cssSelector("li a");
    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<WebElement> mainItemElems(){
        return component.findElements(mainItemSel);
    }
}
