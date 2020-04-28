package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPageFactory {

    WebDriver driver;
	
    Login objLogin;
	
    Home objHomePage;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.testfire.net/login.jsp");
    }

    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
        
        objLogin = new Login(driver);
        
        String loginPageTitle = objLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("Altoro Mutual"));
        
        objLogin.loginTo("admin", "admin");
        
        driver.get("https://www.testfire.net/");
        objHomePage = new Home(driver);
        
        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("Congratulations!"));
    }
	
    @AfterTest
    public void close(){
        driver.quit();
    }
}