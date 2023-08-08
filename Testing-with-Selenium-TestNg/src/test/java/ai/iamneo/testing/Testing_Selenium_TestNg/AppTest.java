package ai.iamneo.testing.Testing_Selenium_TestNg;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AppTest {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver=null;

    @BeforeTest
    public void beforeTest() throws Exception {

        driver = new RemoteWebDriver(new URL("http://34.85.242.216:4444"), chromeOptions);

    }

    @Test
    public void testcase_1() throws InterruptedException // Go to Ebay
    {
        driver.get("https://www.ebay.com/");
    }

    @Test
    public void testcase_2() throws InterruptedException {
       String str="Apple Watches";
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys(str);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"item21b5b50e95\"]/div/div[2]/a/div")); // Assuming the first product is displayed in a list
        String firstProductName = firstProduct.getText();
        
        System.out.println("First Product: " + firstProductName);
        
        Assert.assertEquals(firstProductName, "Apple Watch Series 5 40mm/44mm GPS WiFi + LTE Cellular Sport Band USED Excellent"); // Replace "Expected Product Name" with the actual expected product name
    }

   /*  @Test
    public void testcase_3() throws InterruptedException {
        int nthProductIndex = 10; // Assuming the 10th product index is known
        
        WebElement nthProduct = driver.findElement(By.xpath("//*[@id=\"item269e8867c5\"]/div/div[2]/a/div")); // Assuming the products are displayed in a list
        String nthProductName = nthProduct.getText();
        
        System.out.println("Nth Product (" + nthProductIndex + "): " + nthProductName);
        
        Assert.assertEquals(nthProductName, "Apple Watch Ultra GPS & Cellular 49mm Titanium Trail Alpine Loop Ocean Excellent"); // Replace "Expected Product Name" with the actual expected product name
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }*/

   
}