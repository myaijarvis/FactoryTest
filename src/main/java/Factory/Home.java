package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[1]/td/h2")
    WebElement homePageUserName;

    public Home(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageDashboardUserName(){
        return	homePageUserName.getText();
    }
}
