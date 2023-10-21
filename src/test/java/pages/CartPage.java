package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage {

   WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;

    }

    public void isItemAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement placeOrder_btn = driver.findElement(By.xpath("//span[text()='Place Order']"));
        wait.until(ExpectedConditions.visibilityOf(placeOrder_btn));
        WebElement product_name = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        Assert.assertTrue(product_name.getText().trim().contains("MacBook AIR M2"));
    }
}