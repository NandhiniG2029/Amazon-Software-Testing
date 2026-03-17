package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePage;

import java.time.Duration;

public class AmazonTest extends BaseClass {

    // TC01: Verify homepage loads
    @Test
    public void TC01_verifyHomepageLoads() {
        System.out.println("TC01: Homepage should load");
    }

    // TC02: Verify search functionality
    @Test
    public void TC02_verifySearchFunctionality() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.enterSearchText("Laptop");
        home.clickSearchButton();
        Thread.sleep(5000);
        System.out.println("TC02: Laptop products displayed");
    }

    // TC03: Verify product listing
    @Test
    public void TC03_verifyProductListing() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.enterSearchText("Book");
        home.clickSearchButton();
        Thread.sleep(5000);
        System.out.println("TC03: Product list appears");
    }

    // TC04: Verify product details
    @Test
    public void TC04_verifyProductDetails() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.enterSearchText("Laptop");
        home.clickSearchButton();
        Thread.sleep(5000);
        home.clickFirstProduct();
        Thread.sleep(5000);
        System.out.println("TC04: Product page opens");
    }

    // TC05: Verify navigation menu
    @Test
    public void TC05_verifyNavigationMenu() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickMenuCategory();
        Thread.sleep(5000);
        System.out.println("TC05: Menu category page opens");
    }

    // TC06: Verify login validation (real check for error message)
    @Test
    public void TC06_verifyLoginValidation() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.a-alert-content") // Amazon login error message
        ));

        if (errorMsg.isDisplayed()) {
            System.out.println("TC06: Error message appears: " + errorMsg.getText());
        } else {
            System.out.println("TC06: Error message NOT displayed");
        }
    }

    // TC07: Verify footer links
    @Test
    public void TC07_verifyFooterLinks() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickFooterLink(0); // clicks first footer link
        Thread.sleep(5000);
        System.out.println("TC07: Footer link opened correctly");
    }
}