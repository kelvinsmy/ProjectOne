import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDemo {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ksze\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("https:www.google.com");
        //j_username j_password signIn
        WebElement elementName = driver.findElement(By.id("j_username"));
        elementName.sendKeys("R5");
        WebElement elementPass = driver.findElement(By.id("j_password"));
        elementPass.sendKeys("P@ssword7");
        WebElement elementLogin = driver.findElement(By.name("signIn"));
        elementLogin.submit();
    }
}
