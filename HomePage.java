package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    public By searchBox = By.id("twotabsearchtextbox"); 
    public By searchButton = By.id("nav-search-submit-button"); 
    public By firstProduct = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"); 
    public By menuCategory = By.id("nav-hamburger-menu"); 
    public By loginButton = By.id("nav-link-accountList"); 
    public By footerLinks = By.cssSelector("div.navFooterVerticalRow a"); 

    // Actions
    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickFirstProduct() {
        driver.findElements(firstProduct).get(0).click();
    }

    public void clickMenuCategory() {
        driver.findElement(menuCategory).click();
    }

    // Safe login click
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        try {
            loginBtn.click();
        } catch (Exception e) {
            // fallback to JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
        }
    }

    // Safe footer link click
    public void clickFooterLink(int index) {
        WebElement link = driver.findElements(footerLinks).get(index);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(link));

        try {
            link.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }
    }
}