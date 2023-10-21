package org.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class ECommerceTest extends BasePage {

    @Test
    public void testECommerceScenario() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.isFlipkartLogoVisible();
        homePage.searchForProduct("MacBook AIR M2");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickFirstProduct();
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.isItemAddedToCart();
  }
}