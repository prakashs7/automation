package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void isFlipkartLogoVisible() {
        try {
            WebElement otp_PopUp_CloseBtn = driver.findElement(By.xpath("//span[@role='button']"));
            if (otp_PopUp_CloseBtn.isDisplayed()){
                otp_PopUp_CloseBtn.click();
            } else {
                WebElement flipkart_Logo = driver.findElement(By.xpath("//a[@title='Flipkart']//img[@title]"));
                Assert.assertTrue(flipkart_Logo.isDisplayed(),"Flipkart Logo is not displayed");
            }
        }catch (Exception e){
            WebElement flipkart_Logo = driver.findElement(By.xpath("//a[@title='Flipkart']//img[@title]"));
            Assert.assertTrue(flipkart_Logo.isDisplayed(),"Flipkart Logo is not displayed");
        }
    }
    public void searchForProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);

    }
}