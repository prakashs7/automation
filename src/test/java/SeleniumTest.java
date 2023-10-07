import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class SeleniumTest {

    @Test
    void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.automationanywhere.com/");

        Actions action = new Actions(driver);
        WebElement products = driver.findElement(By.xpath("(//a[@href='/products'])[1]"));
        action.moveToElement(products).build().perform();
        Thread.sleep(5000);
        }
//        System.out.println("Title : "+driver.getTitle());
//        Assert.assertEquals("How to Build and Execute Selenium Projects | BrowserStack",driver.getTitle(),"Fail");
//        driver.quit();

    }