package drivermanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverManager {
    WebDriver driver = null;
   //threadLocal object for driver
    public static ThreadLocal<WebDriver> mydriver = new ThreadLocal<>();
    public  WebDriver launchBrowser(String browser) {
        if (browser.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            mydriver.set(new ChromeDriver(options));
        } else if (browser.equals("Firefox")) {
            mydriver.set(new FirefoxDriver());
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return mydriver.get();
    }

}