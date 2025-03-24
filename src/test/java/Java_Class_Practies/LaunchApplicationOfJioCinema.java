package Java_Class_Practies;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.healenium.SelfHealingDriver;
import com.jioCinema.utiliti.BaseTest;
import com.jioCinema.utiliti.Web_Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplicationOfJioCinema extends BaseTest{

	static WebDriver driver1;
	static SelfHealingDriver driver;
	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			driver1 = new ChromeDriver();
			driver = SelfHealingDriver.create(driver1);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.jiocinema.com/");
			Thread.sleep(20000);
			if(driver.findElement(By.xpath("//button[contains(@class,'sign-in') and text()='Sign in']")).isDisplayed()) {
				System.out.println("Aplication launched successfully");
			}else {
				System.out.println("unsuccessfully");
			}
			
			driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
