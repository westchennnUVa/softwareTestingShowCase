import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

/**
 *
 * Note:
 *   Test environment: Chrome Version 68, selenium 3.14.0, Java 8, ChromeDriver 2.42
 */

public class EmptyTemplateForChrome_Test
{
    private WebDriver driver;
    private String url = "https://cs.gmu.edu:8443/offutt/coverage/LogicCoverage";

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/WestChen/IdeaProjects/untitled/src/test/package_test/path/to/chromedriver");    // specify path the the driver
        driver = new ChromeDriver();    // create an instance of the web browser and open it
        driver.get(url);                // open the given url
    }

    @After
    public void teardown()
    {
        driver.quit();                  // close the browser
    }

    @Test
    public void test_openURL()
    {
        assertEquals(driver.getTitle(), "Logic Coverage");	// check if we are on the right page
    }

    @Test
    public void test_emptyInput(){
        driver.findElement(By.name("action")).click();
        assertTrue(driver.getPageSource().contains("The expression is empty"));
    }

    @Test
    public void test_numericInput(){
        driver.findElement(By.name("expression")).sendKeys("123");
        driver.findElement(By.name("action")).click();
        assertTrue(driver.getPageSource().contains("unexpected char:"));
    }

    @Test
    public void test_validInput(){
        driver.findElement(By.name("expression")).sendKeys("a^b");
        driver.findElement(By.name("action")).click();
        assertTrue(driver.getPageSource().contains("Truth Table:"));
    }

}

