package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class jsExecutor implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(floatingPageSlug));
            scrollToBottom(driver);

            Thread.sleep(3000);

            scrollToTop(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

    private static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");



    }

    private static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(document.body.scrollHeight, 0)");
    }
}