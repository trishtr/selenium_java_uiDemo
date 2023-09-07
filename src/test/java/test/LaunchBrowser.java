package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {

       WebDriver driver  = DriverFactory.getChromeDriver();

//        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        Thread.sleep(3000);

        //quit session
        driver.quit();

    }

}
