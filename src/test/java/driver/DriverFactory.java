package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String currentProjectPath = System.getProperty("user.dir");

        String macOSChromePath = "/src/test/resources/drivers/chromedriver";
        String windowsChromePath = "\\src\\test\\resources\\drivers\\chromedriver";
        String relativeChromeDriverPath = OS.isFamilyMac() ? macOSChromePath : windowsChromePath;

        String chromeDriverPath = currentProjectPath.concat(relativeChromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);

        //globally wait for a session
        //if unable to find element, within 5 seconds, it will re-find the element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));

        return driver;
    }
}
