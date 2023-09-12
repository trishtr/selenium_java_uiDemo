package models.components.global.header;

import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


@ComponentCssSelector(".header-menu")
public class TopMenuComponent extends Component {


    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<MainCartItem> mainItemElems() throws IllegalAccessException {
        return findComponents(MainCartItem.class, driver);
    }

    @ComponentCssSelector(".top-menu > li")
    public static class MainCartItem extends Component{

        public MainCartItem(WebDriver driver, WebElement component) {
            super(driver, component);
        }

        public WebElement cartItemLinkElem(){
            return component.findElement(By.tagName("a"));
        }

        public List<CartItemComponent> cartItemComps() throws IllegalAccessException {
            Actions actions = new Actions(driver);
            actions.moveToElement(component).perform();
            return findComponents(CartItemComponent.class, driver);
        }

    }

    @ComponentCssSelector(".sublist li a")
    public static class CartItemComponent extends Component {

        public CartItemComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }
    }
}
