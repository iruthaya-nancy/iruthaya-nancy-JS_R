import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        File file = new File("EventListener.html");
        
        // Open the HTML file
        driver.get("file://" + file.getAbsolutePath());
    }
    @Test
    public void testButton1Text1() {
        WebElement text1 = driver.findElement(By.id("text1"));

        Assert.assertEquals("this text will change when button1 is clicked", text1.getText());

        // Find button 1 and click it
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();
    }

    @Test
    public void testButton1Text2() {
        WebElement text2 = driver.findElement(By.id("text2"));

        Assert.assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 1 and click it
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();

    }

    @Test
    public void testButton2Text3() {
        WebElement text3 = driver.findElement(By.id("text3"));

        Assert.assertEquals("this text will change when button2 is clicked", text3.getText());

        // Find button 2 and click it
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();

    }

    @Test
    public void testButton2Text2() {
        WebElement text2 = driver.findElement(By.id("text2"));

        Assert.assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 2 and click it
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();

    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
