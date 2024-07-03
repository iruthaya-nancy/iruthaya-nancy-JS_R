import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up EdgeDriver path
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver");

        // Create a new EdgeDriver instance
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        driver = new EdgeDriver(options);

        File file = new File("EventListener.html");

        // Open the HTML file
        driver.get("file://" + file.getAbsolutePath());
    }

    @Test
    public void testButton1Text1() {
        WebElement text1 = driver.findElement(By.id("text1"));

        assertEquals("this text will change when button1 is clicked", text1.getText());

        // Find button 1 and click it
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();
    }

    @Test
    public void testButton1Text2() {
        WebElement text2 = driver.findElement(By.id("text2"));

        assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 1 and click it
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();
    }

    @Test
    public void testButton2Text3() {
        WebElement text3 = driver.findElement(By.id("text3"));

        assertEquals("this text will change when button2 is clicked", text3.getText());

        // Find button 2 and click it
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();
    }

    @Test
    public void testButton2Text2() {
        WebElement text2 = driver.findElement(By.id("text2"));

        assertEquals("this text will change when either button1 or button2 is clicked", text2.getText());

        // Find button 2 and click it
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();
    }

 @After
    public void tearDown() {
        // Close the browser window (optional)
        driver.close();

        // Quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
