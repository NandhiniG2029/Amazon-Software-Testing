package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        // Launch Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser Launched");

        // Open Amazon website
        driver.get("https://www.amazon.in");
        System.out.println("Amazon website opened");

        // Wait 5 seconds to see the browser before running test
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Wait 5 seconds before closing browser so you can see results
        Thread.sleep(5000);

        driver.quit();
        System.out.println("Browser Closed");
    }
}