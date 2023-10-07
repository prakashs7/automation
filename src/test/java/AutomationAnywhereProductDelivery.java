import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationAnywhereProductDelivery {

    @Test
    public void productDelivery() {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.automationanywhere.com/");

        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()='Accept All Cookies']"));
        WebDriverWait waitForCookies = new WebDriverWait(driver, Duration.ofMillis(3000));
        waitForCookies.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();

        try {
            Thread.sleep(5000);

            Actions action = new Actions(driver);
            WebElement productsMenu = driver.findElement(By.xpath("(//a[@href='/products'])[1]"));
            action.moveToElement(productsMenu).build().perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
            WebElement discover = driver.findElement(By.xpath("(//span[@title='Discover'])[1]"));
            wait.until(ExpectedConditions.visibilityOf(discover));

            WebElement processDiscoveryLink = driver.findElement(By.xpath("(//a[@title='Process Discovery'])[1]"));
            processDiscoveryLink.click();

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(3000));
            wait1.until(ExpectedConditions.urlToBe("https://www.automationanywhere.com/products/process-discovery"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/products/process-discovery","Current URL is not as expected");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}