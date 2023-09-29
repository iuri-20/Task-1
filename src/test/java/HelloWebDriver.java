import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelloWebDriver {


    public static void main(String[] args) {

        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);


        WebDriver driver = new ChromeDriver(handlingSSL);
        driver.get("https://pastebin.com/");

        Duration timeout = Duration.ofSeconds(10);
        WebElement textInput = waitForElementLocatedBy(driver, timeout, By.id("postform-text"));
        textInput.sendKeys("Hello from WebDriver");

        WebElement pasteExpirationDropdown = waitForElementLocatedBy(driver, timeout, By.id("select2-postform-expiration-container"));
        pasteExpirationDropdown.click();

        WebElement pasteExpirationValue = waitForElementLocatedBy(driver, timeout, By.xpath("//li[text()='10 Minutes']"));
        pasteExpirationValue.click();

        WebElement titleInput = waitForElementLocatedBy(driver, timeout, By.id("postform-name"));
        titleInput.sendKeys("helloweb");


        driver.quit();

    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, Duration timeout, By by) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
