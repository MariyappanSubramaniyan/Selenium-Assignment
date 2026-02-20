package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver() {

        String browser = ConfigReader.get("browser");
        System.out.println("Browser value: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        else {
            throw new RuntimeException("Browser not supported: " + browser);
        }


    }
}
