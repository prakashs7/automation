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
import java.util.Set;
public class ProductPage {
    WebDriver driver;
    String first_Product;
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement firstMatching_Product = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[3]/div[1]/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(firstMatching_Product));
        first_Product = firstMatching_Product.getText().trim();
        firstMatching_Product.click();
    }
    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        Set<String> windows = driver.getWindowHandles();
        for (String window:windows) {
            driver.switchTo().window(window);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement waitForProductToLoad = driver.findElement(By.xpath("//div//h1//span"));
        wait.until(ExpectedConditions.visibilityOf(waitForProductToLoad));
        Assert.assertTrue(waitForProductToLoad.getText().trim().contains(first_Product));
        WebElement addToCart_btn = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCart_btn.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement cart_btn = driver.findElement(By.xpath("//span[text()='Cart']"));
        wait2.until(ExpectedConditions.elementToBeClickable(cart_btn));
        cart_btn.click();
    }
}