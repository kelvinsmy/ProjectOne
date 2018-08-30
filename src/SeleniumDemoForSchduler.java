import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDemoForSchduler {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ksze\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("http://192.168.56.102:8075/ngfis-batch/adhoc.html");
        //j_username j_password signIn
        WebElement elementName = driver.findElement(By.name("serviceName"));
        elementName.sendKeys("WbostdService");
        WebElement elementPass = driver.findElement(By.name("methodName"));
        elementPass.sendKeys("sendPoDeliveryAlert");
        WebElement elementLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        elementLogin.submit();
    }
}
